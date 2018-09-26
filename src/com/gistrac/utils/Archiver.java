/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gistrac.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SecureUser
 */
public class Archiver {
    public Archiver(){
        File f = new File("Archive\\LD");
        if(!f.exists()){
            f.mkdirs();
        }
        f = new File("Archive\\BTS");
        if(!f.exists()){
            f.mkdirs();
        }
        f = new File("Archive\\GPRS");
        if(!f.exists()){
            f.mkdirs();
        }
        f = new File("Archive\\CDR");
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
   public void archiveLD(String index,String data){
       File f = new File("Archive\\LD\\index.arc");
       if(!f.exists()){
           try {
               f.createNewFile();
               FileWriter fw = new FileWriter(f);
               try (BufferedWriter io = new BufferedWriter(fw)) {
                   io.write(index+"\n");
                   io.close();
                   achiveLData(index, index);
               }
               
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }else{
            FileWriter fw;
           try {
               fw = new FileWriter(f);
                try (BufferedWriter io = new BufferedWriter(fw)) {
                    io.append(index+"\n");
                    io.close();
                }
           } catch (IOException ex) {
               Logger.getLogger(Archiver.class.getName()).log(Level.SEVERE, null, ex);
           }
              
       }
   } 
   
   public void achiveLData(String index,String data){
       String[] splitIndex = index.split(",");
       File f = new File("Archive\\LD\\"+splitIndex[0]+".arc");
       if(!f.exists()){
           try {
               f.createNewFile();
               FileWriter fw = new FileWriter(f);
               try (BufferedWriter io = new BufferedWriter(fw)) {
                   io.write(data+"\n");
               }
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }else{
            FileWriter fw;
           try {
               fw = new FileWriter(f);
                try (BufferedWriter io = new BufferedWriter(fw)) {
                    io.append(data+"\n");
                }
           } catch (IOException ex) {
               Logger.getLogger(Archiver.class.getName()).log(Level.SEVERE, null, ex);
           }
              
       }
   }
   StringBuilder s = new StringBuilder();
   
   public void dataIndexCreate(String index){
       if(s==null){
          s.append(index);
          
       }else{
          s.append(","+index); 
       }
   }
   
   public String fileName(){
       String date = new Date().toString();
       String[] dateSplit = date.split(" ");
       String[] time = dateSplit[3].split(":");
       String name = dateSplit[0]+dateSplit[1]+dateSplit[2]+time[0]+time[1]+time[2]+dateSplit[5];
       return name;
   }
   
   
   
}
