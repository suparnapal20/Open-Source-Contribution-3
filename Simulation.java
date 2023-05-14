import java.util.Scanner;

/** Simulation.java
*
* This is a simple Simulation class
* @author Suparna Pal
* @author Student ID: 2366429
* @author spal@chapman.edu
* CPSC 230-01 - Prof. Stevens
* Assignment MP3 - Crazy Eights
* @version 1.0
*/

/** The Simulation class is used to represent the simple concept of a
 * simulation of a given number of games to be played.
 * The Simulation class consists of basic methods for creating and playing a
 * given number of games of Crazy Eights.
 */

public class Simulation{

  /** The total number of games to be played in the simulation. */
  private int totalGamesPlayed;

  /** The total number of points obtained by player one in the simulation. */
  private int totalPlayerOnePoints;

  /** The total number of points obtained by player two in the simulation. */
  private int totalPlayerTwoPoints;

  /** The total number of cards in the losing player's hand in the simulation. */
  private double totalLosingPlayerHandSize;

  /** The total number of games won by player one in the simulation. */
  private int totalPlayerOneWins;

  /** The total number of games won by player two in the simulation. */
  private int totalPlayerTwoWins;

  /** The total number of games the deck was emptied in the simulation. */
  private int totalEmptyDeckGames;

  /** The total number of eights played in the simulation. */
  private int totalPlayedEight;

  /** The default constructor - creates a simulation given the number of games
          * and sets the totalGamesPlayed to the number of games and everything
          * else to 0.

          * @param nOG int representing the number of games to be played
  */
  public Simulation(int nOG){
    totalGamesPlayed = nOG;
    totalPlayerOnePoints = 0;
    totalPlayerTwoPoints = 0;
    totalLosingPlayerHandSize = 0.0;
    totalPlayerOneWins = 0;
    totalPlayerTwoWins = 0;
    totalEmptyDeckGames = 0;
    totalPlayedEight = 0;
  }

  /** Calculates the statistics for a single game.
  * @param simulationGame The game that's being played
  */
  public void calculate(Game simulationGame){
    Player winner = simulationGame.play();

    if (winner == null){
      totalEmptyDeckGames += 1;
    }

    else if (winner.equals(simulationGame.getPlayerOne())){
      totalPlayerOneWins += 1;
      totalLosingPlayerHandSize += simulationGame.playerTwoHandSize();
    }

    else if (winner.equals(simulationGame.getPlayerTwo())){
      totalPlayerTwoWins += 1;
      totalLosingPlayerHandSize += simulationGame.playerOneHandSize();
    }

    totalPlayerOnePoints += simulationGame.getPlayerOnePoints();
    totalPlayerTwoPoints += simulationGame.getPlayerTwoPoints();
  }

  /** Runs the simulation for a set number of games and uses the calculate()
  * method for each game.
  */
  public void simulate(){
    int numOfGames = totalGamesPlayed;
    while (numOfGames != 0){
      Game simulationGame = new Game();
      calculate(simulationGame);
      totalPlayedEight += simulationGame.getEightCount();
      numOfGames = numOfGames - 1;
    }
  }

  /** Calculates the average hand size of the losing player in one game and the
  * average number of eights played in one game. It also acts as a toString
  * method to print out the statistics of the simulation.
  */
  public void report(){
    double averageLosingPlayerHandSize = 0.0;
    double averagePlayedEight = totalPlayedEight/totalGamesPlayed;
    if(totalGamesPlayed != totalEmptyDeckGames){
      averageLosingPlayerHandSize = totalLosingPlayerHandSize/(totalGamesPlayed - totalEmptyDeckGames);
    }

    System.out.println("Number of Games Won by Player One:            " + totalPlayerOneWins);
    System.out.println("Number of Games Won by Player Two:            " + totalPlayerTwoWins);
    System.out.println("Number of Points Collected by Player One:     " + totalPlayerOnePoints);
    System.out.println("Number of Points Collected by Player Two:     " + totalPlayerTwoPoints);
    System.out.println("Average Number of Cards from Losing Player:   " + averageLosingPlayerHandSize);
    System.out.println("Number of Times Stock Was Emptied:            " + totalEmptyDeckGames);
    System.out.println("Average Number of Times an Eight Was Played:  " + averagePlayedEight);
  }

  /** The main method. Exercises the Simulation and Game functionalities.
  * @param args The command line arguments (not used)
  */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Please enter a number of games to be played: ");
    int numberOfGames = scnr.nextInt();
    Simulation driverSimulation = new Simulation(numberOfGames);
    driverSimulation.simulate();
    driverSimulation.report();
  }
}
