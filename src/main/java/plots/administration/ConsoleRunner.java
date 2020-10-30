package plots.administration;

import java.io.Console;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConsoleRunner {

    public Administration askForPreviousAdministration() {
        Path path = Paths.get("./output/transfers.txt");
        if (Files.exists(path)) {
            Console console = System.console();
            if (console == null) {
                throw new RuntimeException("Console not available");
            } else {
                String input = console.readLine("Continue previous session YES/NO?");
                if (input.toLowerCase() == "yes") {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
                        return (Administration) objectInputStream.readObject();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
        return null;
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

