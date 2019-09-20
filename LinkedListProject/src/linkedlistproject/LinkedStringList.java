/*
    Stephen Tornetta. PSU 2018
 */
package linkedlistproject;

/**
 *
 * @author stept
 */
import java.util.NoSuchElementException;

public class LinkedStringList 
{

    private Node first;
    private Node currentNode;
    private int length;

    class Node 
    {

        private String data;
        private Node next;

        public void printNodeData() 
        {
            System.out.println("Node data: " + data);
        }

        public Node getNext() 
        {
            return next;
        }
    }

    public LinkedStringList() 
    {
        first = null;
        currentNode = null;
        length = 0;
    }

    public void addFirst(String value) 
    {

        //create the Node and set its value
        Node newNode = new Node();
        newNode.data = value;

        // if newNode is the first node, this will be null
        // otherwise it will point to the former "first" now
        newNode.next = first;

        //set our "first" Node to the Node we just created
        first = newNode;

        currentNode = newNode;

        length++;

    }

    public void add(String value) 
    {
        Node newNode = new Node(); //creation of New Node
        newNode.data = value;

        if (first == null) 
        {
            addFirst(value);
        } 
        else 
        {
            newNode.next = currentNode.next; // Setting the newNode pointer to point to where the currentNode was pointing.

            currentNode.next = newNode; // Sets the pointer of currentNode equal to newNode

            currentNode = newNode; // Add our currentNode equal to newNode

            length++;
        }

    }

    public void removeFirst() 
    {
        if (first != null) 
        {
            first = first.next;
            length--;
        }

    }

    public void remove() 
    {
        Node tempNode = first;

        if (currentNode == first) 
        {
            removeFirst();
        } 
        else 
        {

            while (tempNode != null) 
            {
                //System.out.println(currentNode.data);
                if (tempNode.getNext() == currentNode) 
                {
                    
                    // Same process as adding a Node, except this time were using a "previous Node" instead of a newly created one
                    tempNode.next = currentNode.next;
                    currentNode.next = tempNode;
                    currentNode = tempNode;
                    length--;

                    break;
                } 
                else 
                {
                    tempNode = tempNode.getNext();
                }
            }
        }
    }

    public void setFirstValue(String value) 
    {
        first.data = value;
    }

    public void setCurrentValue(String value) 
    {
        currentNode.data = value;
    }

    public void moveNext() 
    {
        if (currentNode.next == null) 
        {
            throw new NoSuchElementException();
        } 
        else 
        {
            currentNode = currentNode.next;
        }
    }

    public void moveFirst() 
    {
        currentNode = first;
    }

    public boolean isEmpty() 
    {
        return (first == null);
    }

    public int getLength() 
    {
        return length;
    }

    public String getFirstValue() {
        if (first == null) 
        {
            throw new NoSuchElementException();
        } 
        else 
        {
            return first.data;
        }
    }

    public String getCurrentValue() 
    {
        if (currentNode == null) 
        {
            throw new NoSuchElementException();
        } 
        else 
        {
            return currentNode.data;
        }
    }

    public int indexOf(String value) 
    {
        int x = 1;
        Node tempNode = first;

        if (value == tempNode.data) // initial check to see if our first node is what we are looking for.
        {
            System.out.println(value + " is at position: " + x);
            return x;
        }

        while (value != tempNode.data) 
        {
            tempNode = tempNode.getNext();
            x++;

            if (value == tempNode.data) 
            {
                System.out.println(value + " is at position: " + x);
                return x;
            }

            if (x == length) 
            {
                System.out.println(value + " is not in this list");
                return -1;
            }
        }

        return -1;
    }

    public String getNodeData(int min) // Needed to be able to compare Nodes.
    { 
        
        Node tempNode = first;
        for (int i = 0; i < min; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public void swap(int a, int b) 
    {
        
        Node Node1 = null;
        Node Node2 = null;
        Node tempNode = first;

        for (int i = 0; i <= a; i++) {
            Node1 = tempNode;
            tempNode = tempNode.next;
        }

        tempNode = first;

        for (int i = 0; i <= b; i++) {
            Node2 = tempNode;
            tempNode = tempNode.next;
        }
        
        //Swapping the values
        String value2 = Node1.data;

        String value1 = Node2.data;

        Node2.data = value2;

        Node1.data = value1;

    }

    public int getMin(int position) 
    {
        Node tempNode = first;

        for (int i = 0; i < position; i++) // position will initially be zero. Going through each node in the list.
        {
            tempNode = tempNode.next;
        }

        String min = tempNode.data;

        int minpos = position;
        int currentpos = position;

        while (tempNode != null) {
            if (tempNode.data.compareTo(min) < 0) {
                min = tempNode.data;
                minpos = currentpos;

            }
            tempNode = tempNode.next;
            currentpos++;
        }
        return minpos;
    }

    public void sortAscending() 
    {
        Node tempNode = first;
        int pos = 0;
        
        while (tempNode.next != null) {
            int min = getMin(pos);
            if (tempNode.data.compareTo(getNodeData(min)) > 0) {
                swap(min, pos);
            }
            tempNode = tempNode.next;
            pos++;

        }
    }

    public void displayList() 
    {
        Node currentNode = first;
        System.out.println("List contents:");
        
        while (currentNode != null) 
        {
            currentNode.printNodeData();
            currentNode = currentNode.getNext();
        }
    }

}
