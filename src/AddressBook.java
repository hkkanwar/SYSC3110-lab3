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
        System.out.println("Address Book");
    }
}


