//Harsimran Kanwar
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class AddressBook extends DefaultListModel<BuddyInfo> {
    private ArrayList<BuddyInfo> buds;

    public AddressBook(){
        buds = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo b){
        buds.add(b);
    }

    public void removeBuddy(BuddyInfo b){
        //buds.remove(b);
    }

    public boolean removeBud(int b){
        boolean removed = false;
        if (buds.size() != 0){
            if (b >=0 && b <= buds.size()){
                this.buds.remove(b);
                removed=true;
            }
        }
        return removed;
    }

    public void save(String filename){
       try {
            /*ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            for (int i = 0; i < buds.size(); i++) {
                System.out.println("here");
                out.writeObject(buds.get(i).toString());
            }
            out.close();*/
           FileWriter out = new FileWriter(filename);
           out.write("Saved Address Book Entries:\n");
           for (int i = 0; i < buds.size(); i++) {
               out.write(buds.get(i).toString());
           }
           out.flush();
           out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error initializing stream");
        }


    }

    public void removeAll(){
        buds.clear();
    }
    public ArrayList<BuddyInfo> getBuds(){
        return buds;
    }
    public static void main(String[] args){
        /*BuddyInfo buddy = new BuddyInfo("Tom","Carleton","613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
        System.out.println("Address Book");*/

        Display addressBookDisplay = new Display();
        addressBookDisplay.displayGUI();
    }
}


