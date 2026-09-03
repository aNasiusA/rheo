package dev.anasiusa;

import java.io.File;

public class BuiltinCommand {

    public static boolean isBuiltin(String commandName) {

        return commandName.equals("cd") || commandName.equals("pwd") ||
                commandName.equals("exit");

    }

    public static void execute(Command command) {

        switch (command.getName()) {
            case "exit" -> executeExit(command);
            case "pwd" -> executePWD();
            case "cd" -> executeCD(command);
            default -> throw new IllegalArgumentException("Unknown builtin: " + command.getName());
        }
    }

    public static void executeCD(Command command) {

        String path = command.getArgs().isEmpty() ? System.getProperty("user.home") : command.getArgs().get(0);

        try {

            System.setProperty("user.dir", new File(path).getCanonicalPath());

        } catch (Exception e) {

            System.out.println("rheo: cd: " + e.getMessage());

        }
    }

    public static void executePWD() {

        System.out.println(System.getProperty("user.dir"));

    }

    public static void executeExit(Command command) {

        int code = command.getArgs().isEmpty() ? 0 : Integer.parseInt(command.getArgs().get(0));
        System.exit(code);

    }
}
