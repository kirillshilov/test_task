package com.example.test_task.Services.Impl;

import com.example.test_task.models.SocksIncome;

public interface SockService {
    String getAllSocksWithParam(String color, String operation, Integer cottonPart);

    String addSocks(SocksIncome socksIncome);

    String deleteSocks(SocksIncome socksIncome);
}
