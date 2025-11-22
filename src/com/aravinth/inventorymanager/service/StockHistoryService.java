package com.aravinth.inventorymanager.service;
import com.aravinth.inventorymanager.model.StockHistory;
import java.util.List;

public interface StockHistoryService {
    void record(int itemId, String type, int quantityChange, String note);
    StockHistory recordManualNote(int itemId, String note);
    List<StockHistory> getHistoryForItem(int itemId);
    List<StockHistory> getAllHistory();
}
