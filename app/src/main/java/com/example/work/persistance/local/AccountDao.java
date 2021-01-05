package com.example.work.persistance.local;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.work.models.entities.Account;

import java.util.List;

@Dao
public abstract class AccountDao extends BaseDao<Account> {
    @Query("Select * from accounts")
    public abstract List<Account> getAccounts();
}
