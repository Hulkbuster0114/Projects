import java.util.Scanner;

public class FrankMacroTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalProteins = 0;
        int totalFats = 0;
        int totalCarbs = 0;
        int totalAlcohol = 0; // Variable for alcohol grams
        int dailyCalorieGoal = 0;

        System.out.print("Enter your daily calorie goal: ");
        dailyCalorieGoal = scanner.nextInt();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter Macros (Protein, Fat, Carbs, Alcohol)");
            System.out.println("2. Show Current Macros and Calorie Intake");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter protein grams: ");
                    totalProteins += scanner.nextInt();
                    System.out.print("Enter fat grams: ");
                    totalFats += scanner.nextInt();
                    System.out.print("Enter carbs grams: ");
                    totalCarbs += scanner.nextInt();
                    System.out.print("Enter alcohol grams: ");
                    totalAlcohol += scanner.nextInt();
                    System.out.println("Macros added.");
                    break;
                case 2:
                    int currentCalories = calculateCalories(totalProteins, totalFats, totalCarbs, totalAlcohol);
                    System.out.println("Current Macros:");
                    System.out.println("Protein: " + totalProteins + "g");
                    System.out.println("Fat: " + totalFats + "g");
                    System.out.println("Carbs: " + totalCarbs + "g");
                    System.out.println("Alcohol: " + totalAlcohol + "g");
                    System.out.println("Estimated Calorie Intake: " + currentCalories + " kcal");
                    System.out.println("Daily Calorie Goal: " + dailyCalorieGoal + " kcal");
                    if (currentCalories > dailyCalorieGoal) {
                        System.out.println("You have exceeded your daily calorie goal by " + (currentCalories - dailyCalorieGoal) + " kcal.");
                    } else {
                        System.out.println("You are " + (dailyCalorieGoal - currentCalories) + " kcal away from reaching your daily goal.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static int calculateCalories(int proteins, int fats, int carbs, int alcohol) {
        return (proteins * 4) + (fats * 9) + (carbs * 4) + (alcohol * 7);
    }
}