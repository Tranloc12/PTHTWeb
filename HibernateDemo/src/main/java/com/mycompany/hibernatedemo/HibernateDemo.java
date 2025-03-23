/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hibernatedemo;

import com.tql.reposities.iml.CategoryRepositoryImpl;
import com.tql.reposities.iml.ProductRepositoryImpl;
import com.tql.reposities.iml.StatsRepositoryImppl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
        s.getCates().forEach(c -> System.out.println(c.getName()));

        ProductRepositoryImpl prod = new ProductRepositoryImpl();

        Map<String, String> params = new HashMap<>();
//        params.put("kw", "galaxy");
//        params.put("fromPrice", "18600000");
//        params.put("categoryId", "2");
//        params.put("page", "4");

        prod.getProducts(params).forEach(p -> System.err.printf("%d - %s: %d\n",
                p.getId(), p.getName(), p.getPrice()));

        StatsRepositoryImppl s2 = new StatsRepositoryImppl();
        s2.statsRevenusByProduct().forEach(o -> System.err.printf("%d - %s %d\n", o[0], o[1], o[2]));

        System.err.println("______________________");

        s2.statsRevenusByTime("QUARTER", 2020).forEach(o -> System.err.printf("%d: %d\n", o[0], o[1]));

    }
}
