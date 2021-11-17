//Harsimran Kanwar (testing step 17)

import java.util.Scanner;

public class BuddyInfo {

    private String name;
    private String address;
    private String number;

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public BuddyInfo(){
        this("Harsimran","1 Lab avenue","6134561234");
    }

    public static BuddyInfo importB(String b){
        Scanner s = new Scanner(b).useDelimiter("#");
        return new BuddyInfo(s.next(),s.next(),s.next());
    }

    @Override
    public String toString() {
        return name + "#"+ address + "#" + number + "\n";
    }
}

