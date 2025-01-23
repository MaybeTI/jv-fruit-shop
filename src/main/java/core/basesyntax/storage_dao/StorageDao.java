package core.basesyntax.storage_dao;

public interface StorageDao {
    void add(String fruit, int quantity);

    void subtract(String fruit, int quantity);
}
