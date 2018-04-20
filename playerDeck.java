/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/19/18
 *
 * Description: Creates a playerDeck object from the DeckInterface
 *****************************************************************/

import java.util.Random;


enum Suit {
        SPADES(0), 
        HEARTS(1), 
        CLUBS(2), 
        DIAMONDS(3);
    
    private int label;
        
    Suit(int l) {
        label = l;
    }      
}

public class playerDeck implements DeckInterface {

    protected Card[] deck;
    protected Card[] dealHand = new Card[52];
    
    // constructor
    public playerDeck() {
        setDeck();
    }
    
    public void setDeck() {
        String sv;        
        Card card;
        Suit[] suit = Suit.values();
        int suitSet = 0;
        int suitValue = 2;
        deck = new Card[52];
        for(int deckCount = 0; deckCount < 52; deckCount++) {
            while(suitSet < 4) {
                while(suitValue < 15) {
                    sv = String.valueOf(suitValue);
                    card = new Card(faceCard(suitValue), String.valueOf(suit[suitSet]));
                    deck[deckCount] = card;
                    deckCount++;
                    suitValue++;
                }
                suitSet++;
                suitValue = 2;            
            }
        }         
    }
    @Override
    public void display() {
        int cardCount = 1;
        System.out.println();
        System.out.println("Cards in PLAYER DECK:  ");
        System.out.println();
        for(int count = 0; count < 52; count++) {
            if(deck[count] != null) {
                String theCard = deck[count].getValue() + deck[count].getSuit();
                System.out.printf("%4s\t%-22s\n", cardCount++, theCard);
            } 
        }
        System.out.println();        
    }
    
    protected String faceCard(int suitS) {
         String type;
         switch(suitS) {
              
              case 14 :
                   type = "Ace of ";
                   break;
              case 13 :
                  type = "King of ";
                  break;
              case 12 :
                  type = "Queen of ";
                  break;
              case 11 :
                  type = "Jack of ";
                  break;
              default :
                  type = suitS + " of ";
                  break;
         }
         return type;
    }
    @Override
    public void shuffle() {
        Card[] shuffledDeck = new Card[52];
        Random randomNumbers = new Random();
        int puller = randomNumbers.nextInt(52);
        int count = 0;
        while(count < 52 && shuffledDeck[count] == null) {
            if (deck[puller] != null) {
                shuffledDeck[count] = deck[puller];
                deck[puller] = null;
                count++;
            }
            else {
                puller = randomNumbers.nextInt(52);
            }
        }
        
        deck = shuffledDeck;
    }
    
    @Override
    public void deal(int noCards) {
        int left = 52;
        for(int counter = 0; counter < 52; counter++) {
            if(deck[counter] == null) {
                left--;
            }
        }
        if(noCards > left) {
            noCards = left;
        }
        for(int count = 0; count < noCards; count++) {
            int openDeal = 0;
            int openDeck = 0;
            while(deck[openDeck] == null && openDeck < 52) {
                openDeck++;
            }
            while(dealHand[openDeal] != null && openDeal < 52) {
                openDeal++;
            }
            if(openDeck < 52 && openDeal < 52);
                dealHand[openDeal] = deck[openDeck];
                deck[openDeck] = null;
        }
    }
    
    @Override
    public void displayDeal() {
        System.out.println("Player Cards dealt: ");
        System.out.println();
        int cardCount = 1;
        int count = 0;
        while(count < 52) {
            if(dealHand[count] != null) {
                String theCard = dealHand[count].getValue() + dealHand[count].getSuit();
                System.out.printf("%4s\t%-22s\n", cardCount++, theCard);
                count++; 
            }
            else {
                count++;
            }
        }
        System.out.println();
    }

    @Override
    public void getFirstCard() throws ArrayIndexOutOfBoundsException {
        int count = 0;
        int openSlot = 0;
        int cardCount = 1;           
        boolean found = false;
        while(dealHand[openSlot] != null) {
            openSlot++;
        }
        while(deck[count] == null) {
            count++;
        }
        dealHand[openSlot] = deck[count];
        deck[count] = null;
        String theCard = dealHand[count].getValue() + dealHand[count].getSuit();
        System.out.printf("Card drawn for the top: " + theCard);          
    }
}


