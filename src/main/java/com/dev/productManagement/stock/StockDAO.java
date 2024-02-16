package com.dev.productManagement.stock;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StockDAO {
    private final SqlSessionTemplate sqlSession;

    public StockDAO(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertStock(Map<String, Object> params) throws Exception{
        sqlSession.insert("com.dev.productManagement.stock.StockDAO.insertStock", params);
    }

    public List<Map<String, Object>> getStockByBarCode(String barCode) {
        return sqlSession.selectList("com.dev.productManagement.stock.StockDAO.getStockByBarCode", barCode);
    }
}
