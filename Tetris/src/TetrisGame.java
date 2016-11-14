//import javafx.scene.paint.Color;

/**
 * This should be implemented to include your game control.
 * @author pipWolfe
 */
public class TetrisGame {
    private final Tetris tetrisApp;
    TetrisPiece current_piece;

    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        // Some sample code that places two squares on the board.
        // Take this out and construct your random piece here.
        //current_piece = new O_Piece(board);
        //current_piece = new Z_Piece(board);
        current_piece = new T_Piece(board);
        current_piece.moveToTetrisLocation(3, 3);
        //TetrisSquare square1 = new TetrisSquare(board);
        //square1.moveToTetrisLocation(1, 1);
        //square1.setColor(Color.BLACK);

        this.tetrisApp = tetrisApp;
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!");
    }

    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
        //System.out.println("updating");
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
