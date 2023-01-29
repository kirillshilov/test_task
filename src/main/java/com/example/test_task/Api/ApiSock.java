package com.example.test_task.Api;

import com.example.test_task.models.SocksIncome;
import org.springframework.http.ResponseEntity;


public interface ApiSock {
    /**
     * Метод для поска носков на складе.
     *
     * @param color      цвет носков
     * @param operation  операция сравнения содеражания хлопка moreThan, lessThan, equal вводится в виде строки
     * @param cottonPart искомый процент содержания хлопка
     * @return String Возвращает текстовую интерпритацию кол-ва насков с заданными параметрами. которые находятся в базе.
     * @throws org.springframework.web.client.HttpClientErrorException.BadRequest если заданы неверные параметры носков
     */
     ResponseEntity<String> getAllSocksWithParam(String color, String operation, Integer cottonPart);

    /**
     * Метод для добавления носков. Метод принимает Json объект в полях которого указано:
     * color - цвет носков которые необходимо добавить
     * cottonPart - содержание хлопка в процентах
     * quantity - коллическво носков которое необходимо добавить на склад.
     *
     * @param socksIncome
     * @return Возвращает сообщение об успешном добавлении партии носков. Либо ошибку.
     * @throws org.springframework.web.client.HttpClientErrorException.BadRequest если заданы неверные параметры носков
     */
     ResponseEntity<String> addSocks(SocksIncome socksIncome);

    /**
     * Метод для удаления носков. Метод принимает Json объект в полях которого указано:
     * color - цвет носков которые необходимо удалить
     * cottonPart - содержание хлопка в процентах
     * quantity - коллическво носков которое необходимо удалить со склада.
     *
     * @param socksIncome
     * @return Возвращает сообщение об успешном удалении партии носков. Либо ошибку.
     * @throws org.springframework.web.client.HttpClientErrorException.BadRequest если заданы неверные параметры носков
     */
     ResponseEntity<String> deleteSocks(SocksIncome socksIncome);
}
