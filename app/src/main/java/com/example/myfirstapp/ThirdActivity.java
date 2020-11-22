package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView textoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textoData = findViewById(R.id.textDate);

        Data data = (Data) getIntent().getExtras().getSerializable("data");

        textoData.setText(data.toString());
    }
}