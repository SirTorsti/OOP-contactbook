package virta.viivainen.contact_info;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ContactStorage {

    private ContactStorage() {

    }
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage storage = null;

    public static ContactStorage getInstance() {
        if (storage == null) {
            storage = new ContactStorage();
        }
        return storage;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        Log.d("MainActivity", "Contact list size: " + ContactStorage.getInstance().getContacts().size());
    }

    public void removeContact(int contactToRemoveIndex) {
        contacts.remove(contactToRemoveIndex);
    }

    public void sortAlphabetically() {
        Collections.sort(contacts, (c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
    }

    public void sortByGroup() {
        ArrayList<Contact> workContacts = new ArrayList<>();
        ArrayList<Contact> otherContacts = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact currentContact = iterator.next();
            if (currentContact.getContactGroup().equalsIgnoreCase("Työt")) {
                workContacts.add(currentContact);
            } else {
                otherContacts.add(currentContact);
            }
        }
        Collections.sort(workContacts, Comparator.comparing(Contact::getFirstName));
        Collections.sort(otherContacts, Comparator.comparing(Contact::getFirstName));
        contacts.clear();
        contacts.addAll(workContacts);
        contacts.addAll(otherContacts);
    }
}