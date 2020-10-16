package com.example.famcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnPls;
    private Button btnMul;
    private Button btnSub;
    private Button btnDiv;
    private Button btnCls;
    private Button btnBck;
    private Button btnEnt;
    private Button btnDot;
    private TextView resultScreen;
    private TextView screen;
    private String num = "";
    private String result = new String();
    private double a,b;
    private char sign;
    private boolean isFirst=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        btn0 = findViewById(R.id.b0);
        btnPls = findViewById(R.id.plus);
        btnMul = findViewById(R.id.mul);
        btnSub = findViewById(R.id.sub);
        btnDiv = findViewById(R.id.div);
        btnCls = findViewById(R.id.clr);
        btnBck = findViewById(R.id.del);
        btnEnt = findViewById(R.id.enter);
        btnDot = findViewById(R.id.dot);
        resultScreen = findViewById(R.id.resultScreen);
        screen = findViewById(R.id.numScreen);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPls.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnCls.setOnClickListener(this);
        btnBck.setOnClickListener(this);
        btnEnt.setOnClickListener(this);
        btnDot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b1){
            num+="1";
            screen.setText(num);
        }else if(v.getId()==R.id.b2){
            num+="2";
            screen.setText(num);
        }else if(v.getId()==R.id.b3){
            num+="3";
            screen.setText(num);
        }else if(v.getId()==R.id.b4){
            num+="4";
            screen.setText(num);
        }else if(v.getId()==R.id.b5){
            num+="5";
            screen.setText(num);
        }else if(v.getId()==R.id.b6){
            num+="6";
            screen.setText(num);
        }else if(v.getId()==R.id.b7){
            num+="7";
            screen.setText(num);
        }else if(v.getId()==R.id.b8){
            num+="8";
            screen.setText(num);
        }else if(v.getId()==R.id.b9){
            num+="9";
            screen.setText(num);
        }else if(v.getId()==R.id.b0){
            num+="0";
            screen.setText(num);
        }else if(v.getId()==R.id.clr){
            num = "";
            result = "";
            isFirst = false;
            screen.setText(num);
            resultScreen.setText(result);
        }else if(v.getId()==R.id.del){
            num=num.substring(0,num.length()-1);
            screen.setText(num);
        }else if(v.getId()==R.id.sub){
            if(num.equals("")) {
                num+="-";
                screen.setText(num);
            }else{
                if (isFirst) {
                    if (isNumeric(num)) {
                        b = Double.parseDouble(num);
                        if (sign == '+') {
                            result = Double.toString(a + b);
                        } else if (sign == '-') {
                            result = Double.toString(a - b);
                        } else if (sign == '*') {
                            result = Double.toString(a * b);
                        } else if (sign == '/') {
                            if (b != 0)
                                result = Double.toString(a / b);
                            else
                                result = "infinity";
                        }
                        if (isNumeric(result)) {
                            a = Double.parseDouble(result);
                            num = result;
                        } else {
                            a = 0;
                            b = 0;
                            isFirst = false;
                        }
                    } else {
                        result = "Wrong Format!!";
                    }
                } else {
                    if (isNumeric(num)) {
                        a = Double.parseDouble(num);
                        isFirst = true;
                    } else {
                        result = "Wrong Format!!";
                    }
                }
                sign = '-';
                num = "";
                if (isNumeric(num))
                    screen.setText(String.format("%.2f", Double.parseDouble(num)));
                else
                    screen.setText(num);
                if (isNumeric(result))
                    resultScreen.setText(String.format("%.2f", Double.parseDouble(result)));
                else
                    resultScreen.setText(result);
            }
        }else if(v.getId()==R.id.plus){

            if(isFirst){
                if(isNumeric(num)){
                    b=Double.parseDouble(num);
                    if(sign=='+'){
                        result =  Double.toString(a+b);
                    }else if(sign=='-'){
                        result =  Double.toString(a-b);
                    }else if(sign=='*'){
                        result =  Double.toString(a*b);
                    }else if(sign=='/'){
                        if(b!=0)
                            result =  Double.toString(a/b);
                        else
                            result = "infinity";
                    }
                    if(isNumeric(result)){
                        a=Double.parseDouble(result);
                        num = result;
                    }else{
                        a=0;
                        b=0;
                        isFirst=false;
                    }
                }else{
                    result = "Wrong Format!!";
                }
            }else{
                if(isNumeric(num)) {
                    a = Double.parseDouble(num);
                    isFirst = true;
                }else {
                    result = "Wrong Format!!";
                }
            }
            sign = '+';
            num  = "";

            if(isNumeric(num))
                screen.setText(String.format("%.2f",Double.parseDouble(num)));
            else
                screen.setText(num);
            if(isNumeric(result))
                resultScreen.setText(String.format("%.2f",Double.parseDouble(result)));
            else
                resultScreen.setText(result);
        }else if(v.getId()==R.id.mul){

            if(isFirst){
                if(isNumeric(num)){
                    b=Double.parseDouble(num);
                    if(sign=='+'){
                        result =  Double.toString(a+b);
                    }else if(sign=='-'){
                        result =  Double.toString(a-b);
                    }else if(sign=='*'){
                        result =  Double.toString(a*b);
                    }else if(sign=='/'){
                        if(b!=0)
                            result =  Double.toString(a/b);
                        else
                            result = "infinity";
                    }
                    if(isNumeric(result)){
                        a=Double.parseDouble(result);
                        num = result;
                    }else{
                        a=0;
                        b=0;
                        isFirst=false;
                    }
                }else{
                    result = "Wrong Format!!";
                }
            }else{
                if(isNumeric(num)) {
                    a = Double.parseDouble(num);
                    isFirst = true;
                }else {
                    result = "Wrong Format!!";
                }
            }
            sign = '*';
            num  = "";

            if(isNumeric(num))
                screen.setText(String.format("%.2f",Double.parseDouble(num)));
            else
                screen.setText(num);
            if(isNumeric(result))
                resultScreen.setText(String.format("%.2f",Double.parseDouble(result)));
            else
                resultScreen.setText(result);
        }else if(v.getId()==R.id.div){

            if(isFirst){
                if(isNumeric(num)){
                    b=Double.parseDouble(num);
                    if(sign=='+'){
                        result =  Double.toString(a+b);
                    }else if(sign=='-'){
                        result =  Double.toString(a-b);
                    }else if(sign=='*'){
                        result =  Double.toString(a*b);
                    }else if(sign=='/'){
                        if(b!=0)
                            result =  Double.toString(a/b);
                        else
                            result = "infinity";
                    }
                    if(isNumeric(result)){
                        a=Double.parseDouble(result);
                        num = result;
                    }else{
                        a=0;
                        b=0;
                        isFirst=false;
                    }
                }else{
                    result = "Wrong Format!!";
                }
            }else{
                if(isNumeric(num)) {
                    a = Double.parseDouble(num);
                    isFirst = true;
                }else {
                    result = "Wrong Format!!";
                }
            }
            sign = '/';
            num  = "";

            if(isNumeric(num))
                screen.setText(String.format("%.2f",Double.parseDouble(num)));
            else
                screen.setText(num);
            if(isNumeric(result))
                resultScreen.setText(String.format("%.2f",Double.parseDouble(result)));
            else
                resultScreen.setText(result);

        } else if(v.getId()==R.id.dot){
            num+=".";
            screen.setText(num);
        }else if(v.getId()==R.id.enter){
            if(isFirst){
                if(isNumeric(num)){
                    b=Double.parseDouble(num);
                    if(sign=='+'){
                        result =  Double.toString(a+b);
                    }else if(sign=='-'){
                        result =  Double.toString(a-b);
                    }else if(sign=='*'){
                        result =  Double.toString(a*b);
                    }else if(sign=='/'){
                        if(b!=0)
                            result =  Double.toString(a/b);
                        else
                            result = "infinity";
                    }
                    if(isNumeric(result)){
                        a=Double.parseDouble(result);
                        num = result;
                        b=0;
                        isFirst=false;
                    }else{
                        a=0;
                        b=0;
                        isFirst=false;
                    }
                }else{
                    result = "Wrong Format!!";
                }
            }else{
                //do nothing
            }

            if(isNumeric(num))
                screen.setText(String.format("%.2f",Double.parseDouble(num)));
            else
                screen.setText(num);
            if(isNumeric(result))
                resultScreen.setText(String.format("%.2f",Double.parseDouble(result)));
            else
                resultScreen.setText(result);
        }

    }
    private boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
