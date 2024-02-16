package com.dev.productManagement.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {
    private final SqlSessionTemplate sqlSession;

    public ProductDAO(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertProduct(Map<String, Object> params) throws Exception{
        sqlSession.insert("com.dev.productManagement.product.ProductDAO.insertProduct", params);
    }

    public List<Map<String, Object>> getProductByAll(Map<String, Object> params) {
        return sqlSession.selectList("com.dev.productManagement.product.ProductDAO.getProductByAll", params);
    }
}
