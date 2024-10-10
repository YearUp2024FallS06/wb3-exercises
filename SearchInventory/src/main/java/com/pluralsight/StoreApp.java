package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {

    public static ArrayList<Product> inventory = getInventory();


    public static void main(String[] args) {

        ListAllProducts();
    }

    /**
     * Lists all products
     */
    public static void ListAllProducts(){
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    /**
     * prompt the user for an ID to search for,
     * if found,
     *          display product detail.
     *          then return
     * if not found,
     *          display product could not be found
     *          then return
     */
    public static void LookupProductById(){

    }

    /**
     * prompt user for price range (minumum, maximum)
     * if found, display product detail for all matches and then return
     * if not found, display product could not be found then return
     */
    public static void LookupProductsByPriceRange(){

    }

    /**
     * prompt user for ProductId, ProductName, and ProductPrice,
     * create a product and add it to ArrayList
     */
    public static void AddNewProduct(){

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        // this method loads product objects into inventory
        // and its details are not shown

        try{

            BufferedReader br = new BufferedReader( new FileReader("inventory.csv"));

            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split(Pattern.quote("|"));
//                int productId = Integer.parseInt(tokens[0]);
//                String productName = tokens[1];
//                float productPrice = Float.parseFloat(tokens[2]);
//                Product p = new Product(productId, productName, productPrice);
//                inventory.add(p);


                inventory.add(new Product(Integer.parseInt(tokens[0]), tokens[1], Float.parseFloat(tokens[2])));


            }

            br.close();

        }
        catch(Exception e){
            System.out.println("ERROR!!");
        }

        return inventory;
    }

}