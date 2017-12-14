package com.weiying.actiity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.weiying.R;
import com.weiying.fragment.FragmentChoice;
import com.weiying.fragment.FragmentFind;
import com.weiying.fragment.FragmentMine;
import com.weiying.fragment.FragmentSpecial;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.tv)
    TextView tv;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        manager.beginTransaction().replace(R.id.fram, new FragmentChoice()).commit();
                        tv.setText("精选");
                        break;
                    case R.id.rb2:
                        manager.beginTransaction().replace(R.id.fram, new FragmentSpecial()).commit();
                        tv.setText("专题");
                        break;
                    case R.id.rb3:
                        manager.beginTransaction().replace(R.id.fram, new FragmentFind()).commit();
                        tv.setText("发现");
                        break;
                    case R.id.rb4:
                        manager.beginTransaction().replace(R.id.fram, new FragmentMine()).commit();
                        tv.setText("我的");
                        break;
                }
            }
        });
    }
}
