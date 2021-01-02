package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction_categories")
public class TransactionCategory {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    @ColumnInfo(index = true)
    private long type;
    @NonNull
    @ColumnInfo(name = "full_path")
    private String fullPath;
    @NonNull
    @ColumnInfo(name = "icon_url")
    private String iconUrl;
    private String description;

    public TransactionCategory(@NonNull String name, @NonNull long type, @NonNull String fullPath, @NonNull String iconUrl, String description) {
        this.name = name;
        this.type = type;
        this.fullPath = fullPath;
        this.iconUrl = iconUrl;
        this.description = description;
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

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @NonNull
    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(@NonNull String fullPath) {
        this.fullPath = fullPath;
    }

    @NonNull
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(@NonNull String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
