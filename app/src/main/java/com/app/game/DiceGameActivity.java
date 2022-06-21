package com.app.game;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class DiceGameActivity extends AppCompatActivity {

    private ImageView mImgViewDice;
    private TextView mTxtResult;
    private Button mBtnRollDice;

    // 建立一個靜態的Handler類別
    private static class StaticHandler extends Handler {
        private final WeakReference<DiceGameActivity> mActivity;

        public StaticHandler(DiceGameActivity activity) {
            mActivity = new WeakReference<DiceGameActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            // 檢查App是否還存在，如果不存在就離開
            DiceGameActivity activity = mActivity.get();
            if (activity == null) return;

            // 用亂數決定骰子點數
            int iRand = (int)(Math.random()*6 + 1);

            // 顯示結果
            String s = activity.getString(R.string.dice_result);
            activity.mTxtResult.setText(s + iRand);
            switch (iRand) {
                case 1:
                    activity.mImgViewDice.setImageResource(R.drawable.dice01);
                    break;
                case 2:
                    activity.mImgViewDice.setImageResource(R.drawable.dice02);
                    break;
                case 3:
                    activity.mImgViewDice.setImageResource(R.drawable.dice03);
                    break;
                case 4:
                    activity.mImgViewDice.setImageResource(R.drawable.dice04);
                    break;
                case 5:
                    activity.mImgViewDice.setImageResource(R.drawable.dice05);
                    break;
                case 6:
                    activity.mImgViewDice.setImageResource(R.drawable.dice06);
                    break;
            }

        }
    }

    // 使用自己建立的靜態Handler避免出現記憶體漏洞。
    public final StaticHandler mHandler = new StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        mImgViewDice = findViewById(R.id.imgViewDice);
        mTxtResult = findViewById(R.id.txtResult);
        mBtnRollDice = findViewById(R.id.btnRollDice);

        mBtnRollDice.setOnClickListener(btnRollDiceOnClick);
    }

    private View.OnClickListener btnRollDiceOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = getString(R.string.dice_result);
            mTxtResult.setText(s);

            // 從程式資源載入動畫，設定給ImageView物件，然後開始播放
            Resources res = getResources();
            final AnimationDrawable animDraw =
                    (AnimationDrawable) res.getDrawable(R.drawable.anim_roll_dice);
            mImgViewDice.setImageDrawable(animDraw);
            animDraw.start();

            // 啟動Background Thread計時
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    animDraw.stop();
                    mHandler.sendMessage(mHandler.obtainMessage());
                }
            }).start();
        }
    };
}
