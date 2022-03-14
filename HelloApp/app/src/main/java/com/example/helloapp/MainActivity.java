package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.math.MathUtils;

public class MainActivity extends AppCompatActivity {

    StringBuilder mainText = new StringBuilder();
    StringBuilder additionalText = new StringBuilder();
    double num1;
    double num2;
    boolean prevCharIsDigit = false;
    boolean firstIsZero = true;
    boolean isOperationApplied = false;
    boolean isCommaApplied = false;
    boolean isEqualsApplied = false;
    String lastOperation = "none";
    TextView display;
    TextView additionalDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.text1);
        additionalDisplay = findViewById(R.id.text2);
    }

    public void onClick1(View view) {
        enteringDigitEnc("1");
    }

    public void onClick2(View view) {
        enteringDigitEnc("2");
    }

    public void onClick3(View view) {
        enteringDigitEnc("3");
    }

    public void onClick4(View view) {
        enteringDigitEnc("4");
    }

    public void onClick5(View view) {
        enteringDigitEnc("5");
    }

    public void onClick6(View view) {
        enteringDigitEnc("6");
    }

    public void onClick7(View view) {
        enteringDigitEnc("7");
    }

    public void onClick8(View view) {
        enteringDigitEnc("8");
    }

    public void onClick9(View view) {
        enteringDigitEnc("9");
    }

    public void enteringDigitEnc(String digit) {
        if (!prevCharIsDigit) {
            mainText.setLength(0);
            firstIsZero = false;
        }
        mainText.append(digit);
        prevCharIsDigit = true;

        display.setText(mainText.toString());
    }

    public void onClick0(View view) {
        if (prevCharIsDigit && !firstIsZero) {
            mainText.append("0");
        } else if (!prevCharIsDigit && firstIsZero) {
            mainText.setLength(0);
            mainText.append("0");
        }

        display.setText(mainText.toString());
    }

    public void onClickComma(View view) {
        if (!isCommaApplied) {
            if (prevCharIsDigit && !firstIsZero) {
                mainText.append(".");
            } else {
                mainText.setLength(0);
                mainText.append("0.");
                firstIsZero = false;
            }
        }
        prevCharIsDigit = true;
        isCommaApplied = true;

        display.setText(mainText.toString());
    }

    public void onClickC(View view) {
        if (mainText.length() > 1) {
            if (mainText.charAt(mainText.length() - 1) == '.') {
                isCommaApplied = false;
            }
            mainText.deleteCharAt(mainText.length() - 1);
        } else if (mainText.length() == 1) {
            mainText.setLength(0);
            mainText.append("0");
            firstIsZero = true;
            prevCharIsDigit = false;
        }
        display.setText(mainText.toString());
    }

    public void onClickCE(View view) {
        mainText.setLength(0);
        additionalText.setLength(0);

        display.setText("0");
        additionalDisplay.setText("");
        firstIsZero = true;
        isCommaApplied = false;
        prevCharIsDigit = false;
        isOperationApplied = false;
    }

    public void onClickEquals(View view) {
        if (prevCharIsDigit && isOperationApplied) {
            num2 = Double.parseDouble(mainText.toString());
            additionalText.append(mainText.toString());
            additionalText.append(" = ");
            additionalDisplay.setText(additionalText.toString());
            applyOperation(lastOperation);
            isOperationApplied = false;
            isEqualsApplied = true;
        }
    }

    public void applyOperation(String operation) {
        String result = "";
        if (prevCharIsDigit) {
            switch (operation) {
                case "div":
                    double doubleValue = num1 / num2;
                    int intValue = (int) doubleValue;
                    result = Integer.toString(intValue);
                    break;
                case "mod":
                    double value = num1 % num2;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "/":
                    value = num1 / num2;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "*":
                    value = num1 * num2;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "-":
                    value = num1 - num2;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "+":
                    value = num1 + num2;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                default:
                    break;
            }
        } else {
            switch (operation) {
                case "abs":
                    double value = Math.abs(num1);
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "fact":
                    value = num1;
                    int fact = 1;
                    for (int i = 1; i <= value; i++) {
                        fact *= i;
                    }
                    value = fact;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "1/":
                    value = 1 / num1;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                case "+/-":
                    value = -num1;
                    if ((int)value == value) {
                        result = Integer.toString((int)value);
                    } else {
                        result = Double.toString(value);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!result.equals("") && !result.equals("0")) {
            prevCharIsDigit = true;
        }
        mainText.setLength(0);
        mainText.append(result);
        display.setText(mainText.toString());
    }

    public void onClickDiv(View view) {
        binaryOperationEncapsulation("div");
    }

    public void onClickMod(View view) {
        binaryOperationEncapsulation("mod");
    }

    public void onClickDivision(View view) {
        binaryOperationEncapsulation("/");
    }

    public void onClickMultiply(View view) {
        binaryOperationEncapsulation("*");
    }

    public void onClickSubtraction(View view) {
        binaryOperationEncapsulation("-");
    }

    public void onClickAddition(View view) {
        binaryOperationEncapsulation("+");
    }

    public void binaryOperationEncapsulation(String operation) {
        if (prevCharIsDigit) {
            if (isOperationApplied) {
                num2 = Double.parseDouble(mainText.toString());
                additionalText.append(mainText.toString());
                additionalText.append(" ");
                additionalText.append(operation);
                additionalText.append(" ");
                additionalDisplay.setText(additionalText.toString());
                applyOperation(lastOperation);
                num1 = Double.parseDouble(mainText.toString());
            } else {
                num1 = Double.parseDouble(mainText.toString());
                additionalText.setLength(0);
                additionalText.append(mainText.toString());
                additionalText.append(" ");
                additionalText.append(operation);
                additionalText.append(" ");
                additionalDisplay.setText(additionalText.toString());
                isOperationApplied = true;
            }
            lastOperation = operation;
            prevCharIsDigit = false;
            isCommaApplied = false;
            firstIsZero = true;
        }

    }

    public void onClickModule(View view) {
        unaryOperationEncapsulation("abs");
    }

    public void onClickFact(View view) {
        unaryOperationEncapsulation("fact");
    }

    public void onClickReverse(View view) {
        unaryOperationEncapsulation("1/");
    }

    public void onClickSignChange(View view) {
        unaryOperationEncapsulation("+/-");
    }

    public void unaryOperationEncapsulation(String operation) {
        if (prevCharIsDigit) {
            additionalText.setLength(0);
            additionalDisplay.setText(additionalText.toString());
            if (isOperationApplied) {
                num2 = Double.parseDouble(mainText.toString());
                applyOperation(lastOperation);
                isOperationApplied = false;
            }
            additionalText.append(operation);
            additionalText.append("(");
            additionalText.append(mainText.toString());
            additionalText.append(")");
            additionalDisplay.setText(additionalText.toString());
            num1 = Double.parseDouble(mainText.toString());
            num2 = 0;
            prevCharIsDigit = false;
            applyOperation(operation);
            lastOperation = "none";
            isCommaApplied = false;
            firstIsZero = true;
        }
    }



}