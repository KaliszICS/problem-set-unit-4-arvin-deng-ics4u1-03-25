import java.util.ArrayList; 

public class Player {
    // Instance variables
    private String name;
    private int age;
    private ArrayList<Card> hand;

    /**
     * First constructor for class Player.
     * Creates a new player with an empty hand.
     * @param name name of the player
     * @param age age of the player
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    /**
     * Second constructor for class Player.
     * Crates a new player with an initial hand of cards.
     */
    public Player(String name, int age, Card[] cards) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            this.hand.add(cards[i]);
        }
    }

    // Getter methods for name and age.
    public String getName() { 
        return name; 
    }

    public int getAge() {
        return age;
    }

    /**
     * Method size()
     * @return returns the hand size.
     */
    public int size() {
        return hand.size();
    }

    /**
     * Method draw() 
     * Draws a card from the top of the deck and adds the card to the player's hand.
     * If the deck is empty or the hand is full, nothing happens.
     * @param deck
     */
    public void draw(Deck deck) {
        Card drawn = deck.draw();
        if (drawn != null) {
            this.hand.add(drawn);
        }
    }

    /**
     * Method discardCard()
     * Discards a card from the player's hand and put into the discard pile.
     * @param card the card that is discarded
     * @param discardPile the pile the card is discarded into
     * @param return returns true if was discarded, returns false if not found.
     */
     public boolean discardCard(Card card, DiscardPile discardPile) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                discardPile.addCard(hand.remove(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Method returnCard()
     * A card is returned from the player's hand into the deck.
     * @param card the card that is returned
     * @param deck the deck the card is returned to
     * @return returns true if card was returned, returns false if not found.
     */
    public boolean returnCard(Card card, Deck deck) {
         for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                deck.addCard(hand.remove(i));
                return true;
            }
         }
         return false;
    }
    

    /**
     * Overriden method toString()
     * Returns a string representation of the player, including their name, age, and a list of cards in their hand.
     * @return returns a string in the format: "Name, Age, Card1, Card2, ..."
     */
    @Override
    public String toString() {
        String result = name + ", " + age + ", ";
        if (hand.isEmpty()) {
            result += ""; // If the player has no cards, an empty string is added to result
        }
        else {
            for (int i = 0; i < hand.size(); i++) {
                result += hand.get(i).toString();
                if (i < hand.size() - 1) {
                    result += ", ";
                }
            }
        }
        return result;
    }
}
