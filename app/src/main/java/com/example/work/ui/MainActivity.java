package com.example.work.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.work.MyApplication;
import com.example.work.R;
import com.example.work.repositories.DefaultRepository;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication myApplication = ((MyApplication) getApplication());
        myApplication.setUpComponents();
        DefaultRepository repository = myApplication.appContainer.repository;
    }
}
