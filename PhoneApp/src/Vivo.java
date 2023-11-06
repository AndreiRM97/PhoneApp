import java.util.ArrayList;
import java.util.List;
public class Vivo extends PhoneBrand implements Phone {
    protected String model;
    protected String color;
    protected String material;
    protected String imei;
    private List<Contact> contacts = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private List<Call> callHistory = new ArrayList<>();
    protected int batteryLife;

    public Vivo() {
        super("Vivo");
        this.batteryLife = 100;
    }

    @Override
    public void addContact(String contactId, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(phoneNumber, firstName, lastName);
        contacts.add(contact);
    }

    @Override
    public String getFirstContact() {
        if (!contacts.isEmpty()) {
            Contact firstContact = contacts.get(0);
            return firstContact.getPhoneNumber() + " - " + firstContact.getFirstName() + " " + firstContact.getLastName();
        }
        return "No contacts available.";
    }

    @Override
    public String getLastContact() {
        if (!contacts.isEmpty()) {
            Contact lastContact = contacts.get(contacts.size() - 1);
            return lastContact.getPhoneNumber() + " - " + lastContact.getFirstName() + " " + lastContact.getLastName();
        }
        return "No contacts available.";
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (batteryLife >= 1) {
            messages.add(new Message(phoneNumber, messageContent));
            batteryLife -= 1; // Deduct one hour from the battery life for sending a message
        } else {
            System.out.println("Battery is too low to send a message.");
        }
    }

    @Override
    public String getFirstMessage(String phoneNumber) {
        for (Message message : messages) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                return message.getMessageContent();
            }
        }
        return "No messages available for this contact.";
    }

    @Override
    public String getSecondMessage(String phoneNumber) {
        int messageCount = 0;
        for (Message message : messages) {
            if (message.getPhoneNumber().equals(phoneNumber)) {
                messageCount++;
                if (messageCount == 2) {
                    return message.getMessageContent();
                }
            }
        }
        return "No second message available for this contact.";
    }

    @Override
    public void call(String phoneNumber) {
        if (batteryLife >= 2) {
            callHistory.add(new Call(phoneNumber));
            batteryLife -= 2; // Deduct two hours from the battery life for making a call
        } else {
            System.out.println("Battery is too low to make a call.");
        }
    }

    @Override
    public void viewHistory() {
        System.out.println("Call History:");
        for (Call call : callHistory) {
            System.out.println(call.getPhoneNumber());
        }
    }
}
