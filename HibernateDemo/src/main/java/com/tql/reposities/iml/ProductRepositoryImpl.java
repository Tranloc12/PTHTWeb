/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tql.reposities.iml;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.tql.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    private static final int PAGE_SIZE =4;
    
    public List<Product> getProducts (Map<String, String > params){
        try(Session s= HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            
            if(params !=null){
                List<Predicate> predicates = new ArrayList<>();
                
                String kw = params.get("kw");
                if(kw != null && !kw.isEmpty())
                   predicates.add( b.like(root.get("name"), String.format("%%%s%%", kw)));
                
                String toPrice = params.get("toPrice");
                if(toPrice !=null && !toPrice.isEmpty())
                predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
                
                String cateId = params.get("categoryId");
                if(cateId !=null && !cateId.isEmpty())
                predicates.add(b.equal(root.get("categoryId").as(Integer.class), cateId));
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            
        // tra cứu 
        
            Query query = s.createQuery(q);
            if(params!= null )
            {
                int page = Integer.parseInt(params.getOrDefault("page","1"));
                int start =(page -1)*PAGE_SIZE;
                query.setMaxResults(PAGE_SIZE);
                query.setFirstResult(start);
            }
            
            
        // phân trang 
            
            query.setMaxResults(9);
            query.setFirstResult(1);
                
        
            return query.getResultList();
        
        }
    }
}
