package com.dev.productManagement.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * 재고 입력
     */

    @RequestMapping(value = ("/insertStock"), method = {RequestMethod.POST})
    @ResponseBody
    public boolean insertStock(@RequestParam Map<String, Object> params){
        try {
            stockService.insertStock(params);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 재고 조회 (상품의 BARCODE로 조회)
     */
    @RequestMapping(value = ("/getStockByBarCode"), method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Map<String, Object>> getStockByBarCode(@RequestBody String barCode) {
        try {
            return stockService.getStockByBarCode(barCode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
