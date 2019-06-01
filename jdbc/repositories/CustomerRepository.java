package jdbc.repositories;

import part1and2.proiect.Customer;
import part1and2.proiect.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class CustomerRepository {

    private String url = "jdbc:mysql://localhost/java";
    private String username = "user1";
    private String password = "12345";

    public void adaugaPersoana(Person p) {
        String  sql = "INSERT INTO person VALUES (?, ?, ?)";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, p.getFirst_name());
            s.setString(2, p.getLast_name());
            s.setInt(3, p.getAge());
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public List<Person> findPerson() {
        List<Person> list = new ArrayList<>();

        String sql = "SELECT * FROM person";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
                ResultSet rs = s.executeQuery();
        ) {
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                int age = rs.getInt("age");

                list.add(new Person(first_name, last_name, age));
            }
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }

        return list;
    }

    public void stergePerson(Person p) {
        String sql = "DELETE FROM person WHERE last_name = ?";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, p.getLast_name());
            s.executeUpdate();
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }
}