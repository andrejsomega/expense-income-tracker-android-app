package com.example.work.repositories;


import androidx.lifecycle.LiveData;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.entities.Currency;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;

import java.util.List;

public interface AppRepository {
    void transferBetweenAccounts(Account from, Account to, double amount, Currency currency);
    void addAccount(Account account, AccountCategory category);
    void addAccountCategory(AccountCategory newAccountCategory, AccountCategory parentAccountCategory);
    void addTransaction(Transaction transaction, TransactionCategory category);
    void addTransactionCategory(TransactionCategory newCategory, TransactionCategory parentCategory);

    void update(Currency currency);
    void update(Account account);
    void update(AccountCategory accountCategory);
    void update(Transaction transaction);
    void update(TransactionCategory transactionCategory);

    void remove(Account account);
    void remove(AccountCategory accountCategory);
    void remove(Transaction transaction);
    void remove(TransactionCategory transactionCategory);

    TransactionCategory getCategory(long id);
    void setCurrentCategory(TransactionCategory transactionCategory);
    TransactionCategory getCurrentCategory();

    LiveData<List<TransactionCategory>> getTransactionSubCategories(long transactionType, TransactionCategory transactionCategory);
    LiveData<List<Transaction>> getDirectTransactions(TransactionCategory transactionCategory);
    LiveData<List<Currency>> getAllCurrencies();
}
