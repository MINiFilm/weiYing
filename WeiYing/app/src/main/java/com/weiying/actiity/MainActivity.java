package com.weiying.actiity;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.weiying.R;
import com.weiying.fragment.FragmentChoice;
import com.weiying.fragment.FragmentFind;
import com.weiying.fragment.FragmentMine;
import com.weiying.fragment.FragmentSpecial;
import com.weiying.utils.ThemeUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener,ColorChooserDialog.ColorCallback  {
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
    @Bind(R.id.btn)
    Button btn;

    public static final String Set_Theme_Color = "Set_Theme_Color";
    public final static String Banner_Stop = "Banner_Stop";
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorChooserDialog.Builder(MainActivity.this, R.string.theme)
                        .customColors(R.array.colors, null)
                        .doneButton(R.string.done)
                        .cancelButton(R.string.cancel)
                        .allowUserColorInput(false)
                        .allowUserColorInputAlpha(false)
                        .show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                addFragment("homefragment", new FragmentChoice());
                break;
            case R.id.rb2:
                addFragment("classfragment", new FragmentSpecial());
                break;
            case R.id.rb3:
                addFragment("findfragment", new FragmentFind());
                break;
            case R.id.rb4:
                addFragment("carfragment", new FragmentMine());
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

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
        ThemeUtil.onColorSelection(this, dialog, selectedColor);
        EventBus.getDefault().post(Set_Theme_Color);
    }
}
