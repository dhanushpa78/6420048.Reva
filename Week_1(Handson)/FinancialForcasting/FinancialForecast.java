import java.util.Scanner;

public class FinancialForecast {

    public static double computeAverageGrowthRate(double[] pastValues) {
        double totalGrowth = 0;
        for (int i = 1; i < pastValues.length; i++) {
            double growth = (pastValues[i] - pastValues[i - 1]) / pastValues[i - 1];
            totalGrowth += growth;
        }
        return totalGrowth / (pastValues.length - 1);
    }

    public static double predictFutureValue(double lastValue, double rate, int yearsAhead) {
        if (yearsAhead == 0) return lastValue;
        return predictFutureValue(lastValue, rate, yearsAhead - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of past years of data: ");
        int n = scanner.nextInt();
        double[] pastValues = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for year " + (i + 1) + ": ");
            pastValues[i] = scanner.nextDouble();
        }

        System.out.print("Enter how many future years to predict: ");
        int yearsToPredict = scanner.nextInt();

        double avgRate = computeAverageGrowthRate(pastValues);
        double lastValue = pastValues[pastValues.length - 1];

        double predicted = predictFutureValue(lastValue, avgRate, yearsToPredict);

        System.out.printf("\nAverage Growth Rate: %.2f%%\n", avgRate * 100);
        System.out.printf("Predicted Value after %d years: ₹%.2f\n", yearsToPredict, predicted);

        scanner.close();
    }
}