package dev.anasiusa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public static void execute(Command command) {
        try {
            List<String> commandParts = new ArrayList<>();

            commandParts.add(command.getName());

            for (String arg : command.getArgs()) {
                commandParts.add(arg);
            }

            ProcessBuilder processBuilder = new ProcessBuilder(commandParts);

            processBuilder.inheritIO();

            Process process = processBuilder.start();

            process.waitFor();

        } catch (IOException e) {

            System.out.println("rheo: command not found: " + command.getName());

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }
    }

}
