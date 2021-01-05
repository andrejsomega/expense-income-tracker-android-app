package com.example.work.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.work.R;

public class ExpenseCategoriesFragment extends Fragment {
    private Button showCategoryButton;

//    private ExpenseCategoriesOverview expenseCategoriesOverviewVM;
//    private AppRepository repository;
//
//    private List<TransactionCategory> transactionCategories;
//    private List<Transaction> transactions;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_categories_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showCategoryButton = (Button) getActivity().findViewById(R.id.showCategoryButton);
        showCategoryButton.setOnClickListener(v -> showCategory(v));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        expenseCategoriesOverviewVM = new ViewModelProvider(this, new MyViewModelFactory(repository, Constants.EXPENSE_ID)).get(ExpenseCategoriesOverview.class);
//
//        expenseCategoriesOverviewVM.getSubCategories().observe(getViewLifecycleOwner(), new Observer<List<TransactionCategory>>() {
//            @Override
//            public void onChanged(List<TransactionCategory> transactionCategories) {
//                setTC(transactionCategories);
//            }
//        });
//
//        expenseCategoriesOverviewVM.getDirectTransactions().observe(getViewLifecycleOwner(), new Observer<List<Transaction>>() {
//            @Override
//            public void onChanged(List<Transaction> transactions) {
//                setT(transactions);
//            }
//        });
    }

//    void setTC(List<TransactionCategory> transactionCategories) {
//        this.transactionCategories = transactionCategories;
//    }
//
//    void setT(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }

    public void showCategory(View v) {
        long expenseCategoryId = 10;
        ExpenseCategoriesFragmentDirections.ShowExpenseCategory direction = ExpenseCategoriesFragmentDirections.showExpenseCategory().setId(expenseCategoryId);

        Navigation.findNavController(v).navigate(direction);
    }
}