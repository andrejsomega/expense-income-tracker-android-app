package com.example.bakalarka.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bakalarka.models.entities.Currency;
import com.example.bakalarka.models.entities.Transaction;
import com.example.bakalarka.models.entities.TransactionCategory;
import com.example.bakalarka.repositories.AppRepository;
import com.example.bakalarka.utils.Constants;

import java.util.List;

public class ExpenseCategoriesOverview extends ViewModel {
    private AppRepository repository;
    private final long type;
    private MutableLiveData<TransactionCategory> categoryFilter;
    private LiveData<List<TransactionCategory>> subCategories;
    private LiveData<List<Transaction>> directTransactions;

    public ExpenseCategoriesOverview(final AppRepository repository, long type) {
        this.repository = repository;
        this.type = type;
        this.categoryFilter = new MutableLiveData<>();
        this.subCategories = Transformations.switchMap(categoryFilter, value -> repository.getTransactionSubCategories(this.type, value));
        this.directTransactions = Transformations.switchMap(categoryFilter, value -> repository.getDirectTransactions(value));
    }

    public TransactionCategory getCurrentCategory() {
        return categoryFilter.getValue();
    }

    public void setCategoryFilter(TransactionCategory transactionCategory) {
        categoryFilter.setValue(transactionCategory);
    }

    public LiveData<List<TransactionCategory>> getSubCategories() {
        return subCategories;
    }
    public LiveData<List<Transaction>> getDirectTransactions() {
        return directTransactions;
    }

    //ToDo for testing remove
    public TransactionCategory getCategory(long id) {
        return repository.getCategory(id);
    }
}
