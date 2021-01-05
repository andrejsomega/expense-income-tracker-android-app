package com.example.work.di;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.entities.Currency;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.models.entities.TransactionType;
import com.example.work.persistance.local.AccountCategoryDao;
import com.example.work.persistance.local.AccountDao;
import com.example.work.persistance.local.CurrencyDao;
import com.example.work.persistance.local.MyRoomDatabase;
import com.example.work.persistance.local.TransactionCategoryDao;
import com.example.work.persistance.local.TransactionDao;
import com.example.work.persistance.local.TransactionTypeDao;
import com.example.work.persistance.local.TransferDao;
import com.example.work.repositories.DefaultRepository;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppContainer {


    private MyRoomDatabase database;
    public AccountDao accountDao;
    public CurrencyDao currencyDao;
    public AccountCategoryDao accountCategoryDao;
    public TransferDao transferDao;
    public TransactionTypeDao transactionTypeDao;
    public TransactionCategoryDao transactionCategoryDao;
    public TransactionDao transactionDao;

    public ExecutorService executorService;
    public DefaultRepository repository;



    public AppContainer(Context context) {
        database = Room.databaseBuilder(context, MyRoomDatabase.class, "DB_NAME")
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                prepopulateDatabase();
                            }
                        });
                    }
                })
                .fallbackToDestructiveMigration()
                .build();

        accountDao = database.accountDao();
        currencyDao = database.currencyDao();
        accountCategoryDao = database.accountCategoryDao();
        transferDao = database.transferDao();
        transactionTypeDao = database.transactionTypeDao();
        transactionCategoryDao = database.transactionCategoryDao();
        transactionDao = database.transactionDao();
        executorService = Executors.newFixedThreadPool(4);
        repository = new DefaultRepository(accountDao, currencyDao, accountCategoryDao, transferDao, transactionTypeDao, transactionCategoryDao, transactionDao, executorService);
    }

    private void prepopulateDatabase() {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        Currency c2 = new Currency("DOL", "dolár", '$', 1.18);

        currencyDao.insert(c1);
        currencyDao.insert(c2);

        AccountCategory ac1 = new AccountCategory("Osobné účty", "", "");
        AccountCategory ac2 = new AccountCategory("Pracovné účty", "", "");

        accountCategoryDao.insert(ac1);
        accountCategoryDao.insert(ac2);

        Account account1 = new Account("Account 1", 1, 50, "EUR", null);
        accountDao.insert(account1);

        TransactionType tt1 = new TransactionType(1,"výdaj");
        TransactionType tt2 = new TransactionType(2,"príjem");

        transactionTypeDao.insert(tt1);
        transactionTypeDao.insert(tt2);

        TransactionCategory tc1 = new TransactionCategory("Strava", 1, "", "", null);
        TransactionCategory tc2 = new TransactionCategory("Oblečenie", 1,"", "", null);
        TransactionCategory tc3 = new TransactionCategory("Zábava", 1,"", "", null);

        transactionCategoryDao.addSubCategory(tc1);
        transactionCategoryDao.addSubCategory(tc2);
        transactionCategoryDao.addSubCategory(tc3);

        TransactionCategory transactionCategory3 = new TransactionCategory("Kino", 1,"/3", "", null);
        transactionCategoryDao.addSubCategory(transactionCategory3);
        Transaction transaction1 = new Transaction( 3,"Pivko", 1, 50, "EUR", new Date(), null);
        transactionDao.insert(transaction1);
    }
}
