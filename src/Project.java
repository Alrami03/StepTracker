import java.util.Scanner;
import java.util.Arrays;

public class Project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistics();
            } else if (command == 4) {
                System.out.println("Application is closing");
                return;
            } else {
                System.out.println("This command is not available");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Available commands:");
        System.out.println("1. Enter amount of steps in day");
        System.out.println("2. Change goal for steps in day");
        System.out.println("3. Print statistics for month");
        System.out.println("4. Exit the application.");
    }
}
