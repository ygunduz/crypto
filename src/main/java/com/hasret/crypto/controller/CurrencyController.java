package com.hasret.crypto.controller;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerStatistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    private final BinanceApiRestClient client;

    public CurrencyController(BinanceApiRestClient client) {
        this.client = client;
    }

    @GetMapping("/{pair}")
    public BigDecimal price(@PathVariable String pair) {
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(pair);
        return new BigDecimal(tickerStatistics.getLastPrice());
    }
}
