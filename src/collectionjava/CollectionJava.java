/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author daolinh
 */
public class CollectionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // demoArrayList();
      // demoHashSet();
      demoHashMap();
    }
    
    public static void demoArrayList(){                
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("Hello Java");
        list.add("Hello Programming!");
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }                
    }
    
    public static void demoHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hi");
        set.add("Nihao");
        
        for (String string : set) {
            System.out.println(string);
        }
    }
    
    public static void demoHashMap(){
        HashMap<Integer, String> mapName = new HashMap<>();
        mapName.put(1, "Tung");
        mapName.put(2, "Hung");
        mapName.put(3, "Khanh");
        mapName.put(4, "Loc");
        for (int i = 0; i < 5; i++) {
                String get = mapName.get(i);
                System.out.println(get);
                
        for (Map.Entry<Integer, String> entry : mapName.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            
        }           
        }                
    }
    
}
