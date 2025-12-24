package com.aravinth.inventorymanager.repository;
import com.aravinth.inventorymanager.model.StockItem;
import java.util.List;
public interface StockItemRepository {
    List<StockItem> findAll();
    StockItem findById(int Id);
    StockItem save(StockItem item);
    void update(StockItem item);
    void delete(int id);
    List<StockItem> findLowStock();
    StockItem delete(int id, String deleted);

}
