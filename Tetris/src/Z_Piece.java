import javafx.scene.paint.Color;

public class Z_Piece extends TetrisPiece {

    public Z_Piece(TetrisBoard board){
        //piece0 is the center, make it gray for debugging
        piece0 = new TetrisSquare(board);
        piece0.setColor(Color.GRAY);
        piece1 = new TetrisSquare(board);
        piece1.setRelLocX(-1);
        piece1.setColor(Color.RED);
        piece2 = new TetrisSquare(board);
        piece2.setRelLocY(-1);
        piece2.setColor(Color.RED);
        piece3 = new TetrisSquare(board);
        piece3.setRelLocX(1);
        piece3.setRelLocY(-1);
        piece3.setColor(Color.RED);
    }

    public void rotateLeft() {
        /*switch (getOrientation()) {
            case 0: piece0.moveToTetrisLocation(piece0.getX(), piece0.getY()-1);
                    setOrientation(3);
                    break;
            case 3: piece0.moveToTetrisLocation(piece0.getX()-1, piece0.getY());
                    setOrientation(2);
                    break;
            case 2: piece0.moveToTetrisLocation(piece0.getX(), piece0.getY()+1);
                    setOrientation(1);
                    break;
            case 1: piece0.moveToTetrisLocation(piece0.getX()+1, piece0.getY());
                    setOrientation(0);
                    break;
            default: //meh
        }
        System.out.println("center x:" + piece0.getX());
        System.out.println("center y:" + piece0.getY());
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
                */
    }

    public void rotateRight() {
        /*
        switch (getOrientation()) {
            case 0: piece0.moveToTetrisLocation(piece0.getX()-1, piece0.getY());
                    setOrientation(1);
                    break;
            case 1: piece0.moveToTetrisLocation(piece0.getX(), piece0.getY()-1);
                    setOrientation(2);
                    break;
            case 2: piece0.moveToTetrisLocation(piece0.getX()+1, piece0.getY());
                    setOrientation(3);
                    break;
            case 3: piece0.moveToTetrisLocation(piece0.getX(), piece0.getY()+1);
                    setOrientation(0);
                    break;
            default: //meh
        }
        System.out.println("center x:" + piece0.getX());
        System.out.println("center y:" + piece0.getY());
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
                */
    }

    public void down() {

    }

}
