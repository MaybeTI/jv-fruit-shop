package core.basesyntax.operations.operation_handlers;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.subtract(fruit, quantity);
    }
}
