package com.example.test_task.Services;

import com.example.test_task.Exceptions.BackendErrorException;
import com.example.test_task.Exceptions.WrongParametersException;
import com.example.test_task.Repositories.SockRepository;
import com.example.test_task.Services.Impl.SockService;
import com.example.test_task.models.Sock;
import com.example.test_task.models.SocksIncome;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SockServiceImpl implements SockService {
    private final SockRepository sockRepository;

    public SockServiceImpl(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    @Override
    public String getAllSocksWithParam(String color, String operation, Integer cottonPart) {
        if (color.isBlank() || operation.isBlank() || cottonPart < 0 || cottonPart > 100) {
            throw new WrongParametersException("Введены неверные параметры. Или параметры отсутствуют");
        }
        if (operation.equals("moreThan")) {
            return String.valueOf(sockRepository.findAllByColorIgnoreCaseAndCottonPartAfter(color, cottonPart).size());
        }
        if (operation.equals("lessThan")) {
            return String.valueOf(sockRepository.findAllByColorIgnoreCaseAndCottonPartBefore(color, cottonPart).size());
        }
        if (operation.equals("equal")) {
            return String.valueOf(sockRepository.findAllByColorIgnoreCaseAndCottonPartIs(color, cottonPart).size());
        }
        throw new BackendErrorException("Непредвиденная ошибка сервера");
    }

    @Override
    public String addSocks(SocksIncome socksIncome) {
        variableCheckingMethod(socksIncome);
        Sock sock = parametrizedSock(socksIncome);
        for (int i = 0; i < socksIncome.getQuantity(); i++) {
            sockRepository.save(sock);
        }
        return "Партия носков " + sock + "успешно добавленна";
    }

    @Override
    public String deleteSocks(SocksIncome socksIncome) {
        variableCheckingMethod(socksIncome);
        Sock sock = parametrizedSock(socksIncome);
        List<Sock> sockList = sockRepository.findAllByColorIgnoreCaseAndCottonPartIs(sock.getColor(), sock.getCottonPart());
        if (sockList.size() < socksIncome.getQuantity()) {
            return "На складе меньше носков чем необходимо удалить! Всего на складе находится" + sockList.size() + "носков с такими характеристиками";
        }
        for (int i = 0; i < socksIncome.getQuantity(); i++) {
            sockRepository.deleteById(sockList.get(i).getId());
        }
        return "Партия носков " + sock + "успешно удаленна";
    }

    private static Sock parametrizedSock(SocksIncome socksIncome) {
        Sock sock = new Sock();
        sock.setColor(socksIncome.getColor());
        sock.setCottonPart(socksIncome.getCottonPart());
        sock.setId(0L);
        return sock;
    }

    private static void variableCheckingMethod(SocksIncome socksIncome) {
        if (socksIncome.getColor().isBlank() || socksIncome.getCottonPart() < 0 || socksIncome.getCottonPart() > 100 || socksIncome.getQuantity() <= 0) {
            throw new WrongParametersException("Введены неверные параметры. Или параметры отсутствуют");
        }
    }
}