package core.basesyntax.report_fenerator;

import core.basesyntax.storage.Storage;
import jdk.jfr.Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
   private Map<String, Integer> storage = Storage.storage;

    @Override
    public String getReport() {
        List<String> report = new ArrayList<>();
        for (Map.Entry<String , Integer> entry : storage.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return String.join(System.lineSeparator(), report);
    }
}
