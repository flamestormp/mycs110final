import javafx.scene.paint.Color;

/**
 * @author Phillip Nguyen
 *
 * orientation:
 *
 * piece1,piece2
 * 		  piece0,piece3
 *
 */
public class Z_Piece extends TetrisPiece {

    /**
     * @param board game board
     */
    public Z_Piece(TetrisBoard board){
        //piece0 is the center, make it gray for debugging
        super(board);
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.RED);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setRelLocY(-1);
        piece1.setColor(Color.RED);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.RED);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocX(1);
        piece3.setColor(Color.RED);
    }

}
