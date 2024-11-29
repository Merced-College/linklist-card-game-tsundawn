import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardGame {
    private static LinkList cardList = new LinkList(); // make list

    public static void main(String[] args) {
        // File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        System.out.println("Cards loaded:");
        cardList.displayList();

        // Shuffle the deck
        System.out.println("\nShuffling the deck...");
        cardList.shuffle();

        // Print the shuffled deck
        System.out.println("Shuffled deck:");
        cardList.displayList();

        // Deal cards to the player
        Card[] playerHand = new Card[5];
        for (int i = 0; i < playerHand.length; i++) {
            playerHand[i] = cardList.getFirst();
        }

        // Display the player's hand
        System.out.println("\nPlayer's hand:");
        for (Card card : playerHand) {
            System.out.println(card);
        }

        // Display the remaining cards in the deck
        System.out.println("\nRemaining cards in the deck:");
        cardList.displayList();
    }
}