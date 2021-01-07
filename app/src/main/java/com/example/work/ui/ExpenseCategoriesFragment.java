package com.example.work.ui;

import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.work.R;
import com.example.work.di.TCContentViewModelFactory;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.repositories.AppRepository;
import com.example.work.utils.Constants;
import com.example.work.viewmodels.TransactionCategoryContentViewModel;

import java.util.List;

public class ExpenseCategoriesFragment extends Fragment {
    private AppRepository repository;

    private TransactionCategoryContentViewModel expenseCategoriesOverviewVM;
    private List<TransactionCategory> directSubCategories;
    private List<Transaction> directTransactions;

    public static final String CATEGORY_REQUEST_KEY = "category_request";

    // Todo remove testing
    private Button showCategoryButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String result1 = result.getString("bundleKey");
            }
        });
    }

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

        expenseCategoriesOverviewVM = new ViewModelProvider(this, new TCContentViewModelFactory(repository, Constants.EXPENSE_ID)).get(TransactionCategoryContentViewModel.class);

        expenseCategoriesOverviewVM.getDirectSubCategories().observe(getViewLifecycleOwner(), transactionCategories -> this.directSubCategories = transactionCategories);

        expenseCategoriesOverviewVM.getDirectTransactions().observe(getViewLifecycleOwner(), transactions -> this.directTransactions = transactions);
    }

    public void showCategory(View v) {
        long expenseCategoryId = 10;
        ExpenseCategoriesFragmentDirections.ActionExpenseCategoriesFragmentToExpenseCategoryFragment direction = ExpenseCategoriesFragmentDirections.actionExpenseCategoriesFragmentToExpenseCategoryFragment().setId(expenseCategoryId);
        Navigation.findNavController(v).navigate(direction);
    }

    public void editCategory(long id) {

    }

    public void addCategory(long id) {

    }
}