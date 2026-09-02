package dev.anasiusa;

public class Shell {
    public static void main(String[] args) {
        while (true) {
            String input = CommandUtils.getCommand();

            if (CommandUtils.isExitCommand(input)) {

                break;

            }

            Command command = CommandParser.parse(input);

            CommandExecutor.execute(command);
        }
    }
}