package com.dgh.repository.impl;

import com.dgh.hibernatedemo.HibernateUtils;
import com.dgh.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    private static final int PAGE_SIZE = 4;
    public List<Product> getProducts(Map<String, String> params) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root<Product> root = q.from(Product.class);
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("q");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                    predicates.add(p1);
                }
                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                    predicates.add(p2);
                }
                
                String toPrice = params.get("toPrice");
                if (toPrice != null && !toPrice.isEmpty()) {
                    Predicate p3 = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                    predicates.add(p3);
                }
                
                String cate_id = params.get("cate_id");
                if (cate_id != null && !cate_id.isEmpty()) {
                    Predicate p4 = b.equal(root.get("category"), Integer.parseInt(cate_id));
                    predicates.add(p4);
                }
                q.where(predicates.toArray(Predicate[]::new));
            }
            Query query = s.createQuery(q);
            if (params != null){
                String page = params.get("page");
                if (page != null && !page.isEmpty()){
                    int p = Integer.parseInt(page);
                    int start = (p - 1) * PAGE_SIZE;
                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
            }
            return query.getResultList();
        }
    }
    
    public void addOrUpdate(Product p) {
        try (Session s = HibernateUtils.getFactory().openSession()){
            if (p.getId() != null){
                s.update(p);
            }else 
                s.save(p);
        }
    }
    
    public Product getProduct(int id){
        try (Session s = HibernateUtils.getFactory().openSession()){
            return s.get(Product.class, id);
        }
    }
}
