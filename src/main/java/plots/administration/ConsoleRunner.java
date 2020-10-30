package plots.administration;

import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConsoleRunner {

    public boolean askForPreviousAdministration() {
        Path path = Paths.get("./output/transfers.txt");
        if (Files.exists(path)) {
            Console console = System.console();
            if (console == null) {
                throw new RuntimeException("Console not available");
            } else {
                String input = console.readLine("Continue previous session YES/NO?");
                return "yes".equals(input.toLowerCase());
            }
        }
        return false;
    }
}

//Case
//
//        Write the transport information to a file, so who or what moved from where to where and when
//
//        Have another method read this file and monitor this output for any products that should have a
//        license but didn’t have (a valid) one. Write these to a separate file so the moon police knows what
//        illegal transportations took place
//
//        Make your moon administration serializable
//
//        Ask the user for input on this administration
//
//        Upon ending the console app, write it to a file
//
//        Open it when the user later wants to continue a previous session
