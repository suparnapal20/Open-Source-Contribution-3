/** Card.java
*
* This is a simple Card class
* @author Suparna Pal
* @author Student ID: 2366429
* @author spal@chapman.edu
* CPSC 230-01 - Prof. Stevens
* Assignment MP3 - Crazy Eights
* @version 1.0
*/

/** The Card class is used to represent the simple concept of a
 * typical card.
 * The Card class consists of basic methods for creating a card.
 */

public class Card{

  /** The suit of the card. Either hearts, spades, clubs, or diamonds. */
  private String suit;

  /** The rank of the card. Either ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, or king. */
  private String rank;

  /** The Card object itself. */
  private Card cardValue;

  /** The default constructor - sets the suit, rank, and cardValue to null. */
  public Card(){
    suit = null;
    rank = null;
    cardValue = null;
  }

  /** The overloaded constructor - creates a card of given suit and rank.

          * @param s String representing card suit
          * @param r String representing card rank
  */
  public Card(String s, String r){
    suit = s;
    rank = r;
  }

  /** Returns the suit.
  * @return A String representing the suit of the card
  */
  public String getSuit(){
    return suit;
  }

  /** Returns the rank.
  * @return A String representing the rank of the card
  */
  public String getRank(){
    return rank;
  }

  /** Returns the card.
  * @return A Card representing the card itself
  */
  public Card getCardValue(){
    return cardValue;
  }

  /** Sets the suit.
  * @param s The suit to use for the card
  */
  public void setSuit(String s){
    suit = s;
  }

  /** Sets the rank.
  * @param r The rank to use for the card
  */
  public void setRank(String r){
    rank = r;
  }

  /** Sets the card.
  * @param c The Card object to use for the card itself
  */
  public void setCardValue(Card c){
    cardValue = c;
  }
}
