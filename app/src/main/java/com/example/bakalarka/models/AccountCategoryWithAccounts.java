package com.example.bakalarka.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.bakalarka.models.entities.Account;
import com.example.bakalarka.models.entities.AccountCategory;

import java.util.List;

public class AccountCategoryWithAccounts {
    @Embedded
    public AccountCategory category;

    @Relation(
            parentColumn = "id",
            entityColumn = "category")
    public List<Account> accounts;
}
