package com.example.work.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.work.R;
import com.example.work.di.TCContentViewModelFactory;
import com.example.work.di.TCViewModelFactory;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.repositories.AppRepository;
import com.example.work.utils.Constants;
import com.example.work.utils.Response;
import com.example.work.utils.Status;
import com.example.work.viewmodels.TransactionCategoryContentViewModel;
import com.example.work.viewmodels.TransactionCategoryViewModel;

public class ExpenseCategoryFragment extends Fragment {

    private AppRepository repository;

    private com.example.work.models.entities.TransactionCategory transactionCategory;

    private TransactionCategoryViewModel expenseCategoryVM;

    private TransactionCategory category;

    private long categoryID;

    private LiveData<Response<com.example.work.models.entities.TransactionCategory>> transactionCategoryOperationStatus;

    private Button backButton;

    public static final String RESPONSE_MESSAGE = "response_message";

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
        backButton.setOnClickListener(v -> { Navigation.findNavController(v).navigate(R.id.ExpenseCategoriesFragment);});

        long categoryID = ExpenseCategoryFragmentArgs.fromBundle(getArguments()).getId();

        Response<TransactionCategory> response = expenseCategoryVM.getTransactionCategory(categoryID);

        if(response.getStatus() == Status.ERROR) {
            respondToCategoriesFragment("Nastala chyba");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        expenseCategoryVM = new ViewModelProvider(this, new TCViewModelFactory(repository)).get(TransactionCategoryViewModel.class);

        expenseCategoryVM.getTransactionCategoryOperationStatus().observe(getViewLifecycleOwner(), new Observer<Response<TransactionCategory>>() {
            @Override
            public void onChanged(Response<TransactionCategory> transactionCategoryResponse) {

            }
        });
    }

    public void respondToCategoriesFragment(String message) {
        Bundle result = new Bundle();
        result.putString(RESPONSE_MESSAGE, message);
        getParentFragmentManager().setFragmentResult(ExpenseCategoriesFragment.CATEGORY_REQUEST_KEY, result);
    }

    public void displayCategory(TransactionCategory category) {

    }

    public void addCategory() {
        repository.add
    }

    public void updateCategory () {

    }

    public void removeCategory() {

    }
}