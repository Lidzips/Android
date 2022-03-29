package com.example.chapter4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    // пример 1.1 вытягивание строки через getResources
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        // получение ресурсов из файла values/strings.xml
//        String app_name = getResources().getString(R.string.app_name);
//
//        TextView textView = new TextView(this);
//        textView.setTextSize(30);
//        textView.setText(app_name);
//
//        setContentView(textView);
//    }

    //Пример 2.1 - вытягивание новой строки через код в MainActivity
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // получаем элемент textView
//        TextView textView = findViewById(R.id.textView);
//        // переустанавливаем у него текст
//        textView.setText(R.string.message);
//    }

    // Пример 4 - форматирование строк
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        Resources res = getResources();
//
//        String userName = "Евгений";
//        Calendar calendar = Calendar.getInstance();
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//
//        String text = getString(R.string.welcome_message, userName, hour, minute);
//        TextView textView = new TextView(this);
//        textView.setText(text);
//        textView.setTextSize(28);
//        setContentView(textView);
//    }

    // Пример 5 - строковые ресурсы с динамическим окончанием
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        String rose = getResources().getQuantityString(R.plurals.flowers, 21, 21);
//
//        TextView textView = new TextView(this);
//        textView.setText(rose);
//        textView.setTextSize(26);
//        setContentView(textView);
//    }

    // Пример 6 - массивы строк
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        Resources res = getResources();
//        String[] languages = res.getStringArray(R.array.languages);
//        String allLangs = "";
//        for (String lang: languages) {
//            allLangs += lang + " ";
//        }
//        TextView textView = new TextView(this);
//        textView.setText(allLangs);
//        textView.setTextSize(28);
//        setContentView(textView);
//    }

    // Пример 7.1 - применение разрешений в коде
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        // получаем ресурсы
//        Resources resources = getResources();
//        float textSize = resources.getDimension(R.dimen.text_size);
//        int hMargin = (int)resources.getDimension(R.dimen.horizontal_margin);
//        int vMargin = (int)resources.getDimension(R.dimen.vertical_margin);
//
//        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
//                (ConstraintLayout.LayoutParams.WRAP_CONTENT , ConstraintLayout.LayoutParams.WRAP_CONTENT);
//        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//
//        TextView textView = new TextView(this);
//        textView.setText("Hello Android");
//        textView.setBackgroundColor(0XFFEAEAEA);
//        // устанавливаем размер шрифт по ресурсу
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
//        // устанавливаем отступы пв соответствии с ресурсами
//        layoutParams.setMargins(hMargin, vMargin, hMargin, vMargin);
//
//        textView.setLayoutParams(layoutParams);
//        constraintLayout.addView(textView);
//
//        setContentView(constraintLayout);
//    }

    // Пример 8.1 - применение ресурсов цветов в коде
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // получаем ресурсы
        Resources resources = getResources();
        int textColor = resources.getColor(R.color.textViewFontColor);
        int backgroundColor = resources.getColor(R.color.textViewBackColor);

        ConstraintLayout constraintLayout = new ConstraintLayout(this);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT , ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;

        TextView textView = new TextView(this);
        textView.setText("Hello Android");
        textView.setTextSize(32);

        // используем ресурсы color
        textView.setTextColor(textColor);
        textView.setBackgroundColor(backgroundColor);

        textView.setLayoutParams(layoutParams);
        constraintLayout.addView(textView);

        setContentView(constraintLayout);
    }
}