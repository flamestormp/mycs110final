/**
 * Implementation of a general tetris piece. Each tetris piece has a total of
 * 4 squares, named as piece(0-3). Subclasses should set the colors of each 
 * square and the relative location to the designated center square (piece0 as 
 * my convention, which has relLocX & relLocY of 0).
 * 
 * @author Phillip Nguyen
 */
public abstract class TetrisPiece {

	// to be initialized & defined
    protected TetrisSquare piece0;
    protected TetrisSquare piece1;
    protected TetrisSquare piece2;
    protected TetrisSquare piece3;

    /**
     * Makes good use of relative locations to minimize complexity.
     * Not to be confused with method with same name in TetrisSquare class.
     * 
     * @param x new x coordinate
     * @param y new y coordinate 
     */
    public void moveToTetrisLocation(int x, int y) {
        piece0.moveToTetrisLocation(x, y);
        piece1.moveToTetrisLocation(piece1.getRelLocX()+x, piece1.getRelLocY()+y);
        piece2.moveToTetrisLocation(piece2.getRelLocX()+x, piece2.getRelLocY()+y);
        piece3.moveToTetrisLocation(piece3.getRelLocX()+x, piece3.getRelLocY()+y);
    }

    /**
     * Wrapper for moveToTetrisLocation solely for leftward movement.
     * Includes bounds checking.
     */
    public void left() {
        // prevents blocks from going off screen without unnecessary loops & arrays
    	boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        if (piece0.getX()-1 < 0) check1 = false;
        if (piece1.getX()-1 < 0) check2 = false;
        if (piece2.getX()-1 < 0) check3 = false;
        if (piece3.getX()-1 < 0) check4 = false;
        if(check1 && check2 && check3 && check4)
        	
        this.moveToTetrisLocation(piece0.getX() - 1, piece0.getY());
    }

    /**
     * Wrapper for moveToTetrisLocation solely for rightward movement.
     * Includes bounds checking.
     */
    public void right() {
        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        int max = TetrisBoard.X_DIM_SQUARES-1; //dunno why, itjustwerks
        if (piece0.getX()+1 > max) check1 = false;
        if (piece1.getX()+1 > max) check2 = false;
        if (piece2.getX()+1 > max) check3 = false;
        if (piece3.getX()+1 > max) check4 = false;
        if(check1 && check2 && check3 && check4)
        this.moveToTetrisLocation(piece0.getX() + 1, piece0.getY());
    }

    /**
     * Uses the standard formula:
     * new relative x = old relative y
     * new relative y = - (old relative x)
     * 
     * Also includes somewhat okay bounds checking.
     */
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
        
        int max = TetrisBoard.X_DIM_SQUARES;
        if (!(piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) && 
        		!(piece1.getX() == max || piece2.getX() == max || piece3.getX() == max)) {
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
  	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
  	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        if (piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) {
        	piece0.moveToTetrisLocation(piece0.getX()+1, piece0.getY());
	        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        else if (piece1.getX() == max || piece2.getX() == max || piece3.getX() == max) {
        	piece0.moveToTetrisLocation(piece0.getX()-1, piece0.getY());
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
 	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
 	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
    }

    /**
     * Uses the standard formula:
     * new relative x = -(old relative y)
     * new relative y = old relative x
     * 
     * Also includes somewhat okay bounds checking.
     */
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

        int max = TetrisBoard.X_DIM_SQUARES;
        if (!(piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) && 
        		!(piece1.getX() == max || piece2.getX() == max || piece3.getX() == max)) {
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
  	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
  	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        if (piece1.getX() == 0 || piece2.getX() == 0 || piece3.getX() == 0) {
        	piece0.moveToTetrisLocation(piece0.getX()+1, piece0.getY());
	        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
        else if (piece1.getX() == max || piece2.getX() == max || piece3.getX() == max) {
        	piece0.moveToTetrisLocation(piece0.getX()-1, piece0.getY());
        	piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(), piece1.getRelLocY()+piece0.getY());
 	        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(), piece2.getRelLocY()+piece0.getY());
 	        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(), piece3.getRelLocY()+piece0.getY());
        }
    }
    
    
    /**
     * To be implemented for checkpoint 2
     */
    public void down() {

    }

}
