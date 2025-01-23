package core.basesyntax.operations.operation_handlers;

import core.basesyntax.storage_dao.StorageDao;
import core.basesyntax.storage_dao.StorageDaoImpl;

public interface OperationHandler {
    StorageDao storageDao = new StorageDaoImpl();
    void handle(String fruit, int quantity);
}
