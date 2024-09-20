import java.util.ArrayList;
import java.util.Scanner;

public class SportsBuddy {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Sport> sportsList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sports Buddy Menu ---");
            System.out.println("1. Add a Sport");
            System.out.println("2. View Sports List");
            System.out.println("3. Update Sport Statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addSport();
                    break;
                case 2:
                    viewSportsList();
                    break;
                case 3:
                    updateSportStats();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addSport() {
        System.out.print("Enter the name of the sport: ");
        String name = scanner.nextLine();
        System.out.print("Enter the number of games played: ");
        int gamesPlayed = scanner.nextInt();
        System.out.print("Enter the number of wins: ");
        int wins = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        sportsList.add(new Sport(name, gamesPlayed, wins));
        System.out.println("Sport added successfully!");
    }

    private static void viewSportsList() {
        if (sportsList.isEmpty()) {
            System.out.println("No sports available.");
            return;
        }

        System.out.println("\n--- List of Sports ---");
        for (Sport sport : sportsList) {
            System.out.println(sport);
        }
    }

    private static void updateSportStats() {
        System.out.print("Enter the name of the sport to update: ");
        String name = scanner.nextLine();

        for (Sport sport : sportsList) {
            if (sport.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter the new number of games played: ");
                int gamesPlayed = scanner.nextInt();
                System.out.print("Enter the new number of wins: ");
                int wins = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                sport.setGamesPlayed(gamesPlayed);
                sport.setWins(wins);
                System.out.println("Statistics updated successfully!");
                return;
            }
        }

        System.out.println("Sport not found.");
    }
}

class Sport {
    private String name;
    private int gamesPlayed;
    private int wins;

    public Sport(String name, int gamesPlayed, int wins) {
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return String.format("Sport: %s, Games Played: %d, Wins: %d", name, gamesPlayed, wins);
    }
}
