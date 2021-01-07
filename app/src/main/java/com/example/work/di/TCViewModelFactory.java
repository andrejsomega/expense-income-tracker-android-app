package com.example.work.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.work.repositories.AppRepository;
import com.example.work.viewmodels.TransactionCategoryContentViewModel;
import com.example.work.viewmodels.TransactionCategoryViewModel;

public class TCViewModelFactory implements ViewModelProvider.Factory {

    private final AppRepository repository;

    public TCViewModelFactory(AppRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TransactionCategoryViewModel.class) {
            return (T) new TransactionCategoryViewModel(repository);
        }
        return null;
    }
}
