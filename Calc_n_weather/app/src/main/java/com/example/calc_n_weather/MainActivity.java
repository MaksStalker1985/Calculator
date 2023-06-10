package com.example.calc_n_weather;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /* Обьявление переменных */
    public TextView myTextView;
    double first_value;
    double second_value;
    boolean isCommaUsed = false;
    boolean isFirstEntry = true;
    boolean isSumPressed = false;
    boolean isMinusPressed = false;
    boolean isMultiplePressed = false;
    boolean isDividePressed = false;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = findViewById(R.id.textView); /* Инициализация TextViev (куда будут выводиться данные) в переменную myTextView */
        myTextView.setText("0");
        builder = new AlertDialog.Builder(this);
        builder.setMessage("На ноль делить нельзя");
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
    /* Функция, вызывающаяся при нажатии на кнопку "1" */

    public void btn_one_click(View view) {
        checkFirstEntry();
        myTextView.append("1");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "2" */
    public void btn_two_click(View view){
        checkFirstEntry();
        myTextView.append("2");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "3" */
    public void btn_three_click(View view){
        checkFirstEntry();
        myTextView.append("3");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "4" */
    public void btn_four_click(View view){
        checkFirstEntry();
        myTextView.append("4");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "5" */
    public void btn_five_click(View view){
        checkFirstEntry();
        myTextView.append("5");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "6" */
    public void btn_six_click(View view){
        checkFirstEntry();
        myTextView.append("6");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "7" */
    public void btn_seven_click(View view){
        checkFirstEntry();
        myTextView.append("7");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "8" */
    public void btn_eight_click(View view){
        checkFirstEntry();
        myTextView.append("8");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "9" */
    public void btn_nine_click(View view){
        checkFirstEntry();
        myTextView.append("9");
    }
    /* Функция, вызывающаяся при нажатии на кнопку "0" */
    public void btn_zero_click(View view){
        String value = myTextView.getText().toString();
        double conv_value = Double.parseDouble(value);
    if (conv_value != 0){
        myTextView.append("0");
    }
    }
    /* Функция, проверяющая был ли раньше ввод данных. Если не был, то очищает значение 0 в TextView */
    public void checkFirstEntry(){
        if (isFirstEntry){
            myTextView.setText("");
            isFirstEntry = false;
        }
    }
    /* Функция очистки значения на экране */
    public void clearValue(){
        myTextView.setText("0");
        isFirstEntry = true;
        isCommaUsed = false;
    }
    /* Функция, вызывающаяся при нажатии на кнопку "+" */
    public void btn_sum_click(View view){
        first_value = Double.parseDouble(myTextView.getText().toString());  /* Преобразовываем введенное значение в переменную типа double и сохраняем в first_value */
        clearValue(); /* Очищаем значение в TextView */
        isSumPressed = true; /* задаем переменной isSumPressed значение true */
    }
    /* Функция, вызывающаяся при нажатии на кнопку "-" */
    public void btn_minus_click(View view){
        first_value = Double.parseDouble(myTextView.getText().toString());
        clearValue();
        isMinusPressed = true;
    }
    /* Функция, вызывающаяся при нажатии на кнопку "*" */
    public void btn_multiple_click(View view){
        first_value = Double.parseDouble(myTextView.getText().toString());
        clearValue();
        isMultiplePressed = true;
    }
    /* Функция, вызывающаяся при нажатии на кнопку "/" */
    public void btn_divide_click(View view){
        first_value = Double.parseDouble(myTextView.getText().toString());
        clearValue();
        isDividePressed = true;
    }
    /* Функция, вызывающаяся при нажатии на кнопку "=" */
    public void btn_equal_click(View view){
        second_value = Double.parseDouble(myTextView.getText().toString());  /* Преобразовываем введенное значение в переменную типа double и сохраняем в second_value */
        /* Запускаем цикл проверки какую математическую операцию провести */
        if (isSumPressed){ /* Если был нажат "+" */
            first_value = first_value + second_value; /* Производим математическую операцию сложения */
        } else if (isMinusPressed) { /* Если был нажат "-" */
            first_value = first_value - second_value; /* Производим математическую операцию вычитания */
        } else if (isMultiplePressed) { /* Если был нажат "*" */
            first_value = first_value * second_value; /* Производим математическую операцию умножения */
        } else if (isDividePressed) { /* Если был нажат "/" */
            boolean isDivideOnZero = second_value == 0; /* Проверяем условие на деление на ноль */
            if (isDivideOnZero){ /* Если происходит деление на ноль, то показываем сообщение что на ноль делить нельзя */
                AlertDialog alert = builder.create();
                alert.show();
            }else {
            first_value = first_value / second_value;}
        }
        /* Выводим ответ в TextView */
        myTextView.setText(String.valueOf(first_value));
    }
    /* Функция, вызывающаяся при нажатии на кнопку "C" */
    public void btn_erase_click(View view){
        clearValue();
        first_value = 0;
        second_value = 0;
        isCommaUsed = false;
    }
    public void btn_comma_click(View view){
        if (!isCommaUsed){ /* Проверяем, была ли раньше нажата кнопка ",". Если нет, то вводим значение "." на экран */
            myTextView.append(".");
            isCommaUsed = true;
            isFirstEntry = false;
        }
    }
    public void btn_sign_click(View view){
            first_value = Double.parseDouble(myTextView.getText().toString());
            first_value = - first_value;
            myTextView.setText(String.valueOf(first_value));
        }
}