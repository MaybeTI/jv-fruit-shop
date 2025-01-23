package core.basesyntax.work_with_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileWriterImpl implements CustomFileWriter {
    private static final String DEFAULT_START_STRING = "fruit,quantity" + System.lineSeparator();

    @Override
    public void write(String data, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(DEFAULT_START_STRING);
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}

