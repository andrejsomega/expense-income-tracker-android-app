package com.example.work.persistance.local;

import androidx.room.Dao;

import com.example.work.models.entities.Transaction;

@Dao
public abstract class TransactionDao extends BaseDao<Transaction> {
}
