package dev.anasiusa;

import java.util.Scanner;

public class CommandUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCommand() {
        System.out.print("rheo> ");
        return scanner.nextLine();
    }

    public static boolean isExitCommand(String command) {
        return command.trim().equals("exit");
    }
}
