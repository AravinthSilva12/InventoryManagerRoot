package com.aravinth.inventorymanager.repository.inmemory;
import com.aravinth.inventorymanager.model.StockItem;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.model.StockHistory;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class InMemoryStockHistoryRepository implements StockHistoryRepository {
    private Map<Integer, StockHistory> histories = new HashMap<>();
     private int nextId = 1;
// find all method :
@Override
public List<StockHistory> findAll(){
      return  new ArrayList<>(histories.values());
  }
// find by id method :
@Override
public StockHistory findById(int id){
      return histories.get(id);
    }
// find by item id method :
@Override
public List<StockHistory> findByItemId(int itemId){
      List<StockHistory> result = new ArrayList<>();
      for( StockHistory h : histories.values()){
          if(h.getStockItemId() == itemId){
              result.add(h);
          }
      }
      return result;
  }
// save method :
@Override
public void save(StockHistory history){
    if(history.getId() == 0){
        history.setId(nextId++);
    }
    histories.put(history.getId(), history);
 }
// delete method :
@Override
public void delete(int id){
      histories.remove(id);
 }
// update method :
@Override
public void update(StockHistory itemId){
    int id = itemId.getId();
    if(!histories.containsKey(id)){
        throw new NoSuchElementException("No such item is available in data base in the name of " + id);
    }
    histories.put(id, itemId);
}
// find low stock method :

}
