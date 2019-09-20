/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistproject;

/**
 *
 * @author stept
 */
public class LinkedListProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedStringList list = new LinkedStringList();
        
        list.add("First");
        
        list.add("Second");

        list.add("Third");
        
        list.moveFirst();
        list.setCurrentValue("Red");
        
        list.moveNext();
        list.setCurrentValue("Green");
        
        list.moveNext();
        list.setCurrentValue("Blue");
              
        list.indexOf("Green");
        
        list.displayList();
        System.out.println("");
        
        list.sortAscending();
        
        list.displayList();
        
        System.out.println("");
        list.remove();
        list.remove();
        list.displayList();
        
        
    }
    
}
