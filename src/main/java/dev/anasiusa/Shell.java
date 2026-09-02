package dev.anasiusa;

public class Shell {
    public static void main(String[] args) {
        while (true) {

            String input = CommandUtils.getCommand();

            Command command = CommandParser.parse(input);

            if (BuiltinCommand.isBuiltin(command.getName())) {

                BuiltinCommand.execute(command);

            } else {

                CommandExecutor.execute(command);

            }
        }
    }
}