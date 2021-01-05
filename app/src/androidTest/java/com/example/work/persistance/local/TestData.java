package com.example.work.persistance.local;

import com.example.work.models.entities.Account;
import com.example.work.models.entities.AccountCategory;
import com.example.work.models.entities.Currency;
import com.example.work.models.entities.Transaction;
import com.example.work.models.entities.TransactionCategory;
import com.example.work.models.entities.TransactionType;

import java.util.Date;

public class TestData {
    static Currency currency1 = new Currency("EUR", "euro", '€', 1);

    static Account account1 = new Account("Account 1", 1, 0, "EUR", null);
    static AccountCategory accountCategory1 = new AccountCategory("Category 1", "1", null);

    static TransactionType transactionType1 = new TransactionType(1,"príjem");

    static TransactionCategory transactionCategory1 = new TransactionCategory("Výplata", 1,"", "", null);
    static TransactionCategory transactionCategory2 = new TransactionCategory("Výplata2", 1,"", "", null);
    static TransactionCategory transactionCategory3 = new TransactionCategory("Výplata11", 1,"/2", "", null);

    static Transaction transaction1 = new Transaction( 2,"Tranzakcia", 1, 50, "EUR", new Date(), null);
}
