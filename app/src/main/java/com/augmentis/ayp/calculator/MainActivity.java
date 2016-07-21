package com.augmentis.ayp.calculator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private Button clearButton;
    private Button divideButton;
    private Button multipleButton;
    private Button backspaceButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button equalButton;
    private Button zeroButton;
    private Button minusButton;
    private Button plusButton;

    private TextView calculationText;
    private TextView resultText;

    private float firstNumber;
    private String firstNumberString;
    private float secondNumber;
    private String secondNumberString;
    private float resultNumber;
    private String operator;

    private String stringBuffer;
    private String calculationTextBuffer;

    boolean isOperandPress;
    boolean isEqualPress;

    private void getSecondNumber(){

    }

    private float Calculation(float firstNumber, float secondNumber, String operator){
        float result;
        if(operator == "plus"){
            result = firstNumber + secondNumber;
        } else if (operator == "minus") {
            result = firstNumber - secondNumber;
        }else if(operator == "multiple"){
            result = firstNumber * secondNumber;
        }else if(operator == "divide"){
            result = firstNumber / secondNumber;
        }else {
            return 0;
        }

        return result;
    }

    private void setCalculationText(){
        String oSign;
        if(operator == "plus"){
            oSign = "+";
        }else if (operator == "minus"){
            oSign = "-";
        }else if (operator == "multiple"){
            oSign = "*";
        }else if(operator == "divide"){
            oSign = "/";
        }else {
            oSign = " ";
        }
        calculationTextBuffer = calculationTextBuffer + stringBuffer + " " + oSign + " ";
        calculationText.setText(calculationTextBuffer);
    }

    private void setResultText(String input){
        if(resultText.getText().charAt(0) == '0' && input == "0"){
            stringBuffer = "0";
        }else if(resultText.getText().charAt(0) == '0'){
            stringBuffer = stringBuffer + input;
            if(stringBuffer.length() > 1){
                stringBuffer = stringBuffer.substring(1);
            }
        }else if(isEqualPress){
            stringBuffer = "";
        }else{
            stringBuffer = stringBuffer + input;
        }
        resultText.setText(stringBuffer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringBuffer = "";
        calculationTextBuffer = "";

        firstNumber = 0;
        isOperandPress = false;
        isEqualPress = false;

        calculationText = (TextView) findViewById(R.id.calculation_text);
        resultText = (TextView) findViewById(R.id.result_text);
        calculationText.setText("");
        operator = "";
        resultText.setText("0");

        firstNumberString = "";
        secondNumberString = "";


        clearButton = (Button) findViewById(R.id.clear_button);
        divideButton = (Button) findViewById(R.id.divide_button);
        multipleButton = (Button) findViewById(R.id.multiple_button);
        backspaceButton = (Button) findViewById(R.id.backspace_button);
        sevenButton = (Button) findViewById(R.id.seven_button);
        eightButton = (Button) findViewById(R.id.eight_button);
        nineButton = (Button) findViewById(R.id.nine_button);
        fourButton = (Button) findViewById(R.id.four_button);
        fiveButton = (Button) findViewById(R.id.five_button);
        sixButton = (Button) findViewById(R.id.six_button);
        oneButton = (Button) findViewById(R.id.one_button);
        twoButton = (Button) findViewById(R.id.two_button);
        threeButton = (Button) findViewById(R.id.three_button);
        equalButton = (Button) findViewById(R.id.equal_button);
        zeroButton = (Button) findViewById(R.id.zero_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        plusButton = (Button) findViewById(R.id.plus_button);

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEqualPress = true;
                if(isOperandPress){
                    try {
                        firstNumber = Float.valueOf(firstNumberString);
                        if(stringBuffer == ""){
                            secondNumber = firstNumber;
                        }else{
                            secondNumber = Float.valueOf(stringBuffer);
                        }
                        resultNumber = Calculation(firstNumber, secondNumber, operator);
                        Log.d(TAG, "stringBuffer : " + stringBuffer + " FirstNum : " + firstNumberString + " Operator : " + operator + " ResultNumber : " + resultNumber);
                        resultText.setText(resultNumber + "");
                    }catch (Exception e){

                    }

                }else{

                }
//                try{
//                    firstNumber = Float.valueOf(firstNumberString);
//                    secondNumber = Float.valueOf(stringBuffer);
//                    resultNumber = Calculation(firstNumber, secondNumber, operator);
//                    resultText.setText(resultNumber + "");
//                }catch (Exception e){
//
//                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringBuffer = "";
                calculationTextBuffer = "";
                resultText.setText("0");
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "plus";
                firstNumberString = stringBuffer;
                stringBuffer = "";
                isOperandPress = true;



//                setCalculationText();

            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "minus";
                firstNumberString = stringBuffer;
                stringBuffer = "";
                isOperandPress = true;
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "divide";
                firstNumberString = stringBuffer;
                stringBuffer = "";
                isOperandPress = true;
            }
        });

        multipleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = "multiple";
                firstNumberString = stringBuffer;
                stringBuffer = "";
                isOperandPress = true;
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("3");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("4");
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("5");
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("6");
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("7");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("8");
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("9");
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResultText("0");
            }
        });

        Log.d(TAG, "on create");
    }
}
