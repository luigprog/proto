/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;  
import java.io.IOException;  
  
public class Canonicalpath {  
    public static void main(String[] args) {  
        try {  
            System.out.println("/  -> " + new File("/").getCanonicalPath());  
            System.out.println(".. -> " + new File("..").getCanonicalPath());  
            System.out.println(".  -> " + new File(".").getCanonicalPath());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
} 