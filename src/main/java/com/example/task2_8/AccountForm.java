package com.example.task2_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class AccountForm extends JFrame{
    private JTextField textFieldAmount;
    private JTextField textFieldSum;
    private JButton buttonAddSum;
    private JButton buttonReduceSum;
    private JButton buttonRedo;
    private JButton buttonUndo;
    private JPanel panelMain;
    private Account account;
    private Application app;

    public AccountForm() {
        this.setTitle("AccountFrame");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        account = new Account(1000);
        textFieldAmount.setText(String.valueOf(account.getAmount()));

        app = new Application();

        buttonAddSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.addChangeCommand(new ChangeCommand(account, Integer.parseInt(textFieldSum.getText())));
                app.changeCommand();
                update();
            }
        });
        buttonReduceSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.addChangeCommand(new ChangeCommand(account, - Integer.parseInt(textFieldSum.getText())));
                app.changeCommand();
                update();
                buttonRedo.setEnabled(false);
            }
        });
        buttonRedo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.redoCommand();
                update();
            }
        });
        buttonUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.undoCommand();
                update();
                buttonRedo.setEnabled(true);
            }
        });
    }

    void update() {
        textFieldAmount.setText(String.valueOf(account.getAmount()));
        if (app.commandRedo.empty()) {
            buttonRedo.setEnabled(false);
        }
    }


}
