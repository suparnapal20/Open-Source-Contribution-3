import java.util.LinkedList;
import java.util.Random;

/** Deck.java
*
* This is a simple Deck class
* @author Suparna Pal
* @author Student ID: 2366429
* @author spal@chapman.edu
* CPSC 230-01 - Prof. Stevens
* Assignment MP3 - Crazy Eights
* @version 1.0
*/

/** The Deck class is used to represent the simple concept of a
 * standard card deck.
 * The Deck class consists of basic methods for creating a deck of cards.
 */

public class Deck{

  /** The linked list containing the cards of the deck. */
  private LinkedList<Card> deckOfCards = new LinkedList<Card>();

  /** The array containing the standard suits of the deck. */
  private final String[] suits = {"hearts", "spades", "clubs", "diamonds"};

  /** The array containing the standard ranks of the deck. */
  private final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

  /** The default constructor - populates the deck with 52 unique cards using
          * the Card class, the suits array, and the ranks array.
  */
  public Deck(){
    for (int i = 0; i < suits.length; i++){
      for (int j = 0; j < values.length; j++){
        Card c = new Card(suits[i], values[j]);
        // ERROR: switch j and i above to create valid cards in the deck
        deckOfCards.add(c);
      }
    }
  }

  /** Deals a random card from the populated deck.
  * @return A Card representing the dealt card
  */
  public Card deal(){
    Random r = new Random();
    int randomInt = r.nextInt(deckOfCards.size());
    return deckOfCards.remove(randomInt);
  }

  /** Returns the current length of the deck.
  * @return A int representing the length of the deck
  */
  public int deckSize(){
    return deckOfCards.size();
    // ERROR: change to length()
  }
}
