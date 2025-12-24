package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.repository.StockItemRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;

import java.util.IllformedLocaleException;
import java.util.List;
import java.util.ArrayList;

import static java.nio.file.Files.delete;

public class InventoryManagerService {
    private StockHistoryRepository historyRepo;
    private StockItemRepository stockRepo;

    public InventoryManagerService(StockItemRepository stockRepo, StockHistoryRepository historyRepo) {
        this.stockRepo = stockRepo;
        this.historyRepo = historyRepo;

    }

    public StockItem addStockItem(StockItem item) {
        if(item == null){
            throw new IllegalArgumentException("Stock item cannot be null");
        }
      StockItem savedItem = stockRepo.save(item);
               return savedItem;
    }

    public StockItem getStockItem(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("ID cannot be less than zero");
        }
        StockItem savedItem = stockRepo.findById(id);
                return savedItem;
    }

    public boolean deleteStockItem(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("ID cannot be null");
        }
        StockItem item = stockRepo.findById(id);
        if(item == null){
            return false;
        }
        stockRepo.delete(id);
        StockHistory history = new StockHistory(item, "Deleted");
        historyRepo.save(history);
                return true;
    }

    public List<StockItem> getAllstockItems(){
          return stockRepo.findAll();
    }

    public StockItem updateStockItem(int id, StockItem updatedItem){
       if(id <= 0){
            throw new IllformedLocaleException(("id cannot be less than zero"));
       }

       if(updatedItem == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        StockItem existingItem = stockRepo.findById(id);
        if(existingItem == null){
            return null;
        }
        StockItem newItem = new StockItem(
                existingItem.getId();
                existingItem.getName();
                existingItem.getQuantity();
                existingItem.getPrice();
                                         );
        stockRepo.save(newItem);
        StockHistory history = new StockHistory(newItem, "UPDATED");
        historyRepo.save(history);
        return newItem;
    }
// Stock History part below :
    public void logStockHistory(StockHistory history){

    }

    public List<StockHistory> viewStockHistory(int itemId){
        return null;
    }
}
