package com.gorodenskiy.dmitrygorodenskiylab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView titleText;
    EditText inputField;
    String originalTitle;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);
        inputField = findViewById(R.id.inputField);

        originalTitle = titleText.getText().toString();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        button2.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Нажата кнопка 2", Toast.LENGTH_SHORT).show()
        );

        button3.setOnClickListener(view -> {
            String currentDateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
            Toast.makeText(MainActivity.this, currentDateTime, Toast.LENGTH_SHORT).show();
        });

        button4.setOnClickListener(view -> {
            String input = inputField.getText().toString();
            Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
        });

        button5.setOnClickListener(view -> {
            titleText.setText("Текст изменён!");
            handler.postDelayed(() -> titleText.setText(originalTitle), 5000);
        });
    }
}
