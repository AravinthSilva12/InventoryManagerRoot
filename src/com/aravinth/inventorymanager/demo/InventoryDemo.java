package com.aravinth.inventorymanager.demo;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockHistoryRepository;
import com.aravinth.inventorymanager.service.InventoryManagerService;

public class InventoryDemo {
        public static void main(String[] args) {
            InMemoryStockItemRepository stockRepo = new InMemoryStockItemRepository();
            InMemoryStockHistoryRepository historyRepo = new InMemoryStockHistoryRepository();
            InventoryManagerService service = new InventoryManagerService(stockRepo, historyRepo);

            StockItem pen = new StockItem(0, "Pen", 5, 10,4, 2);
            StockItem notebook = new StockItem(0, "Notebook", 20, 5, 5, 1);

            stockRepo.save(pen);
            stockRepo.save(notebook);

            System.out.println("Low stock:");
            System.out.println(service.findLowStockItems());

            pen.setQuantity(15);
            stockRepo.update(pen);

            System.out.println("After update: ");
            System.out.println(stockRepo.findAll());

            stockRepo.delete(notebook.getId());
            System.out.println("After delete: ");
            System.out.println(stockRepo.findAll());
        }
    }
