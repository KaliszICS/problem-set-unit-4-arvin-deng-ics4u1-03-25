import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // Instance variables
    private ArrayList<Card> deck; // Use of ArrayList learned from: https://www.w3schools.com/java/java_arraylist.asp, https://www.geeksforgeeks.org/arraylist-in-java/, and Classroom Notes.
    private String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"}; 
    private String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; // Values: Ace = 1, Jack = 11, Queen = 12; King = 13
   
    /**
     * Constructor for class Deck
     * @param cards takes an array of cards to make a deck.
     */
    public Deck(Card[] cards) {
        deck = new ArrayList<>(); // Initialize the cards list
        for (int i = 0; i < cards.length; i++) {
            this.deck.add(cards[i]); // Adds the card at index i from cards to the cards list
        }
    }

    /**
     * Second constructor for class Deck. Creates an unshuffled deck of cards.
     */
    public Deck() {
        this.deck = new ArrayList<>();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++) {
                this.deck.add(new Card(names[j], suits[i], values[j])); // Adds the card at index j to cards list
            }
        }
    }

    /**
     * Method size()
     * @return returns the amount of cards into the deck.
     */
    public int size() {
        return deck.size();
    }

    /**
     * Method draw()
     * Draws a card from the top of the deck of cards.
     */
    public Card draw() {
        if (deck.isEmpty()) {
            return null;
        }
        Card drawn = deck.get(0); // Gets the first card
        deck.remove(0); // Removes the first card
        return drawn;
    }

    /**
     * Method shuffle()
     * Uses java.util.Random to shuffle the deck of cards.
     */
    public void shuffle() {
        Random rand = new Random();
        int n = deck.size();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    /**
     * Method addCard()
     * @param card a card is added to the deck unless it is = null.
     */
    public void addCard(Card card) {
        if (card != null) {
            this.deck.add(card);
        }
    }

    /**
     * Method reshuffle()
     * @param cards adds multiple cards to the deck for a reshuffle.
     */
    public void reshuffle(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.deck.add(cards[i]);
        }
        shuffle();
    }

}
