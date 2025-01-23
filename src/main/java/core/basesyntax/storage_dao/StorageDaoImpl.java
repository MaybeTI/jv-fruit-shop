package core.basesyntax.storage_dao;

import core.basesyntax.storage.Storage;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    Map<String, Integer> storage = Storage.storage;

    @Override
    public void add(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (storage.containsKey(fruit)) {
            storage.merge(fruit, -quantity, Integer::sum);
        }
    }
}
