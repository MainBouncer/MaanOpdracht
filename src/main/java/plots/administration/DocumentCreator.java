package plots.administration;

import plots.model.Owner;
import plots.model.Transfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DocumentCreator {

    public DocumentCreator(List<Transfer> transfers) {
        transfers.forEach(transfer -> {
            Owner owner = transfer.getNewOwner();
            Path ownerPath = Paths.get("../output/owners", owner.getName());
            if (!Files.exists(ownerPath)) {
                try {
                    Files.createDirectories(ownerPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Path transferPath = Paths.get(ownerPath.toString(), transfer.toString());

            try {
                Files.createFile(transferPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream(transferPath.toFile()))) {
                objectInputStream.writeObject(transfer);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        });
    }

}