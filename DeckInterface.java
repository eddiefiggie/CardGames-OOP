/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/18/18
 *
 * Description: Deck interface
 *****************************************************************/


public interface DeckInterface {
    // shuffle Deck
    void shuffle(); 
  
    // display Deck
    void display(); 
  
    // deal the number of cards from the deck
    // these cards are removed from the remaining deck
    void deal(int noCards);
  
    // displays the cards that were dealt 
    void displayDeal();

    // return first card in deck
    void getFirstCard();
} 
