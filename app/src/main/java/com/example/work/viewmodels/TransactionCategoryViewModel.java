package com.example.work.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.repositories.AppRepository;
import com.example.work.utils.Response;

import java.util.concurrent.ExecutionException;


public class TransactionCategoryViewModel extends ViewModel {
    private AppRepository repository;
    private MutableLiveData<Response<com.example.work.models.entities.TransactionCategory>> _transactionCategoryOperationStatus;
    private LiveData<Response<com.example.work.models.entities.TransactionCategory>> transactionCategoryOperationStatus;

    public TransactionCategoryViewModel(final AppRepository repository) {
        this.repository = repository;
    }

    public Response<TransactionCategory> addTransactionCategory() {
        return null;
    }

    public Response<TransactionCategory> updateTransactionCategory() {
        return null;
    }

    public Response<TransactionCategory> removeTransactionCategory() {
        return null;
    }


    public Response<TransactionCategory> getTransactionCategory(long id) {
        TransactionCategory result = null;
        Response<TransactionCategory> response;

        try {
            result = repository.getTransactionCategory(id);
        } catch (Exception e) {
            return Response.error(result, "Nepodarilo sa najst kategoriu!");
        }
        return Response.success(result);
    }

    public LiveData<Response<com.example.work.models.entities.TransactionCategory>> getTransactionCategoryOperationStatus() {
        return this.transactionCategoryOperationStatus;
    }
}
