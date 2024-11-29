import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LinkList {
    private Link first; // reference to the first link on the list

    // Constructor
    public LinkList() {
        first = null; // no links on the list yet
    }

    // Insert card at the beginning
    public void insertFirst(Card card) {
        Link newLink = new Link(card);
        newLink.next = first;
        first = newLink;
    }

    // Add card (alias for insertFirst)
    public void add(Card card) {
        insertFirst(card);
    }

    // Find a card in the list
    public Link find(Card cardToFind) {
        Link current = first; // start at 'first'
        while (current != null && !current.cardLink.equals(cardToFind)) {
            current = current.next; // go to next link
        }
        return current; // return the found link, or null if not found
    }

    // Delete a card from the list
    public Link delete(Card cardToFind) {
        Link current = first;
        Link previous = null;

        while (current != null && !current.cardLink.equals(cardToFind)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return null; // card not found
        }

        if (current == first) {
            first = first.next; // delete the first link
        } else {
            previous.next = current.next; // bypass the link
        }

        return current;
    }

    // Display the entire list
    public void displayList() {
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    // Get and remove the first card from the list
    public Card getFirst() {
        if (first == null) {
            return null; // no cards in the list
        }
        Card card = first.cardLink;
        first = first.next; // update the first link
        return card;
    }

    // Shuffle the linked list
    public void shuffle() {
        // Step 1: Copy cards to an ArrayList
        List<Card> tempList = new ArrayList<>();
        Link current = first;
        while (current != null) {
            tempList.add(current.cardLink);
            current = current.next;
        }

        // Step 2: Shuffle the ArrayList
        Collections.shuffle(tempList);

        // Step 3: Rebuild the linked list
        first = null;
        for (Card card : tempList) {
            this.add(card); // re-add cards to the linked list
        }
        System.out.println("Deck shuffled successfully!");
    }
}