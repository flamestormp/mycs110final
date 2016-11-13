/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.paint.Color;

/**
 * This should be implemented to include your game control.
 * @author pipWolfe
 */
public class TetrisGame {
    private final Tetris tetrisApp;
    
    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        // Some sample code that places two squares on the board.
        // Take this out and construct your random piece here.
        TetrisSquare square1 = new TetrisSquare(board);
        square1.moveToTetrisLocation(1, 1);
        square1.setColor(Color.BLUEVIOLET);
        TetrisSquare square2 = new TetrisSquare(board);
        square2.moveToTetrisLocation(2, 3);
        square2.setColor(Color.RED);
        
        this.tetrisApp = tetrisApp;
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!");
    }

    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
        //System.out.println("updating");
    }
    
    /**
     * Move the current tetris piece left.
     */
    void left() {
        System.out.println("left key was pressed!");
    }

    /**
     * Move the current tetris piece right.
     */
    void right() {
        System.out.println("right key was pressed!");
    }

    /**
     * Drop the current tetris piece.
     */
    void drop() {
        System.out.println("drop key was pressed!");
    }

    /**
     * Rotate the current piece counter-clockwise.
     */
    void rotateLeft() {
        System.out.println("rotate left key was pressed!");
    }
    
    /**
     * Rotate the current piece clockwise.
     */
    void rotateRight() {
        System.out.println("rotate right key was pressed!");
    }
    
}
