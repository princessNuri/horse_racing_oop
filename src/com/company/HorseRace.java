package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HorseRace {

    private static final int NUMBER_OF_HORSES = 7;
    private static final int MAX_BET_AMOUNT = 100;
    private static final Random random = new Random();

    private final List<Horse> horses = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        // Add horses to the race
        for (int i = 1; i <= NUMBER_OF_HORSES; i++) {
            horses.add(new Horse(i));
        }

        // Place bets
        placeBets();

        // Run the race
        Horse winner = runRace();

        // Calculate and display winnings
        calculateWinnings(winner);
    }

    private void placeBets() {
        for (Horse horse : horses) {
            System.out.printf("Enter your bet for horse #%d (maximum bet amount is $%d): ", horse.getNumber(), MAX_BET_AMOUNT);
            int betAmount = scanner.nextInt();

            while (betAmount > MAX_BET_AMOUNT) {
                System.out.printf("The maximum bet amount is $%d. Please enter a valid bet amount: ", MAX_BET_AMOUNT);
                betAmount = scanner.nextInt();
            }

            Bet bet = new Bet(betAmount);
            horse.addBet(bet);
        }
    }

    private Horse runRace() {
        System.out.println("The race is starting...");

        // Simulate the race by randomly selecting a winner
        int winnerNumber = random.nextInt(NUMBER_OF_HORSES) + 1;
        return horses.get(winnerNumber - 1);
    }

    private void calculateWinnings(Horse winner) {
        System.out.printf("Horse #%d won the race!\n", winner.getNumber());

        for (Horse horse : horses) {
            int totalBetAmount = horse.getTotalBetAmount();
            int winnings = 0;

            if (horse == winner) {
                winnings = totalBetAmount * 2;
                System.out.printf("Congratulations! You won $%d on horse #%d!\n", winnings, horse.getNumber());
            } else {
                System.out.printf("Sorry, you lost your $%d bet on horse #%d.\n", totalBetAmount, horse.getNumber());
            }
        }
    }

    public static void main(String[] args) {
        HorseRace race = new HorseRace();
        race.start();
    }
}




