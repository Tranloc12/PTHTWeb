/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tql.repositories.impl;

import com.tql.pojo.Category;
import com.tql.repositories.CategoryRespository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRespository{
    @Autowired
    private LocalSessionFactoryBean factory;
    public List<Category> getCates() {
        Session s = this.factory.getObject().getCurrentSession();
        
            Query query = s.createQuery("FROM Category", Category.class);
            return query.getResultList();
        
    }
}
