package com.example.work.trash;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;

import java.util.List;

public class TransactionCategoryWithTransactions {
    @Embedded
    public TransactionCategory category;
    @Relation(
            parentColumn = "id",
            entityColumn = "category")
    public List<Transaction> transactions;
}
