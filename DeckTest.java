/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/13/18
 *
 * Description: Deck app
 *****************************************************************/
 
// Program tests class Deck.
import java.util.Scanner;

public class DeckTest {
    
    public static void main(String args[]) {    
        Scanner input = new Scanner( System.in );

        playerDeck deckOfCards = new playerDeck();
        trickDeck stripperDeck = new trickDeck(); // default constructor
        trickDeck markedDeck = new trickDeck("MARKED");
        int deckSwitcher = 0;
      
        int choice = getMenuChoice();
        while ( choice != 5 ) {
            switch ( choice ) {
                case 1:
                    System.out.println();
                    System.out.print( "Shuffling Deck.... " );
                    System.out.println();
                    if(deckSwitcher == 0) {
                        deckOfCards.shuffle();
                    }
                    else if(deckSwitcher == 1) {
                        stripperDeck.shuffle();
                    }
                    else {
                        markedDeck.shuffle();
                    } 
                    break;
                case 2:
                    System.out.println();
                    System.out.println ( "Displaying Deck ... " );
                    System.out.println();
                    if(deckSwitcher == 0) {
                        deckOfCards.display();
                    }
                    else if(deckSwitcher == 1) {
                        stripperDeck.display();
                    }
                    else {
                        markedDeck.display();
                    }    
                    break;
                case 3:
                    System.out.println();
                    System.out.println ( "Cycling Decks ... " );
                    System.out.println();
                    deckSwitcher++;        
                    if(deckSwitcher == 3) {
                        deckSwitcher = 0;
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println ( "Dealing 5 Cards ... " );
                    System.out.println(); 
                    if(deckSwitcher == 0) {
                        deckOfCards.deal(5);
                        deckOfCards.displayDeal();
                    }
                    else if(deckSwitcher == 1) {
                        stripperDeck.deal(5);
                        stripperDeck.displayDeal();
                    }
                    else {
                        markedDeck.deal(5);
                        markedDeck.displayDeal();
                    }    
                    break;                
            } // end switch
            System.out.println();         
            choice = getMenuChoice();
        } // end while
        
        // exit program
        System.out.println();
        System.out.println ( "Exiting Application.  Goodbye!" );
        System.out.println();
    } // end main

    // prints a menu and returns a value coressponding to the menu choice
    private static int getMenuChoice() {
        int value;
        System.out.println();
        System.out.println( "1. Shuffle" );
        System.out.println( "2. Display" );
        System.out.println( "3. Cycle Decks" );
        System.out.println( "4. Deal 5 Cards" );
        System.out.println( "5. Exit" );
        System.out.println();
        System.out.print( "Choice: " );
        // vallidation for options added here.
        value = selectValue();
        while(value < 1 || value > 5) {
            System.out.print("Invalid entry, try again: ");
            value = selectValue();
        }        
        return value; // insert error handling
    } // end method getMenuChoice
      
    private static int selectValue() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return input.nextInt();
            }         
            catch (java.util.InputMismatchException e) {
                System.out.print("Invalid entry, try again: ");
                input.nextLine();
            }
        }                
    }
} // end class DeckTest  