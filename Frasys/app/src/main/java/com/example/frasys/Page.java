package com.example.frasys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.io.InputStream;


public class Page extends AppCompatActivity {

    EditText editTextStory,editTextPlay,editTextAV;

    public double rateValue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        setTitle("Fuzzy Logic Film Rating");
    }

    public void next(View v) throws Exception {
        editTextStory = findViewById(R.id.story);
        editTextPlay = findViewById(R.id.play);
        editTextAV = findViewById(R.id.av);

        String avt = editTextAV.getText().toString();
        String pt = editTextPlay.getText().toString();
        String st = editTextStory.getText().toString();

        if (st.isEmpty() || avt.isEmpty() || pt.isEmpty()) {
            Toast toast = Toast.makeText(this, "Вы не ввели какое-либо значение!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            double story = Double.parseDouble(String.valueOf(editTextStory.getText()));
            double play = Double.parseDouble(String.valueOf(editTextPlay.getText()));
            double av = Double.parseDouble(String.valueOf(editTextAV.getText()));

            if ((story > 10.0) || (story < 0.0) || (play > 10.0) || (play < 0.0) || (av > 10.0) || (av < 0.0)) {
                Toast toast = Toast.makeText(this, "Введите значения строго от 0 до 10!", Toast.LENGTH_LONG);
                toast.show();
            } else {
                switch (v.getId()) {
                    case R.id.calc:
                        fuzzyLogic(story, play, av);
                        Intent intent = new Intent(this, Result.class);
                        intent.putExtra("rate", rateValue);
                        startActivity(intent);

                        break;
                    default:
                        break;
                }
            }


        }
    }

    public void fuzzyLogic(double story, double play, double av) throws Exception {
        // Load from 'FCL' file
       // String fileName = "//src//main//res//fcl//film.fcl";
       // FIS fis = FIS.load(fileName,true);

        InputStream inputStream = getApplicationContext().getAssets().open("film.fcl");
        FIS fis = FIS.load(inputStream, true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file");
            return;
        }

        // Show
        //JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("story", story);
        fis.setVariable("play", play);
        fis.setVariable("av", av);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable rate = fis.getVariable("rate");
        double rrtt = rate.getValue();
       // JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println("Output rate is:" + fis.getVariable("rate").getValue());
        rateValue = fis.getVariable("rate").getValue();
    }
}

//src/main/res/fcl/film.fcl