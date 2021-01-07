package com.example.work.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.repositories.AppRepository;

import java.util.List;

public class TransactionCategoryContentViewModel extends ViewModel {
    private AppRepository repository;
    private final long type;
    private MutableLiveData<TransactionCategory> currentCategoryFilter;
    private LiveData<List<TransactionCategory>> directSubCategories;
    private LiveData<List<Transaction>> directTransactions;

    public TransactionCategoryContentViewModel(final AppRepository repository, long type) {
        this.repository = repository;
        this.type = type;
        this.currentCategoryFilter = new MutableLiveData<>();
        this.directSubCategories = Transformations.switchMap(currentCategoryFilter, value -> repository.getTransactionSubCategories(this.type, value));
        this.directTransactions = Transformations.switchMap(currentCategoryFilter, value -> repository.getDirectTransactions(value));
    }

    public TransactionCategory getCurrentCategory() {
        return currentCategoryFilter.getValue();
    }

    public void setCurrentCategoryFilter(TransactionCategory transactionCategory) {
        currentCategoryFilter.setValue(transactionCategory);
    }

    public LiveData<List<TransactionCategory>> getDirectSubCategories() {
        return directSubCategories;
    }

    public LiveData<List<Transaction>> getDirectTransactions() {
        return directTransactions;
    }
}
