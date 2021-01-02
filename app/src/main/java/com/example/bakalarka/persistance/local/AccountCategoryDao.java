package com.example.bakalarka.persistance.local;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.bakalarka.models.entities.AccountCategory;
import com.example.bakalarka.models.AccountCategoryWithAccounts;

import java.util.List;

@Dao
public abstract class AccountCategoryDao extends BaseDao<AccountCategory> {
    @Query("select * from account_categories")
    public abstract List<AccountCategory> getAccountCategories();

    // vrať list všetkých priamich podkategorií s ich učtami
    // parameter cela cesta nadkategorie s / na konci
    @Transaction
    @Query("select * from account_categories where full_path=(:parentPath || id)")
    public abstract List<AccountCategoryWithAccounts> getSubCategoriesAndAccounts(String parentPath);
}
