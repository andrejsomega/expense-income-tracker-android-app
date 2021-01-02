package com.example.bakalarka.persistance.local;

import androidx.room.Dao;

import com.example.bakalarka.models.entities.Transaction;

@Dao
public abstract class TransactionDao extends BaseDao<Transaction> {
}
