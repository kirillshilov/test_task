package com.example.test_task.Controllers;

import com.example.test_task.Api.ApiSock;
import com.example.test_task.Services.SockServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")

public class SockController implements ApiSock {
private final SockServiceImpl sockServiceImpl;

    public SockController(SockServiceImpl sockServiceImpl) {
        this.sockServiceImpl = sockServiceImpl;
    }

    @GetMapping
public ResponseEntity <String> getAllSocksWithParam (@RequestParam String color, @RequestParam String operation, @RequestParam Integer cottonPart){
        return sockServiceImpl.getAllSocksWithParam(color, operation, cottonPart);
    }
}
