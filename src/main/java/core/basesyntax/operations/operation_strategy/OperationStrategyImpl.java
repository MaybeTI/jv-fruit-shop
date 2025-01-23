package core.basesyntax.operations.operation_strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.operation_handlers.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public Map<FruitTransaction.Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandler
    ) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler getHandler(
            FruitTransaction.Operation operation
    ) {
        return operationHandler.get(operation);
    }
}
