package com.example.lightout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Authored by Luis Perez
public class MainActivity extends AppCompatActivity {
    private LightsOutAdapter adapter;
    private LightsOutGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializw the game and adapter
        GridView gridView = findViewById(R.id.gridView);
        game =  new LightsOutGame();
        adapter = new LightsOutAdapter(this, game.getGrid(), game);
        gridView.setAdapter(adapter);
        //set up reset button onClickListener
        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(View -> {
            //reset game and update adapter
            game.reset();
            adapter.notifyDataSetChanged();
            TextView winMessage = findViewById(R.id.winMessage);
            winMessage.setVisibility(View.GONE);//Hide the message when reset is pushed after winning
        });
    }
   /// public void resetGame(View view) {
   //     game.reset();
     //  adapter.notifyDataSetChanged();
//
    //    TextView winMessage = findViewById(R.id.winMessage);
    //    winMessage.setVisibility(View.GONE);
   // }
}