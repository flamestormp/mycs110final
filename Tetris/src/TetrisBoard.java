import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * A Pane in which tetris squares can be displayed.
 *
 * @author pipWolfe
 */
public class TetrisBoard extends Pane{
    // The size of the side of a tetris square
    public static final int SQUARE_SIZE = 20;
    // The number of squares that fit on the screen in the x and y dimensions
    public static final int X_DIM_SQUARES = 20;
    public static final int Y_DIM_SQUARES = 35;
    // swap usual x y for easy for loop logic
    // this matrix stores the TetrisSquares from the previous pieces
    private TetrisSquare[][] squares = new TetrisSquare[Y_DIM_SQUARES][X_DIM_SQUARES];

    /**
     * Sizes the board to hold the specified number of squares in the x and y
     * dimensions.
     */
    public TetrisBoard() {
        this.setPrefHeight(Y_DIM_SQUARES*SQUARE_SIZE);
        this.setPrefWidth(X_DIM_SQUARES*SQUARE_SIZE);
        BackgroundFill myBF = new BackgroundFill(Color.BLUEVIOLET, new
                CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
        // or null for the padding
        setBackground(new Background(myBF));
    }

    /**
     * Takes the information about the Squares in the TetrisPiece and adds them in to squares[][] matrix.
     * @param p TetrisPiece
     */
    public void addTetrisSquares(TetrisPiece p) {
        int piece0Y, piece1Y, piece2Y, piece3Y;
        piece0Y = p.piece0.getY();
        piece1Y = piece0Y + p.piece1.getRelLocY();
        piece2Y = piece0Y + p.piece2.getRelLocY();
        piece3Y = piece0Y + p.piece3.getRelLocY();
        int piece0X, piece1X, piece2X, piece3X;
        piece0X = p.piece0.getX();
        piece1X = piece0X + p.piece1.getRelLocX();
        piece2X = piece0X + p.piece2.getRelLocX();
        piece3X = piece0X + p.piece3.getRelLocX();
        Color color = p.getColor();

        squares[piece0Y][piece0X] = new TetrisSquare(this,piece0X,piece0Y,color);
        squares[piece1Y][piece1X] = new TetrisSquare(this,piece1X,piece1Y,color);
        squares[piece2Y][piece2X] = new TetrisSquare(this,piece2X,piece2Y,color);
        squares[piece3Y][piece3X] = new TetrisSquare(this,piece3X,piece3Y,color);
    }

    /**
     * Checks the squares[][] matrix to see if their is a square occupying that space.
     * @param x coordinate
     * @param y	coordinate
     * @return empty (true) or not (false)
     */
    public boolean checkTetrisSquares(int x, int y) {
        if(squares[y][x] == null) return true;
        else return false;
    }

    /**
     * Clears completed rows and shifts the above rows down. This method evaluates the rows
     * top to bottom, to allow for correct functionality when multiple rows are completed at
     * the same time. Players then get more score if multiple rows are cleared at once.
     * @return score multiplier
     */
    public int processRows() {
        int multiplier = 0;
        for(int y = 0; y < Y_DIM_SQUARES; y++) {
            boolean rowScan = true;
            for(TetrisSquare x: squares[y]) {
                if(x == null) rowScan = false;
            }
            if(rowScan){
                for(int x = 0; x < squares[y].length; x++) {
                    squares[y][x].removeFromDrawing();
                    squares[y][x] = null;
                }
                System.out.println("ROW CLEARED!");
                for(int i = y-1; i > 0; i--) {
                    for(int x = 0; x < squares[i].length; x++) {
                    	if(squares[i][x] != null) {
                    		squares[i+1][x] = new TetrisSquare(this,x,i,squares[i][x].getColor());
                            squares[i+1][x].moveToTetrisLocation(x,i+1);
                            squares[i][x].removeFromDrawing();
                            squares[i][x] = null;
                    	}
                    }
                }
                System.out.println("ROWS MOVED DOWN");
                multiplier++;
            }
        }
        return multiplier;
    }
}
