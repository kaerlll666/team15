package com.app.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoraGameActivity extends AppCompatActivity {

    private TextView mTxtCom, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        mTxtCom = findViewById(R.id.txtCom);
        mTxtResult = findViewById(R.id.txtResult);
        mBtnScissors = findViewById(R.id.btnScissors);
        mBtnStone = findViewById(R.id.btnStone);
        mBtnPaper = findViewById(R.id.btnPaper);

        // 設定剪刀、石頭、布三個按鈕的Click Listener
        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 電腦亂數出拳.
            int iComPlay = (int)(Math.random()*3 + 1);

            // 1:剪刀, 2:石頭, 3:布
            switch (iComPlay) {
                case 1:   // 平手
                    mTxtCom.setText(R.string.scissors);
                    mTxtResult.setText(getString(R.string.draw));
                    break;
                case 2:   // 玩家輸
                    mTxtCom.setText(R.string.stone);
                    mTxtResult.setText(getString(R.string.lose));
                    break;
                case 3:   // 玩家贏
                    mTxtCom.setText(R.string.paper);
                    mTxtResult.setText(getString(R.string.win));
                    break;
            }
        }
    };

    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 電腦亂數出拳.
            int iComPlay = (int)(Math.random()*3 + 1);

            // 1:剪刀, 2:石頭, 3:布
            switch (iComPlay) {
                case 1:   // 玩家贏
                    mTxtCom.setText(R.string.scissors);
                    mTxtResult.setText(getString(R.string.win));
                    break;
                case 2:   // 平手
                    mTxtCom.setText(R.string.stone);
                    mTxtResult.setText(getString(R.string.draw));
                    break;
                case 3:   // 玩家輸
                    mTxtCom.setText(R.string.paper);
                    mTxtResult.setText(getString(R.string.lose));
                    break;
            }
        }
    };

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 電腦亂數出拳.
            int iComPlay = (int)(Math.random()*3 + 1);

            // 1:剪刀, 2:石頭, 3:布
            switch (iComPlay) {
                case 1:   // 玩家輸
                    mTxtCom.setText(R.string.scissors);
                    mTxtResult.setText(getString(R.string.lose));
                    break;
                case 2:   // 玩家贏
                    mTxtCom.setText(R.string.stone);
                    mTxtResult.setText(getString(R.string.win));
                    break;
                case 3:   // 平手
                    mTxtCom.setText(R.string.paper);
                    mTxtResult.setText(getString(R.string.draw));
                    break;
            }
        }
    };
}
