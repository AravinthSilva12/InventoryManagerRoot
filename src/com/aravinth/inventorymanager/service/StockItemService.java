package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockItem;
import java.util.List;

public interface StockItemService {
    StockItem createItem(StockItem item);
    StockItem updateItem(int id, StockItem updatedData);
    StockItem increaseStock(int id, int amount);
    StockItem decreaseStock(int id, int amount);
    StockItem getItem(int id);
    List<StockItem> listAll();
    List<StockItem> listLowStock();
    List<StockItem> searchByName(String name);
    void bulkAdjust(List<StockItem> adjustments);
}
