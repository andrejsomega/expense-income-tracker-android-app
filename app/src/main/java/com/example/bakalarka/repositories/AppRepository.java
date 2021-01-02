package com.example.bakalarka.repositories;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bakalarka.models.entities.Account;
import com.example.bakalarka.models.entities.AccountCategory;
import com.example.bakalarka.models.entities.Currency;
import com.example.bakalarka.models.entities.Transaction;
import com.example.bakalarka.models.entities.TransactionCategory;

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
