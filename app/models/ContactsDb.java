package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds an in-memory database of all contact objects in the data model.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class ContactsDb {
  private static Map<Long, Contact> contacts = new HashMap<Long, Contact>();
  private static long nextId = 1;

  /**
   * Create a new contact object from ContactFormData, add it to the database and return the newly created contact.
   *
   * @param contactFormData The source of the data from which to create a new contact.
   * @return A fully populated contact object that's just been inserted into the database.
   */
  public static Contact createContactFromForm(ContactFormData contactFormData) {
    Contact contact = null;

    if (contactFormData.id == 0) {
      contact = new Contact(
          nextId++,
          contactFormData.firstName,
          contactFormData.lastName,
          contactFormData.phone
      );
    }
    else {
      contact = new Contact(
          contactFormData.id,
          contactFormData.firstName,
          contactFormData.lastName,
          contactFormData.phone
      );
    }

    contacts.put(contact.getId(), contact);

    return contact;
  }

  /**
   * Get a list of all of the contacts.
   *
   * @return A list of all of the contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

  /**
   * Get a contact from the database.
   *
   * @param id The ID of the contact to get.
   * @return A contact from the database.
   */
  public static Contact getContact(Long id) {
    if (!contacts.containsKey(id)) {
      throw new ArrayIndexOutOfBoundsException("The contact id [" + id + "] does not exist in the database.");
    }

    return contacts.get(id);
  }

}
