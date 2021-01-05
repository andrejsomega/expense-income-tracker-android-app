package com.example.work.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.work.repositories.AppRepository;
import com.example.work.viewmodels.ExpenseCategoriesOverview;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final AppRepository repository;
    private final long type;

    public MyViewModelFactory(AppRepository repository, long type) {
        this.repository = repository;
        this.type = type;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ExpenseCategoriesOverview.class) {
            return (T) new ExpenseCategoriesOverview(repository, type);
        }
        return null;
    }
}
