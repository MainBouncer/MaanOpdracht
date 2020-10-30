package misc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static void deleteStructure(Path sourcePath) throws IOException {
        Files.walkFileTree(sourcePath, new SimpleFileVisitor<>() {
            @Override
            // After directory is visited and files deleted delete empty directory
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                // System.out.println("Deleting Directory- " + dir.toString());
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            // Delete each visited file
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // System.out.println("Deleting file- " + file.getFileName());
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void writeObjectToFile(Object serObj, String filepath) {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath))) {
            objectOut.writeObject(serObj);
            System.out.println("The Object  was successfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
