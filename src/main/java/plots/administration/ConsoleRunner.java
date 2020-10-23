package plots.administration;

import java.io.Console;

public class ConsoleRunner {

    public void openConsole () {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            String input = console.readLine("Continue previous session YES/NO?");
            if (input.toLowerCase() == "yes") {

            } else {

            }

        }

    }

}
