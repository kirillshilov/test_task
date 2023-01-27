package com.example.test_task.Controllers;

import com.example.test_task.Api.ApiSock;
import com.example.test_task.Services.SockServiceImpl;
import com.example.test_task.models.SocksIncome;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks/")

public class SockController implements ApiSock {
    private final SockServiceImpl sockServiceImpl;

    public SockController(SockServiceImpl sockServiceImpl) {
        this.sockServiceImpl = sockServiceImpl;
    }

    @GetMapping
    public ResponseEntity<String> getAllSocksWithParam(@RequestParam(required = false) String color,
                                                       @RequestParam(required = false) String operation,
                                                       @RequestParam(required = false) Integer cottonPart) {
        return ResponseEntity.ok(sockServiceImpl.getAllSocksWithParam(color, operation, cottonPart));
    }
    @PostMapping ("/income")
    public ResponseEntity <String> addSocks (@RequestBody SocksIncome socksIncome){
        return ResponseEntity.ok(sockServiceImpl.addSocks(socksIncome));
    }
    @DeleteMapping ("/outcome")
    public ResponseEntity <String> deleteSocks (@RequestBody SocksIncome socksIncome){
        return ResponseEntity.ok(sockServiceImpl.deleteSocks(socksIncome));
    }
}
