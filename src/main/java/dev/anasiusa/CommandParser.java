package dev.anasiusa;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    public static Command parse(String input) {

        List<String> parts = Arrays.asList(input.trim().split("\\s+"));

        String name = parts.get(0);
        List<String> args = parts.subList(1, parts.size());

        return new Command(name, args);
    }
}