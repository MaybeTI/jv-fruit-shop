package core.basesyntax.operations.operation_handlers;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
