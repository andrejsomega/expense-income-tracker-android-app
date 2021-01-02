package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_categories")
public class AccountCategory {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    @ColumnInfo(name = "full_path")
    private String fullPath;
    private String description;

    public AccountCategory(@NonNull String name, @NonNull String fullPath, String description) {
        this.name = name;
        this.fullPath = fullPath;
        this.description = (description != null) ? description : "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(@NonNull String fullPath) {
        this.fullPath = fullPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
