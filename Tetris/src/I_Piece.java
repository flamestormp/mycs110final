import javafx.scene.paint.Color;

public class I_Piece extends TetrisPiece {

    public I_Piece(TetrisBoard board) {
        //piece0 is the center, make it gray for debugging
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.CYAN);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocY(-1);
        piece1.setColor(Color.CYAN);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(1);
        piece2.setColor(Color.CYAN);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocY(2);
        piece3.setColor(Color.CYAN);
    }

    public void down() {

    }
}
