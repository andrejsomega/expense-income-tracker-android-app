package com.example.work.persistance.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.work.models.entities.Currency;

import java.util.List;

@Dao
public abstract class CurrencyDao extends BaseDao<Currency> {
    @Query("Select * from currencies")
    public abstract LiveData<List<Currency>> getCurrencies();
}
