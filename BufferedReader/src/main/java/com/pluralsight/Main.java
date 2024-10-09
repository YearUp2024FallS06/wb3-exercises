package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {


        // create a FileReader object connected to the File
        FileReader fileReader = new FileReader("employees.csv");
        // create a BufferedReader to manage input stream
        BufferedReader bufReader = new BufferedReader(fileReader);
        bufReader.readLine();
        String input;
        // read until there is no more data
        while((input = bufReader.readLine()) != null) {
            String[] tokens = input.split(Pattern.quote("|"));

            int employeeId = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            float hoursWorked = Float.parseFloat(tokens[2]);
            double payRate = Double.parseDouble(tokens[3]);



            System.out.println(input);
            System.out.println(employeeId);
            System.out.println(name);
            System.out.println(hoursWorked);
            System.out.println(payRate);
            System.out.println("-------------------");
        }
        // close the stream and release the resources
        bufReader.close();

        Employee e = new Employee(10, "Dana Wyatt", 52.5f, 12.5);


        System.out.println(e.getGrossPay());
    }


    private void displayEmployee(Employee e){
        System.out.printf("%d:%s Pay this period: %.2f", e.getEmployeeId(), e.getName(), e.getGrossPay());
    }
}