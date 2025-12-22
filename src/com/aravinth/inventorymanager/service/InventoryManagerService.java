package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.repository.StockItemRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;
import java.util.List;
import java.util.ArrayList;

public class InventoryManagerService {
    private StockHistoryRepository historyRepo;
    private StockItemRepository stockRepo;

    public InventoryManagerService(StockItemRepository stockRepo, StockHistoryRepository historyRepo) {
        this.stockRepo = stockRepo;
        this.historyRepo = historyRepo;
    }

    public StockItem addStockItem(StockItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Sorry, an input cannot be null");
        }
        StockItem savedItem = stockRepo.save(item);
        StockHistory history = new StockHistory(savedItem, "Created");
        historyRepo.save(history);
        return savedItem;
    }

    public StockItem getStockItem(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Enter a valid ID");
        }
        return stockRepo.findById(id);
     }

    public boolean deleteStockItem(int id){
          if(id <= 0){
              throw new IllegalArgumentException("Id should not be empty");
          }
          StockItem item = stockRepo.findById(id);
          if(item == null){
              return false;
          }
          stockRepo.delete(id);
          historyRepo.save(item = stockRepo.delete(id, "Deleted"));
     }

    public List<StockItem> getAllstockItems(){
          return null;
    }

    public StockItem updateStockItem(int id, StockItem updatedItem){
       return null;
    }
// Stock History part below :
    public void logStockHistory(StockHistory history){

    }

    public List<StockHistory> viewStockHistory(int itemId){
        return null;
    }

}
