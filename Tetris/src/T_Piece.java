import javafx.scene.paint.Color;

public class T_Piece extends TetrisPiece {

    public T_Piece(TetrisBoard board) {
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.PURPLE);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setColor(Color.PURPLE);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(1);
        piece2.setColor(Color.PURPLE);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocX(1);
        piece3.setColor(Color.PURPLE);
    }

    public void down() {

    }
}
