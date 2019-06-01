package part1and2.proiect;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person implements ReadService{
    protected String first_name;
    protected String last_name;
    protected int age;
    public Person(String first_name, String last_name, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }
    public Person(){}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public void setRecords(List<List<String>> records ){
        records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Person.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordsHelper(scanner.nextLine()));
            }
        }
        catch(IOException e){
            System.out.println("Nu am reusit");
        }
    }
    public List<String> getRecordsHelper(String line){
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
    @Override
    public String toString() {
        return (first_name + last_name + " with age " + age + '.');
    }
}
