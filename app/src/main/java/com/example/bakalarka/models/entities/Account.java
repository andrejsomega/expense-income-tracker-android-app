package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts",
    foreignKeys = {
        @ForeignKey(entity = Currency.class,
            parentColumns = "iso",
            childColumns = "currency_iso",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE),

        @ForeignKey(entity = AccountCategory.class,
            parentColumns = "id",
            childColumns = "category",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)
    },
    indices = {
        @Index("category"),
        @Index("currency_iso")
    }
)
public class Account {
    private static final double BALANCE_DEFAULT = 0.0;
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private long category;
    private double balance;
    @NonNull
    @ColumnInfo(name = "currency_iso")
    private String currencyISO;
    private String description;


    public Account(@NonNull String name, @NonNull long category, double balance, @NonNull String currencyISO, String description) {
        this.name = name;
        this.category = category;
        this.balance = balance;
        this.currencyISO = currencyISO;
        this.description = (description != null) ? description : "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrencyISO() {
        return currencyISO;
    }

    public void setCurrencyISO(String currencyISO) {
        this.currencyISO = currencyISO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
