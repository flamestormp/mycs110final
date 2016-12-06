import javafx.scene.paint.Color;

/**
 * @author Phillip Nguyen
 *
 * orientation:
 *
 * piece1, piece2
 *		   piece0
 *		   piece3
 */
public class L_Piece extends TetrisPiece {

    /**
     * @param board game board
     */
    public L_Piece(TetrisBoard board) {
        //piece0 is the center, make it gray for debugging
        super(board,Color.ORANGE);
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.ORANGE);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setRelLocY(-1);
        piece1.setColor(Color.ORANGE);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.ORANGE);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocY(1);
        piece3.setColor(Color.ORANGE);
    }

}
