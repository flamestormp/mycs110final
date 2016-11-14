public abstract class TetrisPiece {

    protected TetrisSquare piece0;
    protected TetrisSquare piece1;
    protected TetrisSquare piece2;
    protected TetrisSquare piece3;
    private int orientation = 0; // 0-3 (4 possible positions)

    public abstract void rotateLeft();

    public abstract void rotateRight();

    public abstract void down();

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orient) {
        orientation = orient;
    }

    public void moveToTetrisLocation(int x, int y) {
        piece0.moveToTetrisLocation(x, y);
        piece1.moveToTetrisLocation(piece1.getRelLocX()+x, piece1.getRelLocY()+y);
        piece2.moveToTetrisLocation(piece2.getRelLocX()+x, piece2.getRelLocY()+y);
        piece3.moveToTetrisLocation(piece3.getRelLocX()+x, piece3.getRelLocY()+y);
    }

    public void left() {
        this.moveToTetrisLocation(piece0.getX() - 1, piece0.getY());
    }

    public void right() {
        this.moveToTetrisLocation(piece0.getX() + 1, piece0.getY());
    }
}
