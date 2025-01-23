package core.basesyntax.shop_service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.operation_handlers.OperationHandler;
import core.basesyntax.operations.operation_strategy.OperationStrategy;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions){
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
