package core.basesyntax.operations.operation_strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.operation_handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(
            FruitTransaction.Operation operation
    );
}
