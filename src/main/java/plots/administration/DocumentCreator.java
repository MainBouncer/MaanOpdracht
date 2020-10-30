package plots.administration;

import plots.model.Owner;
import plots.model.Transfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DocumentCreator {

    public DocumentCreator(List<Transfer> transfers) {
        transfers.forEach(transfer -> {
            Owner owner = transfer.getNewOwner();
            Path ownerPath = Path.of("./output/owners", owner.getName());
            if (!Files.exists(ownerPath)) {
                try {
                    Files.createDirectories(ownerPath);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

            Path transferPath = Path.of(ownerPath.toString(), transfer.toString());
            try {
                if (!Files.exists(transferPath)) {
                    Files.createFile(transferPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            try (ObjectOutputStream objectInputStream =
                         new ObjectOutputStream(new FileOutputStream(transferPath.toFile()))) {
                objectInputStream.writeObject(transfer);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        });
    }

}
