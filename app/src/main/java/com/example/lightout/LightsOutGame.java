package com.example.lightout;
import android.view.View;
import android.widget.TextView;
//Authored By Luis Perez
import java.util.Random;
public class LightsOutGame extends LightsOutAdapter{
    private boolean [][] grid;

    public LightsOutGame(){
        super();
        grid = new boolean[5][5];
        initializeGrid();
    }
    public void initializeGrid(){
        Random random = new Random();//Initializing grid to random values
        for(int i = 0; i < 5; i++){
            for(int j = 0 ; j < 5; j++){
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    public boolean[][] getGrid() {//get the grid
        return grid;
    }
    //toggle the state of each square
    public void togSquares(int row, int col){
        if(row >= 0 && row < 5 && col >= 0 && col < 5){//i
            grid[row][col] = !grid[row][col];
        }
    }
    public boolean isGameWon() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!grid[i][j]) {
                    return false;//if any square is not black, game is not done
                }
            }

        }
        return true;// all squares are black
    }
    //reset the game, reinitializing the board
    public void reset(){
        initializeGrid();

    }


}
