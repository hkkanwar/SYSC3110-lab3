//Harsimran Kanwar
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<BuddyInfo> buds;

    public AddressBook(){
        buds = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo b){
        buds.add(b);
    }

    public void removeBuddy(BuddyInfo b){
        buds.remove(b);
    }

    public static void main(String[] args){
        BuddyInfo buddy = new BuddyInfo("Tom","Carleton","613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
        System.out.println("Address Book");
    }
}


