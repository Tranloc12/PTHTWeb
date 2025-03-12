/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tql.jdbcappdemo;

import com.tql.pojo.Choice;
import com.tql.services.QuestionServices;
import com.tql.services.StatsServices;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JdbcAppDemo {

    public static void main(String[] args) throws SQLException {
        StatsServices sr= new StatsServices();
        sr.countQuestionsByCate("").forEach(s -> System.err.printf("%d -%s: %d\n", s[0],s[1],s[2]));
        System.err.println(sr.countWrongQuestions());
        
        
//        Scanner sc= new Scanner(System.in);
//        QuestionServices s = new QuestionServices();
//        s.getQuestions(2).forEach(q -> {
//            
//            try {
//                System.err.println(q);
//
//                List<Choice> choices = s.getChoices(q.getId());
//                for(int i=0;i<choices.size();i++)
//                
//                    System.err.printf("%d. %s\n", i+1 ,choices.get(i));
//                    
//                System.err.print("Your Answer:  ");
//                int idx =  sc.nextByte();
//                if(choices.get(idx).isCorrect() == true )
//                    System.err.println("EXACTLY");
//                else
//                    System.out.println("WRONG");
//            } catch (SQLException ex) {
//                Logger.getLogger(JdbcAppDemo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            
//
//        });
    }
}
