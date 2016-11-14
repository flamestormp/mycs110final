import javafx.scene.paint.Color;

public class S_Piece extends TetrisPiece {

    public S_Piece(TetrisBoard board) {
        //piece0 is the center, make it gray for debugging
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.GREEN);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setColor(Color.GREEN);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.GREEN);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocX(1);
        piece3.setRelLocY(-1);
        piece3.setColor(Color.GREEN);
    }

    public void down() {

    }
}
