package part1and2.proiect;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    /*
        List<Hall> halls = new Vector<Hall>();
        System.out.println("How many halls? ");
        Scanner s = new Scanner(System.in);
        int temp = s.nextInt();
        int temp2, temp3;
        double money;
        for(int i = 0 ; i < temp ; i++){
            System.out.println("Hall id ");
            temp2 = s.nextInt();
            System.out.println("Number of chairs in the hall");
            temp3 = s.nextInt();
            halls.add(new Hall(temp2, temp3));
        }
        Collections.sort(halls);
        System.out.println(halls);
        Map<Customer, Boolean> customers = new HashMap<Customer, Boolean>();
        System.out.println("How many customers? ");
        temp = s.nextInt();
        for(int i = 0 ; i < temp ; i++){
            System.out.println("Customer email");
            String email = new String(s.nextLine());
            System.out.println("Money in customer's fidelity card");
            money = s.nextDouble();
            System.out.println("Customer's first name");
            String first_name = new String(s.nextLine());
            System.out.println("Customer's last name");
            String last_name = new String(s.nextLine());
            System.out.println("Customer's age");
            temp2 = s.nextInt();
            customers.put(new Customer(email, money, first_name, last_name, temp), new Boolean(false));
        }*/
        Show x = new Show("Salut", 2, 5, 40 , 2);

    }
}
