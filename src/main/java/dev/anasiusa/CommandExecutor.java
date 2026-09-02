package dev.anasiusa;

import java.io.IOException;

public class CommandExecutor {

    public static void execute(Command command) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder(command.toList());

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
