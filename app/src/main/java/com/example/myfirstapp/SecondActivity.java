package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Data data;

    private TextView textoData;
    private Button botaoConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        data = (Data) getIntent().getExtras().getSerializable("data");
        textoData = findViewById(R.id.textoData);
        botaoConcluir = findViewById(R.id.botaoConcluir);

        atualizarData();

        botaoConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }

    private void atualizarData() {
        textoData.setText(data.toString());
    }

    public void incrementDay(View view) {
        data.incrementaDia();
        atualizarData();
    }

    public void incrementMonth(View view) {
        data.incrementaMes();
        atualizarData();
    }

    public void incrementYear(View view) {
        data.incrementaAno();
        atualizarData();
    }
}