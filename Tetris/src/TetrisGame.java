/**
 * This should be implemented to include your game control.
 * @author pipWolfe
 * @author Phillip Nguyen
 */
public class TetrisGame {
    private boolean gameOver = false;
    private final Tetris tetrisApp;
    private TetrisBoard b;
    private int score = 0;
    TetrisPiece current_piece; // reference can be updated for new piece.

    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        b = board;
        makePiece();
        this.tetrisApp = tetrisApp;
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!");
    }

    /**
     * Randomly generates one of the 7 tetris pieces.
     */
    private void makePiece(){
        int r = (int)(Math.random()*7);
        switch (r) {
            case 0: current_piece = new O_Piece(b);
                    break;
            case 1: current_piece = new Z_Piece(b);
                    break;
            case 2: current_piece = new S_Piece(b);
                    break;
            case 3: current_piece = new T_Piece(b);
                    break;
            case 4: current_piece = new L_Piece(b);
                    break;
            case 5: current_piece = new J_Piece(b);
                    break;
            case 6: current_piece = new I_Piece(b);
                    break;
        default:
        }
        // Piece starts out in the middle of the screen near the top.
        current_piece.moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 1);
        // End game if piece cannot move after created.
        if(current_piece.checkDown() == false) {
            gameOver = true;
        }

    }
    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
        if(!gameOver){
            System.out.println("updating");
            boolean status = current_piece.down();
            if(!status) {
                b.addTetrisSquares(current_piece);
                current_piece.delete();
                makePiece();
            }
            int multiplier = b.processRows();
            score += 100*multiplier;
            tetrisApp.setMessage("Score: " + score); // update score
        } else {
            tetrisApp.setMessage("Game Over!");
            b.setOnKeyPressed(e -> {}); // disable key events
            tetrisApp.pause(); // stop animation
        }
    }

    /**
     * Move the current tetris piece left.
     */
    void left() {
        current_piece.left();
        System.out.println("left key was pressed!");
    }

    /**
     * Move the current tetris piece right.
     */
    void right() {
        current_piece.right();
        System.out.println("right key was pressed!");
    }

    /**
     * Drop the current tetris piece.
     */
    void drop() {
        System.out.println("drop key was pressed!");
        boolean status = current_piece.down();
        while(true){
            status = current_piece.down();
            if(!status) break;
        }
    }

    /**
     * Rotate the current piece counter-clockwise.
     */
    void rotateLeft() {
        current_piece.rotateLeft();
        System.out.println("rotate left key was pressed!");
    }

    /**
     * Rotate the current piece clockwise.
     */
    void rotateRight() {
        current_piece.rotateRight();
        System.out.println("rotate right key was pressed!");
    }

}
