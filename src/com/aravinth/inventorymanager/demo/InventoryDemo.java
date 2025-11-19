package com.aravinth.inventorymanager.demo;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;

    public class InventoryDemo {
        public static void main(String[] args) {
            InMemoryStockItemRepository repo = new InMemoryStockItemRepository();

            StockItem a = new StockItem(0, "Pen", 5, 10, System.currentTimeMillis());
            StockItem b = new StockItem(0, "Notebook", 20, 5, System.currentTimeMillis());

            repo.save(a);
            repo.save(b);

            System.out.println("All: " + repo.findAll());
            System.out.println("Low stock: " + repo.findLowStock());

            a.setQuantity(15);
            repo.update(a);

            System.out.println("After update: " + repo.findAll());

            repo.delete(b.getId());
            System.out.println("After delete: " + repo.findAll());
        }
    }
