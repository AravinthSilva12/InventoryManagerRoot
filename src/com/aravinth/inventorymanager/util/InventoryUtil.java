package com.aravinth.inventorymanager.util;

public final class InventoryUtil {

    private static int stockItemIdCounter = 0;
    private static int updateCounter = 0;

    private InventoryUtil() {
        // prevent object creation
    }

    public static int generateStockItemId() {
        return ++stockItemIdCounter;
    }

    public static int markUpdated() {
        return ++updateCounter;
    }
}

