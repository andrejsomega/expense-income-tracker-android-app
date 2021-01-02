package com.example.bakalarka.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "currencies")
public class Currency {
    @PrimaryKey
    @NonNull
    private String iso;
    @NonNull
    private String name;
    @NonNull
    private char symbol;
    @NonNull
    @ColumnInfo(name = "exchange_rate_from_euro")
    private double exchangeRateFromEuro;

    public Currency(@NonNull String iso, @NonNull String name, @NonNull char symbol, @NonNull double exchangeRateFromEuro) {
        this.iso = iso;
        this.name = name;
        this.symbol = symbol;
        this.exchangeRateFromEuro = exchangeRateFromEuro;
    }

    @NonNull
    public String getIso() {
        return iso;
    }

    public void setIso(@NonNull String iso) {
        this.iso = iso;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double getExchangeRateFromEuro() {
        return exchangeRateFromEuro;
    }

    public void setExchangeRateFromEuro(double exchangeRateFromEuro) {
        this.exchangeRateFromEuro = exchangeRateFromEuro;
    }
}
