package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task6Test {
    Task6.Stock[] inputStocks = {new Task6.Stock("comp1", 1000),
        new Task6.Stock("comp2", 1), new Task6.Stock("comp3", 101.1)};

    @Test
    void testForAddAndMostValuableStock() {
        Task6.StockMarket market = new Task6.StockMarket();
        market.add(inputStocks[1]);
        assertThat(market.mostValuableStock()).isEqualTo(inputStocks[1]);
        market.add(inputStocks[0]);
        assertThat(market.mostValuableStock()).isEqualTo(inputStocks[0]);
        market.add(inputStocks[2]);
        assertThat(market.mostValuableStock()).isEqualTo(inputStocks[0]);
    }
    @Test
    void testForRemove(){
        Task6.StockMarket market = new Task6.StockMarket();
        market.add(inputStocks[0]);
        market.add(inputStocks[1]);
        market.add(inputStocks[2]);

        market.remove(inputStocks[0]);
        assertThat(market.mostValuableStock()).isEqualTo(inputStocks[2]);
        market.remove(inputStocks[0]);
        market.remove(inputStocks[2]);
        assertThat(market.mostValuableStock()).isEqualTo(inputStocks[1]);
        market.remove(inputStocks[1]);
        assertThat(market.mostValuableStock()).isEqualTo(null);

    }


}
