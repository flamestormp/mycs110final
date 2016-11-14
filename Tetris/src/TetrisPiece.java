public abstract class TetrisPiece {

    protected TetrisSquare piece0;
    protected TetrisSquare piece1;
    protected TetrisSquare piece2;
    protected TetrisSquare piece3;

    public abstract void down();

    public void moveToTetrisLocation(int x, int y) {
        piece0.moveToTetrisLocation(x, y);
        piece1.moveToTetrisLocation(piece1.getRelLocX()+x, piece1.getRelLocY()+y);
        piece2.moveToTetrisLocation(piece2.getRelLocX()+x, piece2.getRelLocY()+y);
        piece3.moveToTetrisLocation(piece3.getRelLocX()+x, piece3.getRelLocY()+y);
    }

    public void left() {
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

    public void right() {
        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        int max = TetrisBoard.X_DIM_SQUARES;
        if (piece0.getX()+1 > max) check1 = false;
        if (piece1.getX()+1 > max) check2 = false;
        if (piece2.getX()+1 > max) check3 = false;
        if (piece3.getX()+1 > max) check4 = false;
        if(check1 && check2 && check3 && check4)
        this.moveToTetrisLocation(piece0.getX() + 1, piece0.getY());
    }

    public void rotateLeft() {
        // save these for later
        int oldRelY1 = piece1.getRelLocY();
        int oldRelY2 = piece2.getRelLocY();
        int oldRelY3 = piece3.getRelLocY();
        int oldRelX1 = piece1.getRelLocX();
        int oldRelX2 = piece2.getRelLocX();
        int oldRelX3 = piece3.getRelLocX();

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

        // check to make sure rotate doesn't go out of bounds
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        if (piece1.getX()-1 < 0) check2 = false;
        if (piece2.getX()-1 < 0) check3 = false;
        if (piece3.getX()-1 < 0) check4 = false;
        if(check2 && check3 && check4) {
            check2 = true;
            check3 = true;
            check4 = true;
            int max = TetrisBoard.X_DIM_SQUARES;
            if (piece1.getX()+1 > max) check2 = false;
            if (piece2.getX()+1 > max) check3 = false;
            if (piece3.getX()+1 > max) check4 = false;
            if(check2 && check3 && check4) {
                piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(),
                        piece1.getRelLocY()+piece0.getY());
                piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(),
                        piece2.getRelLocY()+piece0.getY());
                piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(),
                        piece3.getRelLocY()+piece0.getY());
            } else {
                piece1.setRelLocY(oldRelY1);
                piece2.setRelLocY(oldRelY2);
                piece3.setRelLocY(oldRelY3);
                piece1.setRelLocX(oldRelX1);
                piece2.setRelLocX(oldRelX2);
                piece3.setRelLocX(oldRelX3);
            }
        } else {
                piece1.setRelLocY(oldRelY1);
                piece2.setRelLocY(oldRelY2);
                piece3.setRelLocY(oldRelY3);
                piece1.setRelLocX(oldRelX1);
                piece2.setRelLocX(oldRelX2);
                piece3.setRelLocX(oldRelX3);
        }
    }

    public void rotateRight() {
        // save these for later
        int oldRelY1 = piece1.getRelLocY();
        int oldRelY2 = piece2.getRelLocY();
        int oldRelY3 = piece3.getRelLocY();
        int oldRelX1 = piece1.getRelLocX();
        int oldRelX2 = piece2.getRelLocX();
        int oldRelX3 = piece3.getRelLocX();

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

        // check to make sure rotate doesn't go out of bounds
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        int max = TetrisBoard.X_DIM_SQUARES;
        if (piece1.getX()+1 > max) check2 = false;
        if (piece2.getX()+1 > max) check3 = false;
        if (piece3.getX()+1 > max) check4 = false;
        if(check2 && check3 && check4) {
            check2 = true;
            check3 = true;
            check4 = true;
            if (piece1.getX()-1 < 0) check2 = false;
            if (piece2.getX()-1 < 0) check3 = false;
            if (piece3.getX()-1 < 0) check4 = false;
            if(check2 && check3 && check4) {
                piece1.moveToTetrisLocation(piece1.getRelLocX()+piece0.getX(),
                        piece1.getRelLocY()+piece0.getY());
                piece2.moveToTetrisLocation(piece2.getRelLocX()+piece0.getX(),
                        piece2.getRelLocY()+piece0.getY());
                piece3.moveToTetrisLocation(piece3.getRelLocX()+piece0.getX(),
                        piece3.getRelLocY()+piece0.getY());
            } else {
                piece1.setRelLocY(oldRelY1);
                piece2.setRelLocY(oldRelY2);
                piece3.setRelLocY(oldRelY3);
                piece1.setRelLocX(oldRelX1);
                piece2.setRelLocX(oldRelX2);
                piece3.setRelLocX(oldRelX3);
            }
        } else {
                piece1.setRelLocY(oldRelY1);
                piece2.setRelLocY(oldRelY2);
                piece3.setRelLocY(oldRelY3);
                piece1.setRelLocX(oldRelX1);
                piece2.setRelLocX(oldRelX2);
                piece3.setRelLocX(oldRelX3);
        }
    }
}
