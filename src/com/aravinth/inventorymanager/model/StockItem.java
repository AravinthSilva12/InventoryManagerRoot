package com.aravinth.inventorymanager.model;

public class StockItem {
    // variables & properties :
    private int id;
    private String name;
    public double price;
    private int quantity;
    private int lowStockThreshold;
    private long lastUpdated;
    // -------------------------
    // constructor :
    public StockItem(int id, String name, double price, int quantity, int lowStockThreshold, long lastUpdated){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
        this.lastUpdated = lastUpdated;
    }

    public StockItem(int id, String name, int quantity, double price) {
                         this.id = id;
                         this.name = name;
                         this.quantity = quantity;
                         this.price = price;
    }

    public StockItem(int id, String name, int quantity, int lowStockThreshold, long lastUpdated) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.lowStockThreshold = lowStockThreshold;
    this.lastUpdated = lastUpdated;
}

    // Primary constructor with all fields
public StockItem(int id, String name, double price, int quantity, 
                 int lowStockThreshold, long lastUpdated) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.lowStockThreshold = lowStockThreshold;
    this.lastUpdated = lastUpdated;
}

// Convenience constructor with sensible defaults
public StockItem(int id, String name, double price, int quantity) {
    this(id, name, price, quantity, 0, System.currentTimeMillis());
}

    // -------------------------
    // id methods :
    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }
    // -------------------------
    // name & price methods :
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
    // -------------------------
    // quantity methods :
    public int getQuantity(){
       return quantity;
    }

    public void  setQuantity(int quantity){
       this.quantity = quantity;
    }
    // -------------------------
    // getLowStockThreshold methods :
    public int getLowStockThreshold(){
        return lowStockThreshold;
    }

    public void setLowStockThreshold(int lowStockThreshold){
      this.lowStockThreshold = lowStockThreshold;
    }
    // -------------------------
    public long getLastUpdated(){
       return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated){
       this.lastUpdated = lastUpdated;
    }
    // -------------------------
    public boolean isLowStock(){
       return quantity <= lowStockThreshold;
    }
    // -------------------------
    // lastUpdated method :
    @Override
    public String toString(){
        return "StockItem {" +
                "Id = " + id +
                ", Name : " + name +
                ", Quantity = " + quantity +
                ", LowStockThreshold = " + lowStockThreshold +
                ", Last updated : " + lastUpdated + " }";
    }
}


