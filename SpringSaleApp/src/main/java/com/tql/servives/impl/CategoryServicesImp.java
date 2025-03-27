/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tql.servives.impl;

import com.tql.pojo.Category;
import com.tql.repositories.CategoryRespository;
import com.tql.services.CategoryServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryServicesImp implements CategoryServices{
    @Autowired
    private CategoryRespository cateRepo;

    @Override
    public List<Category> getCates() {

        return this.cateRepo.getCates();
        
    }
    
    
    
    
    
}
