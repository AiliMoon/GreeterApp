package com.example.android.greeterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            displayGreeting("Hello, " + name + "!");
        }
    }
    public void greet(View view) {
        EditText greeting = findViewById(R.id.editText);
        name = greeting.getText().toString();
        if(name == null || greeting.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Input field is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            displayGreeting("Hello, " + name + "!");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    private void displayGreeting(String message) {
        TextView greetingText = findViewById(R.id.textView);
        greetingText.setText(message);
    }
}