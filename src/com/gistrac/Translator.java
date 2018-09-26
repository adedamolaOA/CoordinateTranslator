/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gistrac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SecureUser
 */
public class Translator {
    
    public String getTranslationData() throws FileNotFoundException, IOException{
        File f = new File("ni.txt");
        FileReader r = new FileReader(f);
        BufferedReader io = new BufferedReader(r);
        StringBuilder data = new StringBuilder();
        String tempBuffer;
        while((tempBuffer=io.readLine())!=null){
           data.append(tempBuffer);
        }
        
        tempBuffer = data.toString();
        String[] splitBuffer = tempBuffer.split("NI");
        
        return splitBuffer[0];
    }
}
