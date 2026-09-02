package dev.anasiusa;

public class Shell {
    public static void main(String[] args) {
        while (true) {
            String command = CommandUtils.getCommand();

            if (CommandUtils.isExitCommand(command)) {
                break;
            }

            String[] parts = CommandUtils.parseCommand(command);

            System.out.println("Command: " + parts[0]);
        }
    }
}