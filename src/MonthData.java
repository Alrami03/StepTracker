public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + "day: " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        /*
          for (int steps : days) {
        sumSteps += steps;
    }
         */

        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        /*
        for (int steps : days) {
        if (steps > max) {
            max = steps;
        }
    }
        */
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0; // текущая серия
        int finalSeries = 0; // максимальная серия

        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (days[i] > goalByStepsPerDay) {
                currentSeries++;  // продолжаем серию
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries; // обновляем рекорд
                }
            } else {
                currentSeries = 0; // сбрасываем, серия прервана
            }
        }
        return finalSeries;
    }
}