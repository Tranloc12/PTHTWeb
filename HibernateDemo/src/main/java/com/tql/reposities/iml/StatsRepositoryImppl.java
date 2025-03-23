/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tql.reposities.iml;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.tql.pojo.OrderDetail;
import com.tql.pojo.Product;
import com.tql.pojo.SaleOrder;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsRepositoryImppl {
    public List<Object[]> statsRevenusByProduct() {
        try(Session s= HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Object> q = b.createQuery(Object.class);
            Root root = q.from(OrderDetail.class);
            Join<OrderDetail,Product> join = root.join("productId", JoinType.INNER);
            
            q.multiselect(join.get("id"), join.get("name"), 
                    b.sum(b.prod(root.get("quantity"), root.get("unitPrice"))));
            q.groupBy(join.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
     public List<Object[]> statsRevenusByTime(String time, int year) {
        try(Session s= HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Object> q = b.createQuery(Object.class);
            Root root = q.from(OrderDetail.class);
            Join<OrderDetail,Product> join = root.join("orderId", JoinType.INNER);
            
            q.multiselect(b.function("time", Integer.class, join.get("createdDate")),
                    b.sum(b.prod(root.get("quantity"), root.get("unitPrice"))));
            q.where(b.equal(b.function("YEAR", Integer.class, join.get("createdDate")), year));
            q.groupBy(b.function("time", Integer.class, join.get("createdDate")));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
    
}
