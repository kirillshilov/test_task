package com.example.test_task.Api;

import com.example.test_task.models.SocksIncome;
import org.springframework.http.ResponseEntity;


public interface ApiSock {

    public ResponseEntity<String> getAllSocksWithParam(String color, String operation, Integer cottonPart);

    public ResponseEntity<String> addSocks(SocksIncome socksIncome);

    public ResponseEntity<String> deleteSocks(SocksIncome socksIncome);
}
