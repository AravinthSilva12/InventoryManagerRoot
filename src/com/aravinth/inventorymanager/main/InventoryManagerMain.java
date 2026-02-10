package com.aravinth.inventorymanager.main;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockHistoryRepository;
import com.aravinth.inventorymanager.service.InventoryManagerService;
import com.aravinth.inventorymanager.model.StockHistory;

public class InventoryManagerMain {
    public static void main(String[] args){
         InMemoryStockItemRepository stockRepo = new InMemoryStockItemRepository();
         InMemoryStockHistoryRepository historyRepo = new InMemoryStockHistoryRepository();
         InventoryManagerService service = new InventoryManagerService(stockRepo, historyRepo);
         StockItem item1 = new StockItem(0, "Pencil", 2, 5, 3, 4);
         StockItem item2 = new StockItem(0, "Eraser", 3, 5, 3, 4);
         service.addStockItem(item1);
         service.addStockItem(item2);
         System.out.println("All stock items : ");
         System.out.println(service.getAllStockItems());
         System.out.println("Low stock items :");
         System.out.println(service.findLowStockItems());
         item1.setQuantity(10);
         service.updateStockItem(item1.getId(), item1);
         service.deleteStockItem(item2.getId());
         System.out.println("After deletion : ");
         System.out.println(service.getAllStockItems());
    }
}

