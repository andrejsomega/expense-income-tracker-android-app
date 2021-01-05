package com.example.work.persistance.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

@Dao
public abstract class BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insert(T entity);

    @Update
    public abstract void update(T entity);

    @Delete
    public abstract void delete(T entity);
}
