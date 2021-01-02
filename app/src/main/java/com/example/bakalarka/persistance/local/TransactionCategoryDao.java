package com.example.bakalarka.persistance.local;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bakalarka.models.entities.TransactionCategory;

import java.util.List;

@Dao
public abstract class TransactionCategoryDao extends BaseDao<TransactionCategory> {
    @Query("update transaction_categories set full_path=:path where id=:ID")
    public abstract void updateFullPath(String path, long ID);

    @Transaction
    public void addSubCategory(TransactionCategory newCategory) {
        long id = insert(newCategory);
        String fullPath = newCategory.getFullPath() + "/" + id;
        updateFullPath(fullPath, id);
    }

    @Query("select * from transaction_categories where id=:id")
    public abstract TransactionCategory getTransactionCategory(long id);

    @Query("select * from transaction_categories where type=(:transactionType) and full_path=(:path || id)")
    public abstract LiveData<List<TransactionCategory>> getTransactionSubCategories(long transactionType, String path);

    @Query("select * from transactions where category=:category")
    public abstract LiveData<List<com.example.bakalarka.models.entities.Transaction>> getDirectTransactions(long category);
}
