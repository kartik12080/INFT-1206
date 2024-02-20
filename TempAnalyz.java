// Name: Kartik Pandit
// Date: 19 feb 2024
// Description: This Java programs examines temperature data over a set number of days, calculating and presenting the lowest, highest, and average temperatures reported. It validates input and gives user-friendly suggestions for data entering.

import java.util.Scanner;

public class TempAnalyz {
    private static Scanner userInputScanner = new Scanner(System.in);
    public static final int MAX_ALLOWED_TEMP = 45;
    public static final int MIN_ALLOWED_TEMP = -45;
    public static int totalDays;

    public static void main(String[] args) {
        System.out.println("Welcome to the Temperature Analysis System");

        System.out.println("Enter the number of days (Between 1 and 365):");
        totalDays = validateUserInput();

        double[] highTemps = new double[totalDays];
        double[] lowTemps = new double[totalDays];
        double[] avgTemperatures = new double[totalDays];
        int lowestTempIndex = 0;
        int highestTempIndex = 0;
        double overallAvgTemp = 0;

        for (int i = 0; i < totalDays; i++) {
            System.out.print("Enter the highest temperature for day " + (i + 1) + ": ");
            highTemps[i] = validateTemperatureInput();

            System.out.print("Enter the lowest temperature for day " + (i + 1) + ": ");
            lowTemps[i] = validateTemperatureInput();

            avgTemperatures[i] = (highTemps[i] + lowTemps[i]) / 2;
            overallAvgTemp += avgTemperatures[i];

            if (lowTemps[i] < lowTemps[lowestTempIndex]) {
                lowestTempIndex = i;
            }

            if (highTemps[i] > highTemps[highestTempIndex]) {
                highestTempIndex = i;
            }
        }

        System.out.println("Lowest recorded temperature was " + lowTemps[lowestTempIndex] + " on day " + (lowestTempIndex + 1));
        System.out.println("Highest recorded temperature was " + highTemps[highestTempIndex] + " on day " + (highestTempIndex + 1));
        System.out.println("Overall average temperature recorded was " + (overallAvgTemp / totalDays));
    }

    static int validateUserInput() {
        int days;
        while (true) {
            days = userInputScanner.nextInt();
            if (days >= 1 && days <= 365) {
                return days;
            } else {
                System.out.println("Please enter a number between 1 and 365:");
            }
        }
    }

    static double validateTemperatureInput() {
        double temp;
        while (true) {
            try {
                temp = Double.parseDouble(userInputScanner.next());
                if (temp <= MAX_ALLOWED_TEMP && temp >= MIN_ALLOWED_TEMP) {
                    return temp;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + MIN_ALLOWED_TEMP + " and " + MAX_ALLOWED_TEMP + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                userInputScanner.next(); // Consume the invalid input
            }
        }
    }
}
