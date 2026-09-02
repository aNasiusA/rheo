package dev.anasiusa;

import java.util.ArrayList;
import java.util.List;

public class Command {

    private final String name;
    private final String[] args;

    public Command(String name, String[] args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public String[] getArgs() {
        return args;
    }

    public List<String> toList() {

        List<String> commandparts = new ArrayList<>();

        commandparts.add(name);

        for (String arg : args) {
            commandparts.add(arg);
        }

        return commandparts;
    }
}
