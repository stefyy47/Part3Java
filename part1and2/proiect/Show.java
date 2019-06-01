package part1and2.proiect;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Show implements ReadService {
    protected String name;
    protected float startingHour;
    protected float endingHour;
    protected int minimumAge;
    private double price;

    WriteService write = new WriteService();

    public Show(String name, float startingHour, float endingHour, double price, int minimumAge){
        this.name = name;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.price = price;
        this.minimumAge = minimumAge;
        write.writeFunction("constructor show");
    }
    public Show(){}

    public void setStartingHour(float startingHour) {
        this.startingHour = startingHour;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEndingHour(float endingHour) {
        this.endingHour = endingHour;
    }

    public String getName() {
        return name;
    }

    public float getStartingHour() {
        return startingHour;
    }

    public float getEndingHour() {
        return endingHour;
    }

    public double getPrice() {
        return price;
    }
    public void setRecords(List<List<String>> records ){
        records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Show.csv"));) {
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
        StringBuilder afisare = new StringBuilder();
        afisare.append("The name of the show is ");
        afisare.append(name);
        afisare.append(". It start at ");
        afisare.append(startingHour);
        afisare.append(" and ends at ");
        afisare.append(endingHour);
        afisare.append(".");
        String temp = new String(afisare);
        return temp;
    }
}
