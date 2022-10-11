package com.example.task2_8;

public class ChangeCommand implements Command{
    Account account;
    int n;

    public ChangeCommand(Account account, int n) {
        this.account = account;
        this.n = n;
    }

    @Override
    public void execute() {
        account.change(n);
    }

    public void undo() {
        account.undo(n);
    }

    public void redo() {
        account.redo(n);
    }
}
