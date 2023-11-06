public class Main {
    public static void main(String[] args) {
        Phone phone1 = new SamsungGalaxyS6();
        phone1.addContact("1", "0747362114", "Alexandru", "Balan");
        phone1.addContact("2", "0722831992", "Mihai", "David");

        phone1.sendMessage("0747362114", "Ala bala portocala");
        phone1.call("0722831992");

        System.out.println("First Contact: " + phone1.getFirstContact());
        System.out.println("Last Contact: " + phone1.getLastContact());
        System.out.println("First Message: " + phone1.getFirstMessage("0747362114"));
        System.out.println("Second Message: " + phone1.getSecondMessage("0747362114"));

        phone1.viewHistory();
    }
}