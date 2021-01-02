package com.example.bakalarka.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

import com.example.bakalarka.MyApplication;
import com.example.bakalarka.R;
import com.example.bakalarka.repositories.DefaultRepository;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication myApplication = ((MyApplication) getApplication());
        myApplication.setUpComponents();
        DefaultRepository repository = myApplication.appContainer.repository;

        Bundle args = new Bundle();
        args.putString("Test", "Hello");
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navHostFragment.getNavController().setGraph(R.navigation.nav_graph, args);


//        NavHostFragment navHostFragment = NavHostFragment.create(R.navigation.nav_graph, args);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        navController.setGraph(R.navigation.nav_graph, args);
    }
}
