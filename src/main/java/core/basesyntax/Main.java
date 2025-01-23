package core.basesyntax;

import core.basesyntax.data_converter.DataConverter;
import core.basesyntax.data_converter.DataConverterImpl;
import core.basesyntax.operations.operation_handlers.OperationHandler;
import core.basesyntax.operations.operation_handlers.BalanceOperation;
import core.basesyntax.operations.operation_handlers.PurchaseOperation;
import core.basesyntax.operations.operation_handlers.ReturnOperation;
import core.basesyntax.operations.operation_handlers.SupplyOperation;
import core.basesyntax.operations.operation_strategy.OperationStrategy;
import core.basesyntax.operations.operation_strategy.OperationStrategyImpl;
import core.basesyntax.report_fenerator.ReportGenerator;
import core.basesyntax.report_fenerator.ReportGeneratorImpl;
import core.basesyntax.shop_service.ShopService;
import core.basesyntax.shop_service.ShopServiceImpl;
import core.basesyntax.work_with_file.CustomFileReader;
import core.basesyntax.work_with_file.CustomFileReaderImpl;
import core.basesyntax.work_with_file.CustomFileWriter;
import core.basesyntax.work_with_file.CustomFileWriterImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        CustomFileReader fileReader = new CustomFileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        CustomFileWriter fileWriter = new CustomFileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}