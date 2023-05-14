/** Game.java
*
* This is a simple Game class
* @author Suparna Pal
* @author Student ID: 2366429
* @author spal@chapman.edu
* CPSC 230-01 - Prof. Stevens
* Assignment MP3 - Crazy Eights
* @version 1.0
*/

/** The Game class is used to represent the simple concept of a
 * card game.
 * The Game class consists of basic methods for creating and playing a game of
 * Crazy Eights.
 */

public class Game{

  /** The deck used for the game. */
  private Deck stockPile;

  /** The first player of the game. */
  private Player playerOne;

  /** The second player of the game. */
  private Player playerTwo;

  /** The starting card of the game. */
  private Card startingCard;

  /** The number of points obtained by player one in the game. */
  private int playerOnePoints = 0;

  /** The number of points obtained by player two in the game. */
  private int playerTwoPoints = 0;

  /** The player winner of the game. */
  private Player winner = null;

  /** The number of eights used in the game. */
  private int eightCount = 0;

  /** The default constructor - creates a game with a populated deck, a player
          * one, a player two, and a randomly dealt starting card.
  */
  public Game(){
    stockPile = new Deck();
    playerOne = new Player(1, stockPile);
    playerTwo = new Player(2, stockPile);
    startingCard = new Card();
    startingCard.setCardValue(stockPile.deal());
  }

  /** The overloaded constructor - creates a game with given deck, given player
          * one, given player two, and given starting card.

          * @param d Deck representing the deck of cards used for the game
          * @param p1 Player representing player one
          * @param p2 Player representing player two
          * @param sC Card representing the top face-up card on the starting pile
  */
  public Game(Deck d, Player p1, Player p2, Card sC){
    stockPile = d;
    playerOne = p1;
    playerTwo = p2;
    startingCard = sC;
  }

  /** Returns the current card game being played and counts the eights.
  * @return A Player representing the player who wins the game or null if the
  * game is a draw
  */
  public Player play(){
    while ((playerOne.cardsInHandSize() > 0) && (playerTwo.cardsInHandSize() > 0)){
      startingCard = playerOne.takeTurn(startingCard, stockPile);
      if (startingCard == null){
        winner = getWinner();
        break;
      }

      else if (startingCard.getRank().equals("8")){
        eightCount += 1;
      }

      startingCard = playerTwo.takeTurn(startingCard, stockPile);
      if (startingCard == null){
        winner = getWinner();
        break;
      }

      else if (startingCard.getRank().equals("8")){
        eightCount += 1;
      }
    }

    if (winner == null){
      winner = getWinner();
    }

    return winner;
  }

  /** Returns the winner of the card game and calculates the points.
  * @return A Player representing the player who wins the game or null if the
  * game is a draw
  */
  public Player getWinner(){
    Player w = null;
    if (playerOne.cardsInHandSize() == 0){
      playerOnePoints = playerOne.calculatePoints() + playerTwo.calculatePoints();
      w = playerOne;
    }

    else if (playerTwo.cardsInHandSize() == 0){
      playerTwoPoints = playerTwo.calculatePoints() + playerOne.calculatePoints();
      w = playerTwo;
    }

    else if (playerOne.cardsInHandSize() < playerTwo.cardsInHandSize()){
      playerOnePoints = playerOne.calculatePoints() + playerTwo.calculatePoints();
      w = playerOne;
    }

    else if (playerTwo.cardsInHandSize() < playerOne.cardsInHandSize()){
      playerTwoPoints = playerTwo.calculatePoints() + playerOne.calculatePoints();
      w = playerTwo;
    }

    return w;
  }

  /** Returns player one.
  * @return A Player representing player one
  */
  public Player getPlayerOne(){
    return playerOne;
  }

  /** Returns player two.
  * @return A Player representing player two
  */
  public Player getPlayerTwo(){
    return playerTwo;
  }

  /** Returns the number of points player one has.
  * @return A int representing the number of points owned by player one
  */
  public int getPlayerOnePoints(){
    return playerOnePoints;
  }

  /** Returns the number of points player two has.
  * @return A int representing the number of points owned by player two
  */
  public int getPlayerTwoPoints(){
    return playerTwoPoints;
  }

  /** Returns the length of player one's hand.
  * @return A int representing the number of cards in player one's hand
  */
  public int playerOneHandSize(){
    return playerOne.cardsInHandSize();
  }

  /** Returns the length of player two's hand.
  * @return A int representing the number of cards in player two's hand
  */
  public int playerTwoHandSize(){
    return playerTwo.cardsInHandSize();
  }

  /** Returns the number of eights played in the current game.
  * @return A int representing the number of eights played
  */
  public int getEightCount(){
    return eightCount;
  }
}
