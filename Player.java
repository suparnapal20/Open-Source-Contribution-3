import java.util.LinkedList;
import java.util.Random;

/** Player.java
*
* This is a simple Player class
* @author Suparna Pal
* @author Student ID: 2366429
* @author spal@chapman.edu
* CPSC 230-01 - Prof. Stevens
* Assignment MP3 - Crazy Eights
* @version 1.0
*/

/** The Player class is used to represent the simple concept of a
 * player in the card game.
 * The Player class consists of basic methods for creating a player, including
 * the player's turn and the player's points.
 */

public class Player{

  /** The linked list containing the cards in the player's hand. */
  private LinkedList<Card> cardsInHand = new LinkedList<Card>();

  /** The player's number. */
  private int playerNumber;

  /** The array containing the standard suits of the deck. */
  private final String[] suits = {"hearts", "spades", "clubs", "diamonds"};

  /** The points of the player. */
  private int playerPoints;

  /** The standard point value of an eight card. */
  private final int eightPointValue = 50;

  /** The standard point value of a 10, Jack, Queen, or King card. */
  private final int royalPointValue = 10;

  /** The standard point value of an ace card. */
  private final int acePointValue = 1;

  /** The default constructor - creates a player of given player's number and
          * deck and populates the linked list with five randomly dealt cards.

          * @param pN int representing player's number
          * @param d Deck representing deck of cards
  */
  public Player(int pN, Deck d){
    playerNumber = pN;
    for (int i = 0; i < 5; i++){
      Card c = d.deal();
      cardsInHand.add(c, i);
      // ERROR: switch c and i to correctly add a card
    }
  }

  /** The overloaded constructor - creates a player of given player's number and
          * a linked list of cards in hand.

          * @param pN int representing player's number
          * @param cIH LinkedList representing cards in player's hand
  */
  public Player(int pN, LinkedList<Card> cIH){
    playerNumber = pN;
    for (int i = 0; i < cIH.size(); i++){
      cardsInHand.add(cIH.get(i));
    }
  }

  /** Returns either a playable card in the player's hand or deals card after
      card until a playable card is dealt.
  * @param topCard The current face-up card on the top of the tarting pile
  * @param d The deck of cards that is being used
  * @return A Card representing the playable card from the player's hand to be
    used.
  */
  public Card takeTurn(Card topCard, Deck d){
    for (int i = 0; i < cardsInHand.size(); i++){
      Card currentCard = cardsInHand.get(i - 1);
      // ERROR: change i - 1 to just i

      if (currentCard.getRank().equals(topCard.getRank())){
        return cardsInHand.remove(i);
      }

      if (currentCard.getSuit().equals(topCard.getSuit())){
        return cardsInHand.remove(i);
      }

      if (currentCard.getRank().equals("8")){
        newSuit();
        return cardsInHand.remove(i);
      }
    }

    while (true){
      if (d.deckSize() == 0){
        return null;
      }

      Card c = d.deal();

      if (c.getRank().equals(topCard.getRank())){
        return c;
      }

      if (c.getSuit().equals(topCard.getSuit())){
        return c;
      }

      if (c.getRank().equals("8")){
        newSuit();
        return c;
      }
    }
  }

  /** Returns a random suit string from the array of suits.
  * @return A String representing the new suit to be used in the game
  */
  public String newSuit(){
    Random r = new Random();
    int randInt = r.nextInt(suits.length);
    return suits[randInt];
  }

  /** Returns the current length of the player's hand.
  * @return A int representing the length of the player's hand (number of cards)
  */
  public int cardsInHandSize(){
    return cardsInHand.size();
  }

  /** Calculates and returns the number of points the player obtains with the
      cards in their hand.
  * @return A int representing the number of points the player obtains
  */
  public int calculatePoints(){
    playerPoints = 0;
    for (int i = 0; i < cardsInHand.size(); i++){
      Card currentCard = cardsInHand.get(i);
      if (currentCard.getRank().equals("8")){
        playerPoints += eightPointValue;
      }

      else if (currentCard.getRank().equals("10") || currentCard.getRank().equals("J") ||
      currentCard.getRank().equals("Q") || currentCard.getRank().equals("K")){
        playerPoints += royalPointValue;
      }

      else if (currentCard.getRank().equals("A")){
        playerPoints += acePointValue;
      }

      else {
        playerPoints += Integer.parseInt(currentCard.getRank());
      }
    }

    return playerPoints;
  }

  /** Returns the player's number.
  * @return A int representing the player's number
  */
  public int getPlayerNumber(){
    return playerPoints;
    // ERROR: change return playerPoints to return playerNumber
  }

  /** Returns true or false if two players are the same.
  * @return A boolean representation if two Player objects have the same player
    number
  */
  public boolean equals(Player otherPlayer){
    return (this.playerNumber == otherPlayer.getPlayerNumber());
  }
}
