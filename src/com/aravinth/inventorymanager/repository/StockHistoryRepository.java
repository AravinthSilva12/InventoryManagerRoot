package com.aravinth.inventorymanager.repository;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.model.StockItem;

import java.util.List;
public interface StockHistoryRepository {
    List<StockHistory> findAll();
    StockHistory findById(int id);
    List<StockHistory> findByItemId(int itemId);
    void save(StockHistory history);
    void delete(int id);
    void update(StockHistory itemId);
}