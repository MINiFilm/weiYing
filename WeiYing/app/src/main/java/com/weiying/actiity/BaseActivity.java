package com.weiying.actiity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

/**
 * Created by dell-pc on 2017/12/7.
 */

public class BaseActivity extends AppCompatActivity {

    private ImmersionBar immersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //沉浸式
        immersionBar = ImmersionBar.with(this);
        immersionBar.init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(immersionBar != null){
            //防止内存泄露, 不调用该方法,界面bar发生变化
            immersionBar.destroy();
        }
    }
}
