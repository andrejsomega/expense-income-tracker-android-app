package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "transactions",
    foreignKeys = {
        @ForeignKey(entity = TransactionCategory.class,
                parentColumns = "id",
                childColumns = "category",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),

        @ForeignKey(entity = Account.class,
                parentColumns = "id",
                childColumns = "account",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Currency.class,
                parentColumns = "iso",
                childColumns = "currency_iso",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
    },
    indices = {
        @Index("category"),
        @Index("account"),
        @Index("currency_iso")
    }
)
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private long category;
    @NonNull
    private long account;
    @NonNull
    private double amount;
    @NonNull
    @ColumnInfo(name = "currency_iso")
    private String currency;
    @NonNull
    private Date date;
    private String note;

    public Transaction(long category, String name, long account, double amount, @NonNull String currency, @NonNull Date date, String note) {
        this.name = name;
        this.category = category;
        this.account = account;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.note = note != null ? note : "";
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

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NonNull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(@NonNull String currency) {
        this.currency = currency;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
