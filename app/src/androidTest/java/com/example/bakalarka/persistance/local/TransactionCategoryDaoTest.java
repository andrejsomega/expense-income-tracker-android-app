package com.example.bakalarka.persistance.local;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.bakalarka.models.entities.Transaction;
import com.example.bakalarka.models.entities.TransactionCategory;
import com.example.bakalarka.LiveDataTestUtil;
import com.example.bakalarka.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
@RunWith(AndroidJUnit4.class)
public class TransactionCategoryDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MyRoomDatabase db;
    private CurrencyDao currencyDao;
    private AccountDao accountDao;
    private AccountCategoryDao accountCategoryDao;
    private TransactionTypeDao transactionTypeDao;
    private TransactionCategoryDao transactionCategoryDao;
    private TransactionDao transactionDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MyRoomDatabase.class).allowMainThreadQueries().build();
        currencyDao = db.currencyDao();
        accountDao = db.accountDao();
        accountCategoryDao = db.accountCategoryDao();
        transactionTypeDao = db.transactionTypeDao();
        transactionCategoryDao = db.transactionCategoryDao();
        transactionDao = db.transactionDao();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void getSubCategoriesAndAccounts() throws InterruptedException {
        currencyDao.insert(TestData.currency1);
        accountCategoryDao.insert(TestData.accountCategory1);
        accountDao.insert(TestData.account1);
        transactionTypeDao.insert(TestData.transactionType1);
        transactionCategoryDao.addSubCategory(TestData.transactionCategory1);
        transactionCategoryDao.addSubCategory(TestData.transactionCategory2);
        transactionCategoryDao.addSubCategory(TestData.transactionCategory3);
        transactionDao.insert(TestData.transaction1);

        TransactionCategory category = transactionCategoryDao.getTransactionCategory(10);

        List<Transaction> transactions = LiveDataTestUtil.getValue(transactionCategoryDao.getDirectTransactions(TestData.transactionCategory2.getId()));
        List<TransactionCategory> subCategories = LiveDataTestUtil.getValue(transactionCategoryDao.getTransactionSubCategories(Constants.EXPENSE_ID, TestData.transactionCategory2.getFullPath() + "/"));

        assertThat(transactions.get(0).getName() == TestData.transaction1.getName() && subCategories.get(0).getName() == TestData.transactionCategory3.getName()).isTrue();
    }
}