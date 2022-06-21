package com.app.game;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image_RollDice;
    private ImageView image_Mora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_RollDice = findViewById(R.id.image_RollDice);
        image_Mora = findViewById(R.id.image_Mora);
        image_RollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DiceGameActivity.class);
                startActivity(intent);
            }
        });
        image_Mora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MoraGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
