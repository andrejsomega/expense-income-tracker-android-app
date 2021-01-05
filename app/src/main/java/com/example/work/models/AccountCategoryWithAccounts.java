package com.example.work.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;

import java.util.List;

public class AccountCategoryWithAccounts {
    @Embedded
    public AccountCategory category;

    @Relation(
            parentColumn = "id",
            entityColumn = "category")
    public List<Account> accounts;
}
