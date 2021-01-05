package com.example.work.trash;

import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;

import java.util.List;

public class TransactionCategorySubCategoriesAndTransactions {
    public TransactionCategory category;
    public List<TransactionCategory> categories;
    public List<Transaction> transactions;

    public TransactionCategorySubCategoriesAndTransactions(TransactionCategory category, List<TransactionCategory> categories, List<Transaction> transactions) {
        this.category = category;
        this.categories = categories;
        this.transactions = transactions;
    }
}
