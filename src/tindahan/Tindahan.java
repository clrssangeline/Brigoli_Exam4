
package tindahan;

import java.util.Scanner;


public class Tindahan {
        private class StackNode{
        int data;
        String product;
        StackNode next;
    }
    private StackNode top;
    private int size;

    private StackNode NewNode(String product, int quantity) throws Exception{
        StackNode node = new StackNode();
        if(node == null){
            throw new Exception("Memory is full");
        } else{
            node.data = quantity;
            node.product = product;
            node.next = null;
            return node;
        }    
    }
    
    public void addProduct(String product,int quantity) throws Exception{
        StackNode node = NewNode(product,quantity);
        
        if(size == 0){
            top = node;
        }
            else {
            node.next = top;
            top = node;
        }
        
        size++;
        
    }
    public int sellProduct(String product, int quantity)throws Exception{
        if(size == 0){
            throw new Exception("Tindahan is Empty");
        } else{
            int temporary = peek();
            top = top.next;
            size --;
        return temporary; 
        }

    }
    public int peek()throws Exception{
        if(size == 0){
            throw new Exception("Tindahan is Empty");
        }
        return top.data;
    }
    
    public void display()throws Exception{
        if(size == 0){
            throw new Exception("Product isn't available");
        }
        StackNode temporary = top;
        System.out.println("Quantity\t\tProduct");
        while (temporary != null) {            
            System.out.println( temporary.data+" \t\t\t"+temporary.product);
            temporary = temporary.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Tindahan list = new Tindahan();
        
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Display");
            int choice = scn.nextInt();
            int quantity;
            String product;
            
            switch (choice) {
                case 1:
                    System.out.println("Product you want to add ");
                    scn.nextLine();//white Line
                    product=scn.nextLine();                    
                    System.out.println("How many");
                    quantity = scn.nextInt();
                    list.addProduct(product, quantity);
                    break;
                case 2:
                    System.out.println("Product you want to sell");
                    scn.nextLine();
                    product= scn.nextLine();
                    System.out.println("How many");
                    quantity = scn.nextInt();
                    list.sellProduct(product, quantity);
                    break;
                case 3:
                    list.display();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    }
    

