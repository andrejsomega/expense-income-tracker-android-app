package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "transfers",
    foreignKeys = {
        @ForeignKey(entity = Currency.class,
            parentColumns = "iso",
            childColumns = "currency_iso",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Account.class,
            parentColumns = "id",
            childColumns = "account_from",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE),

        @ForeignKey(entity = Account.class,
            parentColumns = "id",
            childColumns = "account_to",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)
    },
    indices = {
        @Index("currency_iso"),
        @Index("account_from"),
        @Index("account_to")
    }
)
public class Transfer {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @NonNull
    private double amount;
    @NonNull
    private Date date;
    @NonNull
    @ColumnInfo(name = "currency_iso")
    private String currencyISO;
    @NonNull
    @ColumnInfo(name = "account_from")
    private long accountFrom;
    @NonNull
    @ColumnInfo(name = "account_to")
    private long accountTo;

    public Transfer(double amount, @NonNull Date date, @NonNull String currencyISO, long accountFrom, long accountTo) {
        this.amount = amount;
        this.date = date;
        this.currencyISO = currencyISO;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getCurrencyISO() {
        return currencyISO;
    }

    public void setCurrencyISO(@NonNull String currencyISO) {
        this.currencyISO = currencyISO;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }
}
