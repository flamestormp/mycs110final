import javafx.scene.paint.Color;

/**
 * @author Phillip Nguyen
 *
 * orientation:
 * 
 * piece2, piece1
 * piece0
 * piece3
 * 
 */
public class J_Piece extends TetrisPiece {

    public J_Piece(TetrisBoard board) {
        //piece0 is the center, make it gray for debugging
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.BLUE);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(1);
        piece1.setRelLocY(-1);
        piece1.setColor(Color.BLUE);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.BLUE);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocY(1);
        piece3.setColor(Color.BLUE);
    }

}
