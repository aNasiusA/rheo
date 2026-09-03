package dev.anasiusa;

import java.util.ArrayList;
import java.util.List;

public class Command {

    private final String name;
    private final List<String> args;

    public Command(String name, List<String> args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public List<String> getArgs() {
        return args;
    }

    public List<String> toList() {

        List<String> commandparts = new ArrayList<>();

        commandparts.add(name);

        commandparts.addAll(args);

        return commandparts;
    }
}
