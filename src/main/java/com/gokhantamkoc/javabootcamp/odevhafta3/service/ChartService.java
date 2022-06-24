package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

import java.io.IOException;
import java.util.List;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() {
		// Bu metodu doldurmanizi bekliyoruz.

        CandleStickChart candleStickChart = new CandleStickChart("BTC/USDT Chart");
        List<Candle> candles;
        try {
            candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Candle candle : candles) {
            candleStickChart.addCandle(
                    candle.getTime(),
                    candle.getClose(),
                    candle.getHigh(),
                    candle.getLow(),
                    candle.getOpen(),
                    candle.getVolume()
            );
        }
        return candleStickChart;
	}
}
