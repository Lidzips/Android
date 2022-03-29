package com.example.chapter3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // Пример 2.1 - обработка EditText со слушателем
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        EditText editText = findViewById(R.id.editText);
//
//        editText.addTextChangedListener(new TextWatcher() {
//
//            public void afterTextChanged(Editable s) {}
//
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                TextView textView = findViewById(R.id.textView);
//                textView.setText(s);
//            }
//        });
//    }

    // Пример 3 - обработка нажатия кнопки
//    public void sendMessage(View view) {
//        TextView textView = findViewById(R.id.textView);
//        EditText editText = findViewById(R.id.editText);
//        textView.setText("Добро пожаловать, " + editText.getText());
//    }

    // Пример 4 - вывод Toast
//    public  void onClick(View view){
//        Toast toast = Toast.makeText(this, "Hello Android!",Toast.LENGTH_LONG);
//        toast.show();
//    }

    // Пример 4.1 - Toast вверху экрана
//    public  void onClick(View view){
//
//        Toast toast = Toast.makeText(this, "Hello Android!", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.TOP, 0,160);   // import android.view.Gravity;
//        toast.show();
//    }

    // Пример 4.2 кастомный Toast
//    public  void onClick(View view){
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_layout));
//
//        TextView text = layout.findViewById(R.id.text);
//        text.setText("Hello Android!");
//
//        Toast toast = new Toast(getApplicationContext());
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(layout);
//        toast.show();
//    }

    // Пример 5 - вывод Snackbar
//    public  void onClick(View view){
//        Snackbar.make(view, "Hello Android", Snackbar.LENGTH_LONG)
//                .show();
//    }

    // Пример 5.1 - Snackbar с обработчиком
//    public  void onClick(View view){
//        Snackbar snackbar = Snackbar.make(view, "Hello Android", Snackbar.LENGTH_LONG);
//
//        snackbar.setAction("Next...", new View.OnClickListener (){
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(getApplicationContext(), "Next clicked!",Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });
//        snackbar.show();
//    }

    // Пример 6 - Checkbox
//    public void onCheckboxClicked(View view) {
//        // Получаем флажок
//        CheckBox checkBox = (CheckBox) view;
//        TextView selection = findViewById(R.id.selection);
//        // Получаем, отмечен ли данный флажок
//        if(checkBox.isChecked()) {
//            selection.setText("Включено");
//            checkBox.setText("Выключить");
//        }
//        else {
//            selection.setText("Выключено");
//            checkBox.setText("Включить");
//        }
//    }

    // Пример 7 - ToggleButton
//    public void onToggleClicked(View view) {
//
//        // включена ли кнопка
//        boolean on = ((ToggleButton) view).isChecked();
//        if (on) {
//            // действия если включена
//            Toast.makeText(this, "Свет включен", Toast.LENGTH_LONG).show();
//        } else {
//            // действия, если выключена
//            Toast.makeText(this, "Свет выключен!", Toast.LENGTH_LONG).show();
//        }
//    }

    // Пример 8 - RadioButton
//    public void onRadioButtonClicked(View view) {
//        // если переключатель отмечен
//        boolean checked = ((RadioButton) view).isChecked();
//        TextView selection = findViewById(R.id.selection);
//        // Получаем нажатый переключатель
//        switch(view.getId()) {
//            case R.id.java:
//                if (checked){
//                    selection.setText("Выбрана Java");
//                }
//                break;
//            case R.id.kotlin:
//                if (checked){
//                    selection.setText("Выбран Kotlin");
//                }
//                break;
//        }
//    }

    // Пример 8.1 - RadioButton OnCheckedChangeListener
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // получаем объект RadioGroup
//        RadioGroup radGrp = (RadioGroup)findViewById(R.id.radios);
//        // обработка переключения состояния переключателя
//        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup arg0, int id) {
//                TextView selection = findViewById(R.id.selection);
//                switch(id) {
//                    case R.id.java:
//                        selection.setText("Выбрана Java");
//                        break;
//                    case R.id.kotlin:
//                        selection.setText("Выбран Kotlin");
//                        break;
//                    default:
//                        break;
//                }
//            }});
//    }

    // Пример 9 - DatePicker
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView dateTextView = findViewById(R.id.dateTextView);
//        DatePicker datePicker = this.findViewById(R.id.datePicker);
//
//        // Месяц начиная с нуля. Для отображения добавляем 1.
//        datePicker.init(2020, 02, 01, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//                // Отсчет месяцев начинается с нуля. Для отображения добавляем 1.
//                dateTextView.setText("Дата: " + view.getDayOfMonth() + "/" +
//                        (view.getMonth() + 1) + "/" + view.getYear());
//
//                // альтернативная запись
//                // dateTextView.setText("Дата: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
//            }
//        });
//    }

    // Пример 10 - TimePicker
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView timeTextView = findViewById(R.id.timeTextView);
//        TimePicker timePicker = findViewById(R.id.timePicker);
//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//
//                timeTextView.setText("Время: " + hourOfDay + ":" + minute);
//                // или так
//                // timeTextView.setText("Время: " + view.getHour() + ":" + view.getMinute());
//            }
//        });
//    }

    // Пример 11 - SeekBar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textView = findViewById(R.id.seekBarValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
}