package jdbc.gui.main;

import jdbc.services.PersonService;
import part1and2.proiect.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonFrame extends JFrame {

    private PersonService personService = new PersonService();

    private JPanel p1 = new JPanel(new BorderLayout());
    private JPanel p2 = new JPanel();

    private JLabel e1 = new JLabel("FIRST_NAME:");
    private JLabel e2 = new JLabel("LAST_NAME");
    private JLabel e3 = new JLabel("AGE:");
    private JTextField t1 = new JTextField(10);
    private JTextField t2 = new JTextField(10);
    private JTextField t3 = new JTextField(10);
    private JButton b1 = new JButton("ADD");

    private DefaultListModel<Person> model = new DefaultListModel<>();
    private JList<Person> list = new JList<>(model);

    public PersonFrame() {
        super("PERSONS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null); // ALINIERE CENTRATA

        add(p1); // PE CENTRU
        add(p2, BorderLayout.SOUTH); // JOS

        p2.add(e1);
        p2.add(t1);
        p2.add(e2);
        p2.add(t2);
        p2.add(e3);
        p2.add(t3);
        p2.add(b1);
        b1.addActionListener(ev -> adaugaPersoana());

        p1.add(list);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Person p = list.getSelectedValue();
                    if (p != null) {
                        System.out.println("Nu ai voie sa stergi pe nimeni !!!!");
                    }
                }
            }

        });
        afisarePersoane();

        setVisible(true);
    }

    private void adaugaPersoana() {
        String first_name = t1.getText();
        String last_name = t2.getText();
        int age = Integer.parseInt(t3.getText());
        PersonService.adaugaPerson(first_name,last_name, age);
        t1.setText(null);
        t2.setText(null);
        afisarePersoane();
        JOptionPane.showMessageDialog(this, "Ai adaugat o persoana!");
    }

    private void afisarePersoane() {
        model.clear();
        List persoane = personService.getPerson();
    }

    private void deletePersoana(Person p) {
        personService.delete(p);
        afisarePersoane();
    }
}