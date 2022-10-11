package com.example.task2_8;

import java.util.Stack;

public class Application {
    Stack<ChangeCommand> commandHistory = new Stack<>();
    Stack<ChangeCommand> commandRedo = new Stack<>();

    void addChangeCommand(ChangeCommand command) {
        commandHistory.add(command);
    }

    void changeCommand() {
        commandHistory.peek().execute();
        commandRedo = new Stack<>();
    }

    void undoCommand() {
        commandHistory.peek().undo();
        commandRedo.add(commandHistory.pop());
    }

    void redoCommand() {
        commandRedo.pop().redo();
    }

}
