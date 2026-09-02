package dev.anasiusa;

import java.util.Scanner;

public class CommandUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCommand() {
        String currentPath = System.getProperty("user.dir");
        System.out.print("rheo " + currentPath + "> ");
        return scanner.nextLine();
    }

    public static boolean isExitCommand(String command) {
        return command.trim().equals("exit");
    }
}
