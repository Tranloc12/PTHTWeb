/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tql.reposities.iml;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.tql.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates() {
        try(Session s  = HibernateUtils.getFACTORY().openSession()){
            Query query = s.createQuery("FROM Category", Category.class);
            return query.getResultList();
        }
    }
}
