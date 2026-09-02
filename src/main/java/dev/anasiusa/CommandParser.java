package dev.anasiusa;

public class CommandParser {

    public static Command parse(String input) {

        String[] parts = input.trim().split("\\s+");

        String name = parts[0];

        String[] args = new String[parts.length - 1];

        System.arraycopy(parts, 1, args, 0, args.length);

        return new Command(name, args);
    }
}
