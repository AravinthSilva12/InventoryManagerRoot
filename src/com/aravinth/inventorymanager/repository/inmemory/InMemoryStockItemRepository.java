package com.aravinth.inventorymanager.repository.inmemory;
import com.aravinth.inventorymanager.repository.StockItemRepository;
import com.aravinth.inventorymanager.model.StockItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InMemoryStockItemRepository implements StockItemRepository {
    private Map<Integer, StockItem> items = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<StockItem> findAll(){
       return new ArrayList<>(items.values());
    }

    @Override
    public  StockItem findById(int id){
       return items.get(id);
    }

    @Override
    public StockItem save(StockItem item){
        if(item.getId() == 0){
            item.setId(nextId++);
        }
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void update(StockItem item){
         int id = item.getId();
         if(id == 0){
             save(item);
             return;
         }
         if(items.containsKey(id)){
           items.put(id, item);
         }
    }

    @Override
    public void delete(int id){
       items.remove(id);
    }

    @Override
    public List<StockItem> findLowStock(){
        List<StockItem> result = new ArrayList<>();
        for(StockItem item : items.values()){
            if(item.isLowStock()){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public StockItem delete(int id, String deleted) {
        return null;
    }
}

