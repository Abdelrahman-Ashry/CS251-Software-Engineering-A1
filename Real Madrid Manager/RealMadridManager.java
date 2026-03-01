import java.util.ArrayList;
import java.util.Scanner;

class Player {
    String name;
    String position;
    String nation;
    int number;

    public Player(String name, String position, String nation, int number) {
        this.name = name;
        this.position = position;
        this.nation = nation;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("#%-2d | %-20s | %-10s | %s", number, name, position, nation);
    }
}

public class RealMadridManager {
    private static final ArrayList<Player> squad = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initializing Squad from provided data
        squad.add(new Player("Thibaut Courtois", "GK", "BEL", 1));
        squad.add(new Player("Dani Carvajal", "DF", "ESP", 2));
        squad.add(new Player("Éder Militão", "DF", "BRA", 3));
        squad.add(new Player("David Alaba", "DF", "AUT", 4));
        squad.add(new Player("Jude Bellingham", "MF", "ENG", 5));
        squad.add(new Player("Eduardo Camavinga", "MF", "FRA", 6));
        squad.add(new Player("Vinícius Júnior", "FW", "BRA", 7));
        squad.add(new Player("Federico Valverde", "MF", "URU", 8));
        squad.add(new Player("Kylian Mbappé", "FW", "FRA", 10));
        squad.add(new Player("Rodrygo", "FW", "BRA", 11));
        squad.add(new Player("Trent Alexander-Arnold", "DF", "ENG", 12));
        squad.add(new Player("Andriy Lunin", "GK", "UKR", 13));
        squad.add(new Player("Aurélien Tchouaméni", "MF", "FRA", 14));
        squad.add(new Player("Arda Güler", "MF", "TUR", 15));
        squad.add(new Player("Gonzalo García", "FW", "ESP", 16));
        squad.add(new Player("Raúl Asencio", "DF", "ESP", 17));
        squad.add(new Player("Álvaro Carreras", "DF", "ESP", 18));
        squad.add(new Player("Dani Ceballos", "MF", "ESP", 19));
        squad.add(new Player("Fran García", "DF", "ESP", 20));
        squad.add(new Player("Brahim Díaz", "FW", "MAR", 21));
        squad.add(new Player("Antonio Rüdiger", "DF", "GER", 22));
        squad.add(new Player("Ferland Mendy", "DF", "FRA", 23));
        squad.add(new Player("Dean Huijsen", "DF", "ESP", 24));
        squad.add(new Player("Franco Mastantuono", "FW", "ARG", 30));

        int choice;
        do {
            System.out.println("\n--- Real Madrid Management ---");
            System.out.println("1. View Squad (By Position)");
            System.out.println("2. Sign New Player (Transfer In)");
            System.out.println("3. Transfer Out Player (By Number)");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showSubMenu();
                case 2 -> addPlayer();
                case 3 -> removePlayerByNumber();
            }
        } while (choice != 4);
    }

    private static void showSubMenu() {
        System.out.println("\nFilter by Position:");
        System.out.println("1. Goalkeepers (GK)");
        System.out.println("2. Defenders (DF)");
        System.out.println("3. Midfielders (MF)");
        System.out.println("4. Forwards (FW)");
        System.out.print("Choice: ");
        int posChoice = scanner.nextInt();
        scanner.nextLine();

        String filter = switch (posChoice) {
            case 1 -> "GK";
            case 2 -> "DF";
            case 3 -> "MF";
            case 4 -> "FW";
            default -> "";
        };

        System.out.println("\n--- Real Madrid " + filter + "s ---");
        for (Player p : squad) {
            if (p.position.equalsIgnoreCase(filter)) {
                System.out.println(p);
            }
        }
    }

    private static void addPlayer() {
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Position (GK/DF/MF/FW): "); String pos = scanner.nextLine().toUpperCase();
        System.out.print("Enter Nationality: "); String nat = scanner.nextLine().toUpperCase();

        int num;
        while (true) {
            System.out.print("Enter Shirt Number: ");
            num = scanner.nextInt();
            scanner.nextLine();

            boolean taken = false;
            for (Player p : squad) {
                if (p.number == num) {
                    taken = true;
                    break;
                }
            }

            if (taken) {
                System.out.println("Error: Number " + num + " is already taken! Choose another.");
            } else {
                break;
            }
        }
        squad.add(new Player(name, pos, nat, num));
        System.out.println(name + " has officially joined the squad!");
    }

    private static void removePlayerByNumber() {
        System.out.print("Enter the Shirt Number of the player leaving: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        // Uses a lambda to find and remove the player by number
        boolean removed = squad.removeIf(p -> p.number == num);

        if (removed) {
            System.out.println("Transfer complete. The player wearing #" + num + " has left the club.");
        } else {
            System.out.println("No player found with number " + num + ".");
        }
    }
}