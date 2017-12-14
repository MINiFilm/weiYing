package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.weiying.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IntoActivity extends BaseActivity {
    @Bind(R.id.iv_into)
    ImageView iv_into;
    private int i=5;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==2){
                startActivity(new Intent(IntoActivity.this,MainActivity.class));
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);
        ButterKnife.bind(this);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.scale);
        iv_into.startAnimation(animation);
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(1000);
                        i--;
                        handler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
