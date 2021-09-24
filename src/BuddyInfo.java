//Harsimran Kanwar 101143556

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

    public static void main(String[] args) {
        BuddyInfo b1 = new BuddyInfo();
        System.out.println("Hello " + b1.getName());
    }
}

