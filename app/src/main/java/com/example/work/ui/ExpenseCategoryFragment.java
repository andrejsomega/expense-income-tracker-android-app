package com.example.work.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.work.R;

public class ExpenseCategoryFragment extends Fragment {

    private Button backButton;

    public static ExpenseCategoryFragment newInstance() {
        return new ExpenseCategoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.expense_category_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backButton = (Button) getActivity().findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.ExpenseCategoriesFragment);});
        long expenseCategoryId = ExpenseCategoryFragmentArgs.fromBundle(getArguments()).getId();
        Log.d("Message", expenseCategoryId + "");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }
}