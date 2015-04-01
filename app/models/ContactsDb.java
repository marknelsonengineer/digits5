package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 4/1/15.
 */
public class ContactsDb {
  private static List<Contact> contacts = new ArrayList<Contact>();

  /**
   * Create a new contact object from ContactFormData, add it to the database and return the newly created contact.
   *
   * @param contactFormData The source of the data from which to create a new contact.
   * @return A fully populated contact object that's just been inserted into the database.
   */
  public static Contact createContactFromForm(ContactFormData contactFormData) {
    Contact contact = new Contact(
        contactFormData.firstName,
        contactFormData.lastName,
        contactFormData.phone
        );

    contacts.add(contact);

    return contact;
  }

  /**
   * Get a list of all of the contacts.
   *
   * @return A list of all of the contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
