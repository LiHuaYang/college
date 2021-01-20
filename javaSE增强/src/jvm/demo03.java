package jvm;

import java.util.HashMap;
import java.util.Map;

public class demo03 {  
	  
    public static demo03 t = new demo03();  
    
    private Map map = new HashMap();
    
    public demo03(){  
        System.out.println("MapµÄÖµ: " + map);  
    }  

    public static void main(String[] args) {  
         System.out.println(t); 
         System.out.println(t.map);  
    }  
  
}  