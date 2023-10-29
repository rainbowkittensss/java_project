package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.UUID;

public class Task6 {
    private Task6() {
    }

    static Comparator<Stock> compByValue = Comparator.comparingDouble(Stock::value);

    interface StockMarketInterface {
        /** Добавить акцию */
        void add(Stock stock);

        /** Удалить акцию */
        void remove(Stock stock);

        /** Самая дорогая акция */
        Stock mostValuableStock();
    }

    static class Stock {
        private String company;
        double value;
        UUID id;

        Stock(String companyArg, double valueArg) {
            company = companyArg;
            value = valueArg;
            id = UUID.randomUUID();
        }

        public double value() {
            return value;
        }
    }

    static class StockMarket implements StockMarketInterface {
        private final PriorityQueue<Stock> stocks;

        StockMarket() {
            stocks = new PriorityQueue<>(compByValue);
        }

        @Override
        public void add(Stock stock) {
            stocks.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            stocks.remove(stock);
        }

        @Override
        public Stock mostValuableStock() {
            return stocks.peek();
        }
    }
}
