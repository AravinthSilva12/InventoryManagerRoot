package com.aravinth.inventorymanager.main;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockHistoryRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockItemRepository;
import com.aravinth.inventorymanager.service.InventoryManagerService;
import java.util.Scanner;

    public class InventoryManagerMain {
        public static void main(String[] args) {
            InMemoryStockItemRepository stockItem = new InMemoryStockItemRepository();
            InMemoryStockHistoryRepository stockHistory = new InMemoryStockHistoryRepository();
            InventoryManagerService serviceObj = new InventoryManagerService(stockItem, stockHistory);
            Scanner sc = new Scanner(System.in);
            String option;
            System.out.println("Welcome to Inventory manger!");
            System.out.println("---------------------------------------------------------------------------------");
            do {
                try {
                System.out.println("'Please choose an option to continue'/'press a valid key'");
                System.out.println("'A' --> Add item");
                System.out.println("'B' --> View all items");
                System.out.println("'C' --> Delete item");
                System.out.println("'D' --> Update quantity");
                System.out.println("'E' --> Low stock alert");
                System.out.println("'F' --> log stock history");
                System.out.println("'G' --> View stock history");
                System.out.println("'H' --> Exit");
                option = sc.nextLine();
                    switch (option) {
                        case "A":{
                         System.out.println("Add item :");
                         System.out.println("Enter the item name");
                         String itemName = sc.nextLine();
                         System.out.println("Enter the quantity of this item");
                         int quantityOfItem = sc.nextInt();
                         sc.nextLine();
                         System.out.println("Enter the price for this item (per item - eg:'10'rupees)");
                         double priceOfItem = sc.nextDouble();
                         sc.nextLine();
                         System.out.println("Set a low stock threshold value - (eg:'15')");
                         int lowStockThresholdOfItem = sc.nextInt();
                         sc.nextLine();
                         int id = 0;
                         long lastUpdatedItem = System.currentTimeMillis();
                         StockItem itemEntry = new StockItem(id, itemName, priceOfItem, quantityOfItem, lowStockThresholdOfItem, lastUpdatedItem);
                         serviceObj.addStockItem(itemEntry);
                         System.out.println("your item added successfully!");
                        }
                        break;
                        case "B":{
                           System.out.println("View all items :");
                           for (StockItem item : serviceObj.getAllStockItems()){
                               System.out.println(item);
                           }
                        }
                        break;
                        case "C":{
                            System.out.println("Delete item");
                            System.out.println("Enter the item ID to delete the item");
                            int itemEntry = sc.nextInt();
                            sc.nextLine();
                            serviceObj.deleteStockItem(itemEntry);
                            System.out.println("Item Delted successfully");
                        }
                        break;
                        case "D":{
                            System.out.println("Enter the 'item Id' that you want to update");
                            int itemId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the item name");
                            String itemName = sc.nextLine();
                            System.out.println("Enter the new price");
                            double newPrice = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Enter the new quantity for this item");
                            int newQuantity = sc.nextInt();
                            System.out.println("Enter the new Low threshold value for this item");
                            int newThreshold = sc.nextInt();
                            sc.nextLine();
                            long timeUpdate = System.currentTimeMillis();
                            StockItem updatedItem = new StockItem(itemId, itemName, newPrice, newQuantity, newThreshold, 0);
                            serviceObj.updateStockItem(itemId, updatedItem);
                            System.out.println("Updated successfully!");
                        }
                        break;
                        case "E": {
                            System.out.println("Low Stock Alert! :");
                            for (StockItem item : serviceObj.findLowStockItems()) {
                                System.out.println(item);
                            }
                        }
                        break;
                        case"F":{
                           System.out.println("Log Stock history :");
                           System.out.println("History of the items are automatically logged when the item is added or deleted or update");
                        }
                        break;
                        case "G":{
                            System.out.println("Enter the item Id to view its history");
                            int itemId = sc.nextInt();
                            sc.nextLine();
                            for(StockHistory history : serviceObj.viewStockHistory(itemId)){
                                System.out.println(history);
                                System.out.println("Under work!");
                            };
                        }
                        break;
                        case "H":{
                         return;
                        }
                        default:{
                            System.out.println("Please enter a valid option to continue");
                        }
                        break;
                    }
                    }catch(Exception e){
                        System.out.println("Sorry, an error occurred. Please try again.");
                    }
            }while(true);
        }
    }