package part1and2.proiect;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Hall extends Show implements Comparable<Hall>, ReadService {
    int id;
    int number_places;
    boolean full;
    Map<Integer, Boolean> places = new HashMap<Integer, Boolean>();
    public Hall(int id, int number_places){
        this.id = id;
        this.number_places = number_places;
        for(int i = 0 ; i < number_places ; i++)
            places.put(new Integer(i), new Boolean(false));
        full = false;
    }
    public Hall(int id, int number_places, String showName, float startingHour, float endingHour, double price, int minimumAge){
        super(showName, startingHour, endingHour, price, minimumAge);
        this.id = id;
        this.number_places = number_places;
        for(int i = 0 ; i < number_places ; i++)
            places.put(i, false);
        full = false;
    }


    public Integer getAviablePlace(){
        for(Map.Entry<Integer, Boolean> entry : places.entrySet()){
            if(entry.getValue() == false)
                return entry.getKey();
        }
        full = true;
        return 0;
    }
    public boolean getAviablePlace(int place){
        if(places.get(place).equals(false))
            return true;
        return false;
    }
    public void newDay(){
        for(Map.Entry<Integer, Boolean> entry : places.entrySet()) {
            entry.setValue(false);
        }
    }
    public boolean addShow(String showName, float startingHour, float endingHour, double price, int minAge){
        if(super.name == "\0"){
            super.name = showName;
            super.startingHour = startingHour;
            super.endingHour = endingHour;
            super.setPrice(price);
            super.minimumAge = minAge;
            return true;
        }
        return false;
    }
    public void switchShow(String showName, float startingHour, float endingHour, double price, int minAge){
        super.name = showName;
        super.startingHour = startingHour;
        super.endingHour = endingHour;
        super.setPrice(price);
        super.minimumAge = minAge;
    }
    public void setRecords(List<List<String>> records ){
        records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Hall.csv"));) {
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
        StringBuilder x = new StringBuilder();
        x.append("Hall id is ");
        x.append(this.id);
        x.append(". It has ");
        x.append(this.number_places);
        x.append(" chairs.");
        x.append(super.toString());
        String temp = new String(x);
        return temp;
    }

    @Override
    public int compareTo(Hall o) {
        if(this.id < o.id)
            return -1;
        return 1;
    }
}
