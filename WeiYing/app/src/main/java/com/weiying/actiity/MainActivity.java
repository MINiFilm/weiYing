package com.weiying.actiity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.weiying.R;
import com.weiying.fragment.FragmentChoice;
import com.weiying.fragment.FragmentFind;
import com.weiying.fragment.FragmentMine;
import com.weiying.fragment.FragmentSpecial;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.rb2)
    RadioButton rb2;
    @Bind(R.id.rb3)
    RadioButton rb3;
    @Bind(R.id.rb4)
    RadioButton rb4;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        addFragment("fragmentHome", new FragmentChoice());
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb1:
                addFragment("homefragment",new FragmentChoice());
                break;
            case R.id.rb2:
                addFragment("classfragment",new FragmentSpecial());
                break;
            case R.id.rb3:
                addFragment("findfragment",new FragmentFind());
                break;
            case R.id.rb4:
                addFragment("carfragment",new FragmentMine());
                break;

        }
    }

    private void addFragment(String tag, Fragment fragment) {
        FragmentTransaction beginTransaction = manager
                .beginTransaction();
        beginTransaction.replace(R.id.fram, fragment, tag);
        //需要确定的tag,需要fragment 在commit之前,添加到回退栈
        beginTransaction.addToBackStack(tag);
        beginTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            int backStackEntryCount = manager.getBackStackEntryCount();
            if (backStackEntryCount > 1) {
                while (manager.getBackStackEntryCount() > 1) {
                    manager.popBackStackImmediate();
                    rb1.setChecked(true);
                }
            } else {
                finish();
            }
        }
        return true;
    }

}
