package com.example.test_task.Services;

import com.example.test_task.Repositories.SockRepository;
import com.example.test_task.Services.Impl.SockService;
import org.springframework.stereotype.Service;

@Service
public class SockServiceImpl implements SockService {
    private final SockRepository sockRepository;

    public SockServiceImpl(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    public String getAllSocksWithParam(String color, String operation, Integer cottonPart) {
        return
    }
}
