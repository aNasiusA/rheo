package dev.anasiusa;

public class Shell {
    public static void main(String[] args) {

        String command = CommandUtils.getCommand();
        System.out.println(command);
    }
}