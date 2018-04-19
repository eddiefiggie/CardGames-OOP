/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 3/30/18
 *
 * Description: Creates a card object
 *****************************************************************/




public class Card {
    String value;
    String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
