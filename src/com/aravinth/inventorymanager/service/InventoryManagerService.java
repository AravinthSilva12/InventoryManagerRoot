package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.repository.StockItemRepository;
import java.util.List;

public class InventoryManagerService {
    private StockHistoryRepository historyRepo;
    private StockItemRepository stockRepo;

    public InventoryManagerService(StockItemRepository stockRepo, StockHistoryRepository historyRepo){
        this.stockRepo = stockRepo;
        this.historyRepo = historyRepo;
    }

    public StockItem addStockItem(StockItem item){
         if(item == null){

         }
     }

    public StockItem getStockItem(int id){
        return null;
     }

    public boolean deleteStockItem(int id){
           return false;
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
