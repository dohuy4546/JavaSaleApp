/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dgh.hibernatedemo;

import com.dgh.pojo.Cart;
import com.dgh.pojo.Category;
import com.dgh.pojo.Product;
import com.dgh.repository.impl.CategoryRepositoryImpl;
import com.dgh.repository.impl.ProductRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl cateImpl = new CategoryRepositoryImpl();
//        List<Category> cates = cateImpl.getCates();
//        cates.forEach(c -> System.out.println(c.getName()));
//        Map<String, String> params = new HashMap<>();
//        params.put("q", "iPhone");
//        params.put("fromPrice", "17000000");
//        params.put("page", "2");
//        ProductRepositoryImpl productImpl = new ProductRepositoryImpl();
//        List<Product> products = productImpl.getProducts(params);
//        products.forEach(c -> System.out.printf("%s - %f\n", c.getName(), c.getPrice()));
        List<Cart> carts = new ArrayList<Cart>();
    }
}
