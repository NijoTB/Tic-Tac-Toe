public class Board {
    /* A class representation of a TicTacToe board.
    The board is a 9 element array. The constructor (provided)
    initializes these values to the strings "1", "2", ... "9".
    When a player makes a move on the board, that element in the
    array should be replaced by "X" or "O" respectively.
    https://en.wikipedia.org/wiki/Tic-tac-toe

    Complete the isEmptyPosition(pos), displayBoard(), winner(),
    and applyMove(move) methods.
    */
    public String[] board = new String[9];


    /**
    * The board is initialized to hold strings containing numbers
    * ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
    */
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    /**
     * // TODO: Return if the desired position has not been filled yet.
     *

     * @param pos the desired position 1-9
     * @return false if an X or O has already been placed at the position,
     *         or true a number is at the position.
     */
    public boolean isEmptyPosition(int pos) {
        if (this.board[pos -1].equals("X")||this.board[pos -1].equals("O") ){
            return false;


        }
            else {
            return true;
        }

    }

    /**
     * TODO: Display the current board in the console.
     */
    public void displayBoard() {
        /* An example of what an in progress game may look like:
        |---|---|---|
        | 1 | X | O |
        |-----------|
        | 4 | 5 | X |
        |-----------|
        | 7 | 8 | O |
        |---|---|---|
         */
        System.out.println("|---|---|---|");
        System.out.println("| " + this.board[0] +" | " + this.board[1] +" | " + this.board[2] +" |");
        System.out.println("|-----------|");
        System.out.println("| " + this.board[3] +" | " + this.board[4] +" | " + this.board[5] +" |");
        System.out.println("|-----------|");
        System.out.println("| " + this.board[6] +" | " + this.board[7] +" | " + this.board[8] +" |");
        System.out.println("|---|---|---|");
    }


    /**
     * TODO: Return the winner of the game or null.
     * @return "X" or "O" if a respective player has achieved 3 in a row,
     *         "draw" if the board is full and no player won,
     *         or null if there is no winner.
     */
    public String winner() {
        if (horizontalWinner() != null){
            return horizontalWinner();
        }

        if (verticalWinner() != null){
            return verticalWinner();
        }

        if (diagonalWinner() != null){
            return diagonalWinner();
        }


        return fullBoardCheck();

    }
    private String horizontalWinner() {
        if (this.board[0].equals("X") && this.board[1].equals("X") && this.board[2].equals("X")) {
            return "X";
        } else if (this.board[0].equals("O") && this.board[1].equals("O") && this.board[2].equals("O")) {
            return "O";
        } else if (this.board[3].equals("X") && this.board[4].equals("X") && this.board[5].equals("X")) {
            return "X";
        } else if (this.board[3].equals("O") && this.board[4].equals("O") && this.board[5].equals("O")) {
            return "O";
        } else if (this.board[6].equals("X") && this.board[7].equals("X") && this.board[8].equals("X")) {
            return "X";
        } else if (this.board[6].equals("O") && this.board[7].equals("O") && this.board[8].equals("O")) {
            return "O";
        } else {
            return null;
        }
    }
    private String verticalWinner() {
        if (this.board[0].equals("X") && this.board[3].equals("X") && this.board[6].equals("X")) {
            return "X";
        } else if (this.board[0].equals("O") && this.board[3].equals("O") && this.board[6].equals("O")) {
            return "O";
        } else if (this.board[1].equals("X") && this.board[4].equals("X") && this.board[7].equals("X")) {
            return "X";
        } else if (this.board[1].equals("O") && this.board[4].equals("O") && this.board[7].equals("O")) {
            return "O";
        } else if (this.board[2].equals("X") && this.board[5].equals("X") && this.board[8].equals("X")) {
            return "X";
        } else if (this.board[2].equals("O") && this.board[5].equals("O") && this.board[6].equals("O")) {
            return "O";
        } else {
            return null;
        }
    }
    private String diagonalWinner() {
        if (this.board[0].equals("X") && this.board[4].equals("X") && this.board[7].equals("X")) {
            return "X";
        } else if (this.board[0].equals("O") && this.board[4].equals("O") && this.board[7].equals("O")) {
            return "O";
        } else if (this.board[1].equals("X") && this.board[4].equals("X") && this.board[7].equals("X")) {
            return "X";
        } else if (this.board[1].equals("O") && this.board[4].equals("O") && this.board[7].equals("O")) {
            return "O";
        }
        else {
            return null;
        }

    }

    private String fullBoardCheck(){
        for (int a = 0; a < 9; a++) {
           if (!(this.board[a].equals("X") || this.board[a].equals("O"))){
               return null;
           }
        }
        return "draw";
    }


    /**
     * TODO: Apply a given move to the board.
     * @param move contains the player's symbol (move.player.symbol)
     *             and the location they'd like to place it (move.pos).
     */
    public void applyMove (Move move) {

            this.board[move.pos -1] = move.player.symbol;
    }
}
