package com.company;
import java.util.ArrayList;
import java.util.List;

public class Horse {

    private final int number;
    private int totalBetAmount = 0;
    private final List<Bet> bets = new ArrayList<>();

    public Horse(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addBet(Bet bet) {
        bets.add(bet);
        totalBetAmount += bet.getAmount();
    }

    public int getTotalBetAmount() {
        return totalBetAmount;
    }
}