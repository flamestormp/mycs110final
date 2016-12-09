import javafx.scene.paint.Color;

/**
 * @author Phillip Nguyen
 * 
 * orientation:
 * 
 * piece1
 * piece0
 * piece2
 * piece3
 * 
 */
public class I_Piece extends TetrisPiece {

    /**
     * Basic constructor for I_Piece
     * @param board gameboard
     */
    public I_Piece(TetrisBoard board) {
        super(board, Color.CYAN);
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

    /**
     * Uses the standard formula:
     * new relative x = old relative y
     * new relative y = - (old relative x)
     *
     * Also includes alright bounds checking.
     */
    @Override
    public void rotateLeft() {
        int temp;
        temp = piece1.getRelLocY();
        piece1.setRelLocY(-piece1.getRelLocX());
        piece1.setRelLocX(temp);
        temp = piece2.getRelLocY();
        piece2.setRelLocY(-piece2.getRelLocX());
        piece2.setRelLocX(temp);
        temp = piece3.getRelLocY();
        piece3.setRelLocY(-piece3.getRelLocX());
        piece3.setRelLocX(temp);
        System.out.println("X pos before rotate:" + piece0.getX());
        int max = TetrisBoard.X_DIM_SQUARES;
        if (!(piece1.getX()-1 < 0 || piece2.getX()-1 < 0 || piece3.getX()-1 < 0) &&
        		!(piece1.getX()+1 > max || piece2.getX()+1 > max || piece3.getX()+1 > max)) {
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
  	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
  	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        if (piece1.getX()-1 < 0 || piece2.getX()-1 < 0 || piece3.getX()-1 < 0) {
        	piece0.moveToTetrisLocation(piece0.getX()+2, piece0.getY());
	        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        else if (piece1.getX()+1 > max || piece2.getX()+1 > max || piece3.getX()+1 > max) {
        	piece0.moveToTetrisLocation(piece0.getX()-2, piece0.getY());
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
 	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
 	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        System.out.println("X pos after rotate:" + piece0.getX());
    }

    /**
     * Uses the standard formula:
     * new relative x = -(old relative y)
     * new relative y = old relative x
     *
     * Also includes slightly alright bounds checking.
     */
    @Override
    public void rotateRight() {
        int temp;
        temp = piece1.getRelLocY();
        piece1.setRelLocY(piece1.getRelLocX());
        piece1.setRelLocX(-temp);
        temp = piece2.getRelLocY();
        piece2.setRelLocY(piece2.getRelLocX());
        piece2.setRelLocX(-temp);
        temp = piece3.getRelLocY();
        piece3.setRelLocY(piece3.getRelLocX());
        piece3.setRelLocX(-temp);

        System.out.println("X pos before rotate:" + piece0.getX());
        int max = TetrisBoard.X_DIM_SQUARES;
        if (!(piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) &&
        		!(piece1.getX() == max || piece2.getX() == max || piece3.getX() == max)) {
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
  	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
  	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        if (piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) {
        	piece0.moveToTetrisLocation(piece0.getX()+2, piece0.getY());
	        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        else if (piece1.getX() == max || piece2.getX() == max || piece3.getX() == max) {
        	piece0.moveToTetrisLocation(piece0.getX()-2, piece0.getY());
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
 	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
 	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        System.out.println("X pos after rotate:" + piece0.getX());
    }
}
