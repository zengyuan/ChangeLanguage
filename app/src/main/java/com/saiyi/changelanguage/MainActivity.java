package com.saiyi.changelanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_main_four);

    }

    public void chineseClick(View view) {
        changeLanguage(1);
    }

    public void englishClick(View view) {
        changeLanguage(2);
    }

    public void japaneseClick(View view) {
        changeLanguage(3);
    }

    private void changeLanguage(int type) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        Locale locale = null;
        switch (type) {
            case 1:
                locale = Locale.SIMPLIFIED_CHINESE;//中文
                break;
            case 2:
                locale = Locale.ENGLISH;//英语
                break;
            case 3:
                locale = Locale.JAPAN;//日语
                break;
        }
        //17以上利用 setLocale（）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, displayMetrics);
        //重新启动该Activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
