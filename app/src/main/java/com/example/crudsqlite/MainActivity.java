package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void btnCreate (View v){
            Intent goCreate = new Intent (MainActivity.this, CreateActivity.class);
            startActivity(goCreate);
        }

        public void btnRead (View v){
            Intent goRead = new Intent(MainActivity.this, ReadActivity.class);
            startActivity(goRead);
        }

        public void btnUpdate (View v){
            Intent goUpdate = new Intent(MainActivity.this, UpdelActivity.class);
            startActivity(goUpdate);
        }
    }
