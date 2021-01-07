package com.example.work.persistance.local;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.work.LiveDataTestUtil;
import com.example.work.models.entities.Currency;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;


@RunWith(AndroidJUnit4.class)
public class BaseDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MyRoomDatabase db;
    private CurrencyDao currencyDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MyRoomDatabase.class).allowMainThreadQueries().build();
        currencyDao = db.currencyDao();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void insertToEmptyTable_true() throws InterruptedException {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        currencyDao.insert(c1);
        List<Currency> allCurrencies = LiveDataTestUtil.getValue(currencyDao.getCurrencies());
        assertThat(allCurrencies.size() == 1).isTrue();
    }

    @Test
    public void updateExistingItem_true() throws InterruptedException {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        currencyDao.insert(c1);
        c1.setExchangeRateFromEuro(2);
        currencyDao.update(c1);
        Currency c2 = LiveDataTestUtil.getValue(currencyDao.getCurrencies()).get(0);
        assertThat(c2.getExchangeRateFromEuro() == 2).isTrue();
    }

    @Test
    public void updateNonExistingItem_true() throws InterruptedException {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        Currency c2 = new Currency("DOL", "dol", '$', 2);

        currencyDao.insert(c1);
        currencyDao.update(c2);
        assertThat(LiveDataTestUtil.getValue(currencyDao.getCurrencies()).size() == 1).isTrue();
    }

    @Test
    public void deleteExistingItem_true() throws InterruptedException {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        currencyDao.insert(c1);
        currencyDao.delete(c1);
        assertThat(LiveDataTestUtil.getValue(currencyDao.getCurrencies()).size() == 0).isTrue();
    }

    @Test
    public void deleteNonExistingItem_true() throws InterruptedException {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        Currency c2 = new Currency("DOL", "dol", '$', 2);
        currencyDao.insert(c1);
        currencyDao.delete(c2);
        assertThat(LiveDataTestUtil.getValue(currencyDao.getCurrencies()).size() == 1).isTrue();
    }
}
