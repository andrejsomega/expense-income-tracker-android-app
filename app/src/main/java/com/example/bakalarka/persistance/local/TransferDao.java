package com.example.bakalarka.persistance.local;

import androidx.room.Dao;

import com.example.bakalarka.models.entities.Transfer;

@Dao
public abstract class TransferDao extends BaseDao<Transfer> {
    // Premiestni ciastku z jedneho uctu do druheho a zaznamena do tabulky
    //public void transferMoneyBetweenAccounts(long accountFrom, long accountTo, double amount, String currencyISO)
}
