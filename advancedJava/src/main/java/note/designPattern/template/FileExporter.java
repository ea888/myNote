package note.designPattern.template;

import java.io.File;

public interface FileExporter {
    void readWordFile(String name);
    File export();
}
