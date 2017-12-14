package com.weiying.utils;

import android.content.Context;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.weiying.R;

/**
 * Created by yuexingchuan on 17/9/17.
 */

public class ThemeUtil {
    public static void onColorSelection(Context context, ColorChooserDialog dialog, int selectedColor) {
        if (selectedColor == ThemeUtils.getThemeColor(context, R.attr.colorPrimary))
            return;

        if (selectedColor == context.getResources().getColor(R.color.colorBluePrimary)) {
            context.setTheme(R.style.BlueTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Blue);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#2196F3");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorRedPrimary)) {
            context.setTheme(R.style.RedTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Red);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#F44336");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorBrownPrimary)) {
            context.setTheme(R.style.BrownTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Brown);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#795548");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorGreenPrimary)) {
            context.setTheme(R.style.GreenTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Green);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#4CAF50");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorPurplePrimary)) {
            context.setTheme(R.style.PurpleTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Purple);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#9c27b0");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorTealPrimary)) {
            context.setTheme(R.style.TealTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Teal);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#009688");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorPinkPrimary)) {
            context.setTheme(R.style.PinkTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Pink);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#E91E63");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorDeepPurplePrimary)) {
            context.setTheme(R.style.DeepPurpleTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.DeepPurple);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#673AB7");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorOrangePrimary)) {
            context.setTheme(R.style.OrangeTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Orange);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#FF9800");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorIndigoPrimary)) {
            context.setTheme(R.style.IndigoTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Indigo);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#3F51B5");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorLightGreenPrimary)) {
            context.setTheme(R.style.LightGreenTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.LightGreen);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#8BC34A");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorDeepOrangePrimary)) {
            context.setTheme(R.style.DeepOrangeTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.DeepOrange);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "##FF5722");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorLimePrimary)) {
            context.setTheme(R.style.LimeTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Lime);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#CDDC39");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorBlueGreyPrimary)) {
            context.setTheme(R.style.BlueGreyTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.BlueGrey);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#CDDC39");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(R.color.colorCyanPrimary)) {
            context.setTheme(R.style.CyanTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Cyan);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#00BCD4");
            PreUtils.putString(context, Constants.TITLECOLOR, "#ffffff");
        } else if (selectedColor == context.getResources().getColor(android.R.color.black)) {
            context.setTheme(R.style.BlackTheme);
            PreUtils.setCurrentTheme(context, com.weiying.utils.theme.Theme.Black);
            PreUtils.putString(context, Constants.PRIMARYCOLOR, "#000000");
            PreUtils.putString(context, Constants.TITLECOLOR, "#0aa485");
        }

    }
}
