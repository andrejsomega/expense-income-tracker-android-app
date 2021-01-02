package com.example.bakalarka.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bakalarka.R;
import com.example.bakalarka.di.MyViewModelFactory;
import com.example.bakalarka.models.entities.Transaction;
import com.example.bakalarka.models.entities.TransactionCategory;
import com.example.bakalarka.repositories.AppRepository;
import com.example.bakalarka.utils.Constants;
import com.example.bakalarka.viewmodels.ExpenseCategoriesOverview;

import org.w3c.dom.Text;

import java.util.List;

public class ExpenseCategoriesFragment extends Fragment {

//    private ExpenseCategoriesOverview expenseCategoriesOverviewVM;
//    private AppRepository repository;
//
//    private List<TransactionCategory> transactionCategories;
//    private List<Transaction> transactions;
    private TextView textView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_categories_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.tv);
        Bundle arguments = getArguments();
        textView.setText(arguments.getString("Test"));
        return view;
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

    public void click(View view) {

    }

}