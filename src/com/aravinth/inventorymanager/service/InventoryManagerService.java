package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.repository.StockItemRepository;
import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("ID must be greater than zero");
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

    public List<StockItem> getAllStockItems(){
          return stockRepo.findAll();
    }

    public StockItem updateStockItem(int id, StockItem updatedItem){
       if(id <= 0){
            throw new IllegalArgumentException(("id cannot be less than zero"));
       }

       if(updatedItem == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        StockItem existingItem = stockRepo.findById(id);
        if(existingItem == null){
            return null;
        }
        updatedItem.setId(existingItem.getId());
        stockRepo.save(updatedItem);
        historyRepo.save(new StockHistory(updatedItem, "UPDATED"));
        return updatedItem;
    }

    public List<StockItem> findLowStockItems() {
        List<StockItem> lowStockItems = new ArrayList<>();
        List<StockItem> allStockItems = stockRepo.findAll();
        for (StockItem item : allStockItems) {
            if (item.isLowStock()) {
                lowStockItems.add(item);
            };
        }
        return lowStockItems;
    }
// Stock History part below :
    public void logStockHistory(StockHistory history){
         if(history == null){
             throw new IllegalArgumentException("Stock history cannot be empty");
         }
         historyRepo.save(history);
    }

    public List<StockHistory> viewStockHistory(int itemId){
            if(itemId <= 0){
                throw new IllegalArgumentException("Item Id must be greater than 0");
            }
        return historyRepo.findByItemId(itemId);
    }
}
