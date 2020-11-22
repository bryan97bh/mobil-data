package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private Button botaoDedata;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoDedata = findViewById(R.id.button);

        Data dataInicial = new Data(10, 2, 2020);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Data selectedDate = new Data(dayOfMonth, month, year);
                enviarData(selectedDate);
            }
        }, dataInicial.getAno(), dataInicial.getMes(), dataInicial.getDia());

        botaoDedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    public void enviarData(Data selectedDate) {
        Intent intent = new Intent( MainActivity.this, SecondActivity.class);
        intent.putExtra("data", selectedDate);
        startActivity(intent);
    }
}