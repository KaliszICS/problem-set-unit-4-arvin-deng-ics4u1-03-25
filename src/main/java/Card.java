public class Card {
    // Instance variables
    private String name;
    private String suit;
    private int value;

    /**
     * Constructor for the Card class.
     * @param names String name of the card.
     * @param suits String suit of the card.
     * @param value Integer value of the card.
     */
    public Card(String names, String suits, int value) {
        this.name = names;
        this.suit = suits;
        this.value = value;
    }

    // Getter methods for name, value, and suit.
    public String getName() {
        return this.name;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    // Overridden toString() method that returns a card in the form of name + suit.
    @Override
    public String toString() {
        return name + " of " + suit;
    }

    // Overridden equals() method to check if two cards have the same name, suit, and value.
    @Override
    public boolean equals(Object obj) {
        Card card = (Card)obj;
        if (value == card.value && name.equals(card.name) && suit.equals(card.suit)) {
        return true;
      }
      return false;
    }
}