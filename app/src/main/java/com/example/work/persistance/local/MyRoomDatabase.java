package com.example.work.persistance.local;

import androidx.room.Database;
import androidx.room.TypeConverters;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.Converters;
import com.example.work.models.entities.Currency;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.models.entities.TransactionType;
import com.example.work.models.entities.Transfer;

@Database(entities = {Account.class, Currency.class, AccountCategory.class, Transfer.class, Transaction.class, TransactionCategory.class, TransactionType.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MyRoomDatabase extends androidx.room.RoomDatabase {
    public abstract CurrencyDao currencyDao();
    public abstract AccountDao accountDao();
    public abstract AccountCategoryDao accountCategoryDao();
    public abstract TransferDao transferDao();
    public abstract TransactionDao transactionDao();
    public abstract TransactionCategoryDao transactionCategoryDao();
    public abstract TransactionTypeDao transactionTypeDao();
}
