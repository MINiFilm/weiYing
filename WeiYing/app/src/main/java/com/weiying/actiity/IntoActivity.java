package com.weiying.actiity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.weiying.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IntoActivity extends AppCompatActivity {
    @Bind(R.id.iv_into)
    ImageView iv_into;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);
        ButterKnife.bind(this);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.scale);
        iv_into.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(IntoActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
