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
    public void save(StockItem item){
        if(item.getId() == 0){
            item.setId(nextId++);
        }
        items.put(item.getId(), item);
    }

    @Override
    public void update(StockItem item){

    }

    @Override
    public void delete(int id){

    }

    @Override
    public List<StockItem> findLowStock(){

    }
}

