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
    private TetrisBoard board;

    public TetrisPiece(TetrisBoard board){
        this.board = board;
    }

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
        int x0 = piece0.getX()-1;
        int x1 = piece1.getX()-1;
        int x2 = piece2.getX()-1;
        int x3 = piece3.getX()-1;
        int y0 = piece0.getY();
        int y1 = piece1.getY();
        int y2 = piece2.getY();
        int y3 = piece3.getY();

        if (x0 > 0 && x1 > 0 && x2 > 0 && x3 > 0){
            if(board.checkTetrisSquares(x0,y0) && board.checkTetrisSquares(x1,y1) &&
                board.checkTetrisSquares(x2,y2) && board.checkTetrisSquares(x3,y3)){
                this.moveToTetrisLocation(x0, y0);
            }
        }
    }

    /**
     * Wrapper for moveToTetrisLocation solely for rightward movement.
     * Includes bounds checking.
     */
    public void right() {
        int max = TetrisBoard.X_DIM_SQUARES;
        int x0 = piece0.getX()+1;
        int x1 = piece1.getX()+1;
        int x2 = piece2.getX()+1;
        int x3 = piece3.getX()+1;
        int y0 = piece0.getY();
        int y1 = piece1.getY();
        int y2 = piece2.getY();
        int y3 = piece3.getY();

        if (x0 < max && x1 < max && x2 < max && x3 < max){
            if(board.checkTetrisSquares(x0,y0) && board.checkTetrisSquares(x1,y1) &&
                board.checkTetrisSquares(x2,y2) && board.checkTetrisSquares(x3,y3)){
                this.moveToTetrisLocation(x0, y0);
            }
        }
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

    public void delete(){
        piece0.removeFromDrawing();
        piece1.removeFromDrawing();
        piece2.removeFromDrawing();
        piece3.removeFromDrawing();
    }

    /**
     * To be implemented for checkpoint 2
     */
    public boolean down() {
        int x0 = piece0.getX();
        int x1 = piece1.getX();
        int x2 = piece2.getX();
        int x3 = piece3.getX();
        int y0 = piece0.getY()+1;
        int y1 = piece1.getY()+1;
        int y2 = piece2.getY()+1;
        int y3 = piece3.getY()+1;

        if (y0 < 49 && x1 < 49 && x2 < 49 && x3 < 49){
            if(board.checkTetrisSquares(x0,y0) && board.checkTetrisSquares(x1,y1) &&
                board.checkTetrisSquares(x2,y2) && board.checkTetrisSquares(x3,y3)){
                this.moveToTetrisLocation(x0, y0);
                return true;
            }
        }
        return false;
    }

}
