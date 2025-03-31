package virta.viivainen.contact_info;

public class Contact {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String contactGroup;

    public Contact(String firstName, String lastName, String phoneNumber, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
