import javafx.scene.paint.Color;

/**
 * @author Phillip Nguyen
 * 
 * orientation:
 * piece2, piece3
 * piece1, piece0
 */
public class O_Piece extends TetrisPiece {

    public O_Piece(TetrisBoard board){
        //piece0 is the center, make it gray for debugging
        piece0  = new TetrisSquare(board);
        piece0.setColor(Color.YELLOW);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setColor(Color.YELLOW);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocX(-1);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.YELLOW);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocY(-1);
        piece3.setColor(Color.YELLOW);
    }

    @Override
    public void rotateLeft() {
        //a square observed from any angle is still a square
    }

    @Override
    public void rotateRight() {
        //a square observed from any angle is still a square
    }

}
