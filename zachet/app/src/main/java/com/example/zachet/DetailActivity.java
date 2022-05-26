package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    String name = "";
    int age;
    String description = "";
    Double payment;
    String address = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("name");
            age = args.getInt("age");
            description = args.getString("description");
            payment = args.getDouble("payment");
            address = args.getString("address");
        }
        TextView nameAgeText = findViewById(R.id.employer_name_age);
        TextView descText = findViewById(R.id.job_description);
        TextView paymentText = findViewById(R.id.job_payment_1);

        nameAgeText.setText(name + " " + age);
        descText.setText(description);
        paymentText.setText("Оплата: " + payment);

    }

    public void onClickConfirmJob(View view) {
        Toast.makeText(getApplicationContext(), "Обращайтесь по адресу " + address,
                Toast.LENGTH_LONG).show();
    }
}