package com.treeaxes.CLI;

public class ClearTerminal {

    public ClearTerminal() {
    }

    public void clear() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
