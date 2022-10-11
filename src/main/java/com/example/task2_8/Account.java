package com.example.task2_8;

public class Account {
     public int amount = 0;

     public Account(int amount) {
          this.amount = amount;
     }

     public int getAmount() {
          return amount;
     }

     public void setAmount(int amount) {
          this.amount = amount;
     }

     public void change(int transaction) {
          this.amount = amount + transaction;
     }

     public void undo(int transaction) {
          this.amount = amount - transaction;
     }

     public void redo(int transaction) {
          this.amount = amount + transaction;
     }
}
