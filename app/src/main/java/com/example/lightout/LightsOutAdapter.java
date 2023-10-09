package com.example.lightout;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
//Authored by Luis Perez
//
public class LightsOutAdapter extends BaseAdapter {
    private Context context;
    private boolean[][] grid;
    private LightsOutGame game;
//constructor
    public LightsOutAdapter(Context context, boolean[][] grid, LightsOutGame game){
        this.context = context;
        this.grid = grid;
        this.game = game;
    //initialize the grid with the provided one if valid, otherwise create 5x5 grid
        if(grid == null || grid.length != 5 || grid[0].length != 5){
            this.grid = new boolean[5][5];
        }else{
            this.grid = grid;
        }
    }

    public LightsOutAdapter() {

        Context context;
        boolean[][] grid;
        LightsOutGame game;
    }


    @Override
    public int getCount(){
        return grid.length * this.grid[0].length;
    }

    @Override
    public Object getItem(int position){
        int row = position / 5;
        int col = position % 5;
        return grid[row][col];
    }

    @Override
    public long getItemId(int pos){
        return pos;

    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(context);
            button.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            button = (Button) convertView;
        }
        int row = pos / 5;
        int col = pos % 5;
        boolean isBlack = grid[row][col];

        button.setBackgroundResource(isBlack ? R.drawable.square_black : R.drawable.square_white);
        button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            //toggle squares when clicked
            game.togSquares(row, col);
            notifyDataSetChanged();
            if (game.isGameWon()) {
                //find testView for win message and make it visible
                TextView winMessage = ((Activity) context).findViewById(R.id.winMessage);
                winMessage.setVisibility(View.VISIBLE);//display winning message
            }
        }
    });
            return button;
        }

}
