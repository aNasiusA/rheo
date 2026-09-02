package dev.anasiusa;

public class BuiltinCommand {

    public static boolean isBuiltin(String commandName) {

        return commandName.equals("cd") || commandName.equals("pwd") ||
                commandName.equals("exit");

    }

    public static void execute(Command command) {

        switch (command.getName()) {
            case "exit" -> executeExit(command);
            case "pwd" -> executePWD();
            default -> throw new IllegalArgumentException("Unknown builtin: " + command.getName());
        }
    }

    public static void executePWD() {
        System.out.println(System.getProperty("user.dir"));
    }

    public static void executeExit(Command command) {

        int code = command.getArgs().length == 0 ? 0 : Integer.parseInt(command.getArgs()[0]);
        System.exit(code);

    }
}
