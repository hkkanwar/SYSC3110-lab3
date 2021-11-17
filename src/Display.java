import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Display extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem createAddressBook;
    private JMenu menu2;
    private JMenuItem addBuddy;
    private JMenuItem removeBuddy;
    private JMenuItem saveAddy;
    private JMenuItem importBook;
    private AddressBook addressBook;
    private JList<BuddyInfo> buddyJList;

    public Display() {
        super("Address Book");
    }

    public void displayGUI() {
        addressBook = new AddressBook();
        this.setSize(600, 400);
        buddyJList = new JList<BuddyInfo>(addressBook);
        //this.add(buddyJList);

        // Initializing the menu bars
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu1 = new JMenu("Address Book");
        menu2 = new JMenu("Buddy Info");

        // Initializing the drop-down menu items
        createAddressBook = new JMenuItem("New Address Book");
        addBuddy = new JMenuItem("Add buddy!");
        removeBuddy = new JMenuItem("Remove buddy!");
        saveAddy = new JMenuItem("Save Address Book");
        importBook= new JMenuItem("Import Address Book");


        // Adding the menu bar and items to the menu
        menuBar.add(menu1);
        menuBar.add(menu2);
        menu1.add(createAddressBook);
        menu1.add(saveAddy);
        menu1.add(importBook);
        menu2.add(addBuddy);
        menu2.add(removeBuddy);


        /*JPanel t = new JPanel();
        t.setBackground(Color.red);
        JLabel test = new JLabel("No buddies added yet!",SwingConstants.CENTER);
        t.add(test);
       if (buddyJList.getModel().getSize() == 0){
            this.add(t);
        }*/

        // Adding an action listener event when adding a buddy
        addBuddy.addActionListener(e -> {
            this.add(buddyJList);
            Object name = JOptionPane.showInputDialog("Input Buddy Name:");
            Object address = JOptionPane.showInputDialog("Input Buddy Address:");
            Object phone = JOptionPane.showInputDialog("Input Buddy Phone #:");
            addressBook.addElement(new BuddyInfo((String) name, (String) address, (String) phone));
            addressBook.addBuddy(new BuddyInfo((String) name, (String) address, (String) phone));
            System.out.println(addressBook.getBuds());
            System.out.println(buddyJList.getModel());
        });

        removeBuddy.addActionListener(e -> {
            if (addressBook.removeBud(buddyJList.getSelectedIndex())) {
                addressBook.remove(buddyJList.getSelectedIndex());
            }
        });

        createAddressBook.addActionListener(e -> {
            addressBook.removeAllElements();
        });
        saveAddy.addActionListener(e-> {
            addressBook.save("test.txt");
        });
        importBook.addActionListener(e-> {
            this.add(buddyJList);
            Object name = JOptionPane.showInputDialog("Import file:");
            try {
                readImport((String) name);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



    public void readImport(String filename) throws IOException {
        File file = new File("/Users/harsimrankanwar/IdeaProjects/Lab1/"+filename);
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNextLine()){ //loop will run from 2nd line
            BuddyInfo b = new BuddyInfo();
            addressBook.addBuddy(b.importB(scan.nextLine()));
            addressBook.addElement(b.importB(scan.nextLine()));
        }
        System.out.println(buddyJList.getModel());
    }

}


