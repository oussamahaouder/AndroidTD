package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = findViewById(R.id.button1);
        TextView De = findViewById(R.id.textView2);
        TextView De2 = findViewById(R.id.textView3);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText value = (EditText) findViewById(R.id.editText);
                int max = Integer.parseInt(String.valueOf(value.getText()));
                if(max > 0) {
                    Toast toast = Toast.makeText(MainActivity.this, "les Dé sont lancés!", Toast.LENGTH_SHORT);
                    toast.show();
                    De.setText(String.valueOf((int) Math.floor(Math.random() * (max - 1 + 1) + 1)));
                    De2.setText(String.valueOf((int) Math.floor(Math.random() * (max - 1 + 1) + 1)));
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, "Saisiez une valeur non null!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

}