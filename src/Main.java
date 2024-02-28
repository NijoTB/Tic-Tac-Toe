import java.util.Scanner;

public class Main {
    /*
    The program's entrypoint to play a game of TicTacToe.
    Using a combination of methods you write and provided methods
    you will be tasked with creating a functioning interactive TicTacToe game.

    Note: Do not start until the necessary methods in Player and Board are completed.
     */
    static GameState game = new GameState();

    public static void main(String[] args) {
        // Each iteration of this loop represents one game of TicTacToe
        while (true) {
            // Each iteration of this while loop represents one turn of TicTacToe.
            while (!game.isOver()) {
                /* TODO: Implement TicTacToe turn logic.
                 * Each iteration of this while loop represents one turn of TicTacToe.
                 *
                 * Every turn, the game should display the current board to the user,
                 * announce which player's turn it is,
                 * and prompt that user to take a turn.
                 *
                 * If the user asks for an invalid position
                 * (not 1-9 or the position is already filled)
                 * ask the user to try again.
                 *
                 * Once the player inputs a valid move,
                 * apply the move to the board,
                 * and cycle the game to the next player (with game.nextPlayer()).
                 *
                 * If a move wins the game, it will terminate this loop.
                 */




                game.board.displayBoard();
                System.out.println("The current player is Player: " + game.currentPlayer.symbol);

                Move turn = game.currentPlayer.getTurn();

                while (!game.board.isEmptyPosition(turn.pos)){

                    System.out.println("Place already taken. Pick another number from 1-9");
                    turn = game.currentPlayer.getTurn();
                }

                game.board.applyMove(turn);

                game.nextPlayer();











            }
            /* TODO: Display end game information and update scores
             * Show the final game state and tell the user if the
             *
             * winner was "X", "O", or a draw. Give a point to the
             * winning player, (using game.addPointToWinningPlayer)
             * and display current scores.
             *
             * Functionality has already been implemented to ask the user
             * if they would like to play again.
             */
            game.board.displayBoard();
            System.out.println( "The Winner is: "+ game.board.winner());
            game.addPointToWinningPlayer();

            System.out.println("X Points: "+ game.players[0].points);
            System.out.println("0 Points: "+game.players[1].points);




            /* TODO: Ask the user if they would like to play again
             * If the user says "Y", use game.newGame() to restart the board.
             * If the user says "N", break out of the game loop.
             */

            Scanner playAgain = new Scanner(System.in);
            System.out.println("Would you like to play again");
            String yesNo;
            yesNo = playAgain.next().toUpperCase();

            while(! (yesNo.equals("N") || yesNo.equals("Y")) ) {
                System.out.println("Would you like to play again");
                yesNo = playAgain.next().toUpperCase();
            }



            if (yesNo.equals("N")){
                break;
            }
            else {
                game.newGame();
            }




        }
    }
}
