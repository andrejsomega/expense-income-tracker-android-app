package com.example.work.persistance.local;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.entities.Currency;
import com.example.work.models.AccountCategoryWithAccounts;

import static com.google.common.truth.Truth.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccountCategoryDaoTest {

    private MyRoomDatabase db;
    private CurrencyDao currencyDao;
    private AccountDao accountDao;
    private AccountCategoryDao accountCategoryDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MyRoomDatabase.class).build();
        currencyDao = db.currencyDao();
        accountDao = db.accountDao();
        accountCategoryDao = db.accountCategoryDao();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void getCategoryAndAccounts() {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        Account a1 = new Account("Account 1", 1, 0, "EUR", null);
        Account a2 = new Account("Account 2", 1, 0, "EUR", null);
        Account a3 = new Account("Account 3", 2, 0, "EUR", null);
        Account a4 = new Account("Account 3", 3, 0, "EUR", null);
        AccountCategory ac1 = new AccountCategory("Category 1", "1", null);
        AccountCategory ac2 = new AccountCategory("Category 2", "2", null);
        AccountCategory ac3 = new AccountCategory("Category 2", "1.3", null);
        currencyDao.insert(c1);
        accountCategoryDao.insert(ac1);
        accountCategoryDao.insert(ac2);
        accountCategoryDao.insert(ac3);
        List<AccountCategory> accountCategories = accountCategoryDao.getAccountCategories();
        accountDao.insert(a1);
        accountDao.insert(a2);
        accountDao.insert(a3);
        accountDao.insert(a4);
        List<AccountCategoryWithAccounts> categoriesWithAccounts = accountCategoryDao.getSubCategoriesAndAccounts("");
        List<AccountCategoryWithAccounts> categoriesWithAccounts2 = accountCategoryDao.getSubCategoriesAndAccounts("1.");
        assertThat(categoriesWithAccounts.size() == 2 && categoriesWithAccounts2.size() == 1).isTrue();
    }
}