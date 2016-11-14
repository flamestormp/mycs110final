public abstract class TetrisPiece {

    protected TetrisSquare piece0;
    protected TetrisSquare piece1;
    protected TetrisSquare piece2;
    protected TetrisSquare piece3;
    private int orientation = 0; // 0-3 (4 possible positions)

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
        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(),
                piece1.getRelLocY()+piece0.getY());
        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(),
                piece2.getRelLocY()+piece0.getY());
        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(),
                piece3.getRelLocY()+piece0.getY());
    }

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
        piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(),
                piece1.getRelLocY()+piece0.getY());
        piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(),
                piece2.getRelLocY()+piece0.getY());
        piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(),
                piece3.getRelLocY()+piece0.getY());
    }
}
