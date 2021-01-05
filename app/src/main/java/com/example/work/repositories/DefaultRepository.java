package com.example.work.repositories;

import androidx.lifecycle.LiveData;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.entities.Currency;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.persistance.local.AccountCategoryDao;
import com.example.work.persistance.local.AccountDao;
import com.example.work.persistance.local.CurrencyDao;
import com.example.work.persistance.local.TransactionCategoryDao;
import com.example.work.persistance.local.TransactionDao;
import com.example.work.persistance.local.TransactionTypeDao;
import com.example.work.persistance.local.TransferDao;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DefaultRepository implements AppRepository {
    private List<Currency> allCurrencies;
    private TransactionCategory currentCategory;
    private LiveData<List<TransactionCategory>> currentSubcategories;
    private LiveData<List<Transaction>> currentTransactions;

    private AccountDao accountDao;
    private CurrencyDao currencyDao;
    private AccountCategoryDao accountCategoryDao;
    private TransferDao transferDao;
    private TransactionTypeDao transactionTypeDao;
    private TransactionCategoryDao transactionCategoryDao;
    private TransactionDao transactionDao;
    private ExecutorService executorService;

    //ToDo: Fix attribute names

    public DefaultRepository(AccountDao accountDao, CurrencyDao currencyDao, AccountCategoryDao accountCategoryDao, TransferDao transferDao, TransactionTypeDao transactionTypeDao, TransactionCategoryDao transactionCategoryDao, TransactionDao transactionDao, ExecutorService executorService) {
        this.accountDao = accountDao;
        this.currencyDao = currencyDao;
        this.accountCategoryDao = accountCategoryDao;
        this.transferDao = transferDao;
        this.transactionTypeDao = transactionTypeDao;
        this.transactionCategoryDao = transactionCategoryDao;
        this.transactionDao = transactionDao;
        this.executorService = executorService;
    }

    @Override
    public void transferBetweenAccounts(Account from, Account to, double amount, Currency currency) {

    }

    @Override
    public void addAccountCategory(AccountCategory newAccountCategory, AccountCategory parentAccountCategory) {

    }

    @Override
    public void addAccount(Account account, AccountCategory category) {
        accountDao.insert(account);
    }

    @Override
    public void addTransactionCategory(TransactionCategory newCategory, TransactionCategory parentCategory) {
        newCategory.setFullPath(parentCategory.getFullPath());
        transactionCategoryDao.addSubCategory(newCategory);
    }

    @Override
    public void addTransaction(Transaction transaction, TransactionCategory category) {
        transactionDao.insert(transaction);
    }

    @Override
    public void update(Currency currency) {
        currencyDao.update(currency);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void update(AccountCategory accountCategory) {
        accountCategoryDao.update(accountCategory);
    }

    @Override
    public void update(Transaction transaction) {
        transactionDao.update(transaction);
    }

    @Override
    public void update(TransactionCategory transactionCategory) {
        transactionCategoryDao.update(transactionCategory);
    }

    @Override
    public void remove(Account account) {
        accountDao.delete(account);
    }

    @Override
    public void remove(AccountCategory accountCategory) {
        accountCategoryDao.delete(accountCategory);
    }

    @Override
    public void remove(Transaction transaction) {
        transactionDao.delete(transaction);
    }

    @Override
    public void remove(TransactionCategory transactionCategory) {
        transactionCategoryDao.delete(transactionCategory);
    }

    @Override
    public TransactionCategory getCategory(long id) {
        // do in background thread
        // inner local class
        class MyCallable implements Callable<TransactionCategory> {
            private long id;
            public MyCallable(long id) {
                this.id = id;
            }

            @Override
            public TransactionCategory call() throws Exception {
                return transactionCategoryDao.getTransactionCategory(id);
            }
        }

        Future<TransactionCategory> result = executorService.submit(new MyCallable(id));
        try {
            currentCategory = result.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return currentCategory;
    }

    @Override
    public void setCurrentCategory(TransactionCategory transactionCategory) {
        currentCategory = transactionCategory;
    }

    @Override
    public TransactionCategory getCurrentCategory() {
        return currentCategory;
    }

    @Override
    public LiveData<List<TransactionCategory>> getTransactionSubCategories(long transactionType, TransactionCategory transactionCategory) {
        String path = transactionCategory != null ? transactionCategory.getFullPath() + "/" : "/";
        currentSubcategories = transactionCategoryDao.getTransactionSubCategories(transactionType, path);
        return currentSubcategories;
    }

    @Override
    public LiveData<List<Transaction>> getDirectTransactions(TransactionCategory transactionCategory) {
        if(transactionCategory != null) {
            currentTransactions = transactionCategoryDao.getDirectTransactions(transactionCategory.getId());
        } else {
            currentTransactions = null;
        }
        return currentTransactions;
    }

    public LiveData<List<Currency>> getAllCurrencies() {
        return currencyDao.getCurrencies();
    }
}

