import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Enter the number of month from 1 - 12:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Error... Number of month should be from 1 - 12. Try again:");
            return;
        }

        System.out.println("Enter the day from 1 - 30:");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Error... Number of month should be from 1 - 30. Try again:");
            return;
        }

        System.out.println("Enter amount of steps:");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Error... You wrote incorrect amount of steps. Try again:");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Enter the new goal for steps per day:");
        int stepsGoal = scanner.nextInt();

        if(stepsGoal <= 0){
            System.out.println("Enter the new goal for steps, it should be more then 0. Try again:");
            return;
        }
        goalByStepsPerDay = stepsGoal;

        System.out.println("New goal for steps per day: " + goalByStepsPerDay + " steps");
    }

    public void printStatistics(){

        System.out.println("Enter the number of month from 1 - 12");
        int month = scanner.nextInt();

        if (month < 1 || month > 12){
            System.out.println("Ypu wrote an incorrect number, try again:");
            return;
        }

        MonthData monthData = monthToData[month - 1];

        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);

        int maxSteps = monthData.maxSteps();
        System.out.println("Максимальное количество шагов в месяце: " + maxSteps);

        int averageStepsOfDay = sumSteps / 30;
        System.out.println("Среднее количество шагов: " + averageStepsOfDay);

        int stepsKilo = converter.convertToKm(sumSteps);
        System.out.println("Пройденная дистанция (в км): " + stepsKilo);

        int kiloKal = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("Количество сожжённых килокалорий: " + kiloKal);

        int bestSe = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия: " + bestSe + " дней подряд");
    }
}
