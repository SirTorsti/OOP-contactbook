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
        contacts.sort((c1, c2) -> {
            int groupCompare = c1.getContactGroup().compareToIgnoreCase(c2.getContactGroup());
            if (groupCompare == 0) {
                return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
            }
            return c1.getContactGroup().equalsIgnoreCase("Työ") ? -1 : 1;
        });
    }

}