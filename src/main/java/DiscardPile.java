import java.util.ArrayList;

public class DiscardPile {
    // Instance variable
    private ArrayList<Card> pile;

    /**
     * Constructor for class DiscardPile.
     * @param cards makes a discard pile using an array of cards.
     */
    public DiscardPile(Card[] cards) {
        this.pile = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            this.pile.add(cards[i]); // Add each card from initialCards to the discard pile
        }
    }

    /**
     * Constructor for class DiscardPile.
     * generates an empty discard pile.
     */
    public DiscardPile() {
        this.pile = new ArrayList<>();
    }

    /**
     * Getter method to return a copy of cards in the discard pile.
     * @return copy of cards is returned to deck.
     */
    public Card[] getPile() {
        return pile.toArray(new Card[0]);
    }

    // Method size() returns the amount of cards from the discard pile
    public int size() {
        return pile.size();
    }

    /**
     * Method addCard() 
     * Adds a card to the pile.
     * @param card the Card that is added
     */
    public void addCard(Card card) {
        this.pile.add(card); // Adds the card to the list of discarded cards
    }

    /**
     * Method removeCard() 
     * Takes out a card and returns it.
     * @param card the Card that is removed
     * @return returns the removed card, or returns null if card does not exist.
     */
    public Card removeCard(Card card) {
        if (card == null) {
            return null;
        }
        for (int i = 0; i < pile.size(); i++) {
            if (pile.get(i).equals(card)) {
                return pile.remove(i);
            }
        }
        return null;
    }

    /**
     * Method removeAll() 
     * Removes all cards in the discard pile and returns them as an array .
     * @return returns an array containing all the cards.
     */
    public Card[] removeAll() {
        Card[] removed = pile.toArray(new Card[0]);
        pile.clear();
        return removed;
    }

    /**
     * Overridden method toString() 
     * Returns a string representation of the pile in the format:
     * "Card 1, Card 2, Card 3."
     */
    @Override
    public String toString() {
        if (pile.isEmpty()) {
            return ""; // If the discard pile is empty, this will return an empty string
        }
        String result = "";
        for (int i = 0; i < pile.size(); i++) {
            result += pile.get(i).toString();
            if (i < pile.size() - 1) {
                result += ", "; 
            }
       }
       return result;
    }
}