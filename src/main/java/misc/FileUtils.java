package misc;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static void deleteStructure(Path sourcePath) throws IOException {
        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>(){
            @Override
            // After directory is visited and files deleted delete empty directory
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                // System.out.println("Deleting Directory- " + dir.toString());
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
            @Override
            // Delete each visited file
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException{
                // System.out.println("Deleting file- " + file.getFileName());
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
