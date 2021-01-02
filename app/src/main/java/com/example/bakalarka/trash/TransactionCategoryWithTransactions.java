package com.example.bakalarka.trash;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.bakalarka.models.entities.Transaction;
import com.example.bakalarka.models.entities.TransactionCategory;

import java.util.List;

public class TransactionCategoryWithTransactions {
    @Embedded
    public TransactionCategory category;
    @Relation(
            parentColumn = "id",
            entityColumn = "category")
    public List<Transaction> transactions;
}
