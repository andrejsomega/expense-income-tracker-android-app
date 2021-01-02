package com.example.bakalarka.persistance.local;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bakalarka.models.entities.Currency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;


@RunWith(AndroidJUnit4.class)
public class BaseDaoTest {

    private MyRoomDatabase db;
    private CurrencyDao currencyDao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MyRoomDatabase.class).build();
        currencyDao = db.currencyDao();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void insert_true() {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        String iso = c1.getIso();
        currencyDao.insert(c1);
        List<Currency> allCurrencies = currencyDao.getCurrencies().getValue();
        assertThat(allCurrencies.size() == 2).isFalse();
    }

    @Test
    public void update_true() {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        String iso = c1.getIso();
        currencyDao.insert(c1);
        c1.setExchangeRateFromEuro(2);
        currencyDao.update(c1);
        Currency c2 = currencyDao.getCurrencies().getValue().get(0);
        assertThat(currencyDao.getCurrencies().getValue().size() == 1 && c2.getExchangeRateFromEuro() == 2).isTrue();
    }

    @Test
    public void delete_true() {
        Currency c1 = new Currency("EUR", "euro", '€', 1);
        currencyDao.insert(c1);
        currencyDao.delete(c1);
        assertThat(currencyDao.getCurrencies().getValue().size() == 0).isTrue();
    }
}
