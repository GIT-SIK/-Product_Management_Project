package com.dev.productManagement.stock;

import java.util.List;
import java.util.Map;

public interface StockService {
    void insertStock(Map<String, Object> params) throws Exception;
    List<Map<String, Object>> getStockByBarCode(String barCode);
}
