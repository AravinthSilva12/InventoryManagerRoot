package com.aravinth.inventorymanager.demo;
import com.aravinth.inventorymanager.model.StockHistory;
import com.aravinth.inventorymanager.repository.StockHistoryRepository;
import com.aravinth.inventorymanager.repository.inmemory.InMemoryStockHistoryRepository;
import java.time.Instant;
import java.util.List;

public class StockHistoryDemo {

    public static void main(String[] args) {
        StockHistoryRepository repo = new InMemoryStockHistoryRepository();

        // Create first history for itemId = 101
        StockHistory h1 = new StockHistory();
        h1.setStockItemId(101);
        h1.setQuantityChange(10);
        h1.setType("ADD");
        h1.setTimestamp(System.currentTimeMillis());
        h1.setNote("initial add");
        repo.save(h1);

        StockHistory h2 = new StockHistory();
        h2.setStockItemId(101);
        h2.setQuantityChange(-2);
        h2.setType("REMOVE");
        h2.setTimestamp(System.currentTimeMillis());
        h2.setNote("sold 2 units");
        repo.save(h2);

        StockHistory h3 = new StockHistory();
        h3.setStockItemId(202);
        h3.setQuantityChange(5);
        h3.setType("ADD");
        h3.setTimestamp(System.currentTimeMillis());
        h3.setNote("restock");
        repo.save(h3);

        // Print all history entries
        System.out.println("All histories:");
        List<StockHistory> all = repo.findAll();
        for (StockHistory h : all) {
            System.out.println(format(h));
        }

        // Find by item id
        System.out.println("\nHistories for itemId=101:");
        List<StockHistory> for101 = repo.findByItemId(101);
        for (StockHistory h : for101) {
            System.out.println(format(h));
        }

        // Find by id (first saved)
        System.out.println("\nFind by id of first saved history (h1): id=" + getIdSafe(h1));
        System.out.println(repo.findById(getIdSafe(h1)));

        // Delete one entry and show result
        System.out.println("\nDeleting id=" + getIdSafe(h2));
        repo.delete(getIdSafe(h2));
        System.out.println("Histories for itemId=101 after delete:");
        for (StockHistory h : repo.findByItemId(101)) {
            System.out.println(format(h));
        }
    }

    // Helper print: uses only getters that are likely present. If not present, prints "N/A".
    private static String format(StockHistory h) {
        if (h == null) return "null";
        return String.format(
                "id=%s, itemId=%s, change=%s, type=%s, ts=%s",
                safeCallGet(h, "getId"),
                safeCallGet(h, "getStockItemId"),
                safeCallGet(h, "getQuantityChange"),
                safeCallGet(h, "getType"),
                safeCallGet(h, "getTimestamp")
        );
    }

    // Reflection helpers (defensive — will not crash if a method is missing)
    private static Object safeCallGet(StockHistory h, String methodName) {
        try {
            return h.getClass().getMethod(methodName).invoke(h);
        } catch (Exception e) {
            return "N/A";
        }
    }

    private static void safeCallSet(StockHistory h, String methodName, Object value) {
        try {
            Class<?> paramType = value.getClass();
            // handle primitive long vs Long
            if (paramType == Long.class) paramType = long.class;
            if (paramType == Integer.class) paramType = int.class;
            h.getClass().getMethod(methodName, paramType).invoke(h, value);
        } catch (Exception ignored) {
            // ignore if setter not present; demo remains tolerant
        }
    }

    private static int getIdSafe(StockHistory h) {
        Object id = safeCallGet(h, "getId");
        if (id instanceof Number) return ((Number) id).intValue();
        return 0;
    }
}
