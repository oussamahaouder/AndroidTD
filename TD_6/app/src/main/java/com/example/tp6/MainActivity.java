package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    public EditText text;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView1);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> onClick(v));

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Home.class);
        intent.putExtra("GitRepo", (Parcelable) text);
        startActivity(intent);

    };
}


