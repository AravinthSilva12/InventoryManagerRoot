package com.aravinth.inventorymanager.model;

public class StockHistory {
    // variables & properties :
    private int id;
    private int stockItemId;
    private String type;
    private long timestamp;
    private int quantityChange;
    private String note;
    // constructor :
    public StockHistory(int id, int stockItemId, String type, long timestamp, int quantityChange, String note){
        this.id = id;
        this.stockItemId = stockItemId;
        this.type = type;
        this.timestamp = timestamp;
        this.quantityChange = quantityChange;
        this.note = note;
    }
    // id methods :
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    // stockItemId methods :
    public int getStockItemId(){
        return stockItemId;
    }

    public void setStockItemId(int stockItemId){
        this.stockItemId = stockItemId;
    }
    // type methods :
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
    // timestamp methods :
    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(int timestamp){
        this.timestamp = timestamp;
    }
    // quantityChange methods :
    public int getQuantityChange(){
        return quantityChange;
    }

    public void setQuantityChange(int quantityChange){
        this.quantityChange = quantityChange;
    }
    // note method :
    public String getNote(){
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }
    // conclusion display method :
    @Override
    public String toString(){
         return "StockHistory{" +
                 "id = "+ id +
                 ",stockItemId =" + stockItemId +
                 ",type = " + type +
                 ", quantityChange = " + quantityChange +
                 ", timeStamp = " + timestamp +
                 ", note : " + note + " }";
    }
}


