// FinancialForecasting.java
public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double predictFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: if periods are zero, return the initial value
        if (periods == 0) {
            return initialValue;
        }

        // Recursive case: calculate the future value for the next period
        return predictFutureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialValue = 1000; // Initial investment amount
        double growthRate = 0.05; // Growth rate of 5%
        int periods = 10; // Number of periods (years)

        double futureValue = predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " years: " + futureValue);
    }
}
