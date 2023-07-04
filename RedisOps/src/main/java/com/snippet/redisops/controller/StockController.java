package com.snippet.redisops.controller;

import com.snippet.redisops.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by whr on 2023-05-31
 */
@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/deduct0")
    public <T> ResponseEntity<T> deduct0(@RequestParam Long stockId) {
        return stockService.stockByRedisTemplate(stockId) > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/deduct1")
    public <T> ResponseEntity<T> deduct1(@RequestParam Long stockId) {
        return stockService.stockByRedisson(stockId) > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/deduct2")
    public <T> ResponseEntity<T> deduct2(@RequestParam Long stockId) {
        return stockService.stockByMP(stockId) > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/deduct3")
    public <T> ResponseEntity<T> deduct3(@RequestParam Long stockId) {
        return stockService.stockByDB(stockId) > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
