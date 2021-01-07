package com.example.work.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.work.repositories.AppRepository;
import com.example.work.viewmodels.TransactionCategoryContentViewModel;

public class TCContentViewModelFactory implements ViewModelProvider.Factory {

    private final AppRepository repository;
    private final long type;

    public TCContentViewModelFactory(AppRepository repository, long type) {
        this.repository = repository;
        this.type = type;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TransactionCategoryContentViewModel.class) {
            return (T) new TransactionCategoryContentViewModel(repository, type);
        }
        return null;
    }
}
