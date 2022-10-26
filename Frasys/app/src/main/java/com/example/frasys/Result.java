package com.example.frasys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Result extends AppCompatActivity {

    TextView rateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        rateText = findViewById(R.id.rateText);

        Bundle arguments = getIntent().getExtras();
        rateText = findViewById(R.id.rateText);
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        double res = Double.parseDouble(arguments.get("rate").toString());
        String result = decimalFormat.format(res);
        rateText.setText(result);

    }

    public void about(View v) {
            switch (v.getId()) {
                case R.id.btnS:
                    Intent intent = new Intent(this, About.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
    }

    public void menu(View v) {
        switch (v.getId()) {
            case R.id.btnMM:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}