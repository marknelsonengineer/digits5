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
  private static Map<String, PhoneType> phoneTypes = new HashMap<String, PhoneType>();
  private static Map<String, DietType> dietTypes = new HashMap<String, DietType>();
  private static long nextId = 1;

  /**
   * Create a new contact object from ContactFormData, add it to the database and return the newly created contact.
   *
   * @param contactFormData The source of the data from which to create a new contact.
   * @return A fully populated contact object that's just been inserted into the database.
   */
  public static Contact createContactFromForm(ContactFormData contactFormData) {
    Contact contact = null;
    PhoneType phoneType = ContactsDb.getPhoneType(contactFormData.phoneType);
    List<DietType> dietTypes = new ArrayList<DietType>();

    for (String formDietType : contactFormData.dietTypes) {
      dietTypes.add(ContactsDb.getDietType(formDietType));
    }

    if (contactFormData.id == 0) {
      contact = new Contact(
          nextId++,
          contactFormData.firstName,
          contactFormData.lastName,
          contactFormData.phone,
          phoneType,
          dietTypes
      );
    }
    else {
      contact = new Contact(
          contactFormData.id,
          contactFormData.firstName,
          contactFormData.lastName,
          contactFormData.phone,
          phoneType,
          dietTypes
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
  public static Contact getContact(long id) {
    if (!contacts.containsKey(id)) {
      throw new ArrayIndexOutOfBoundsException("The contact id [" + id + "] does not exist in the database.");
    }

    return contacts.get(id);
  }

  /**
   * Delete a contact from the database.
   *
   * @param id A contact ID from the database to delete.
   */
  public static void deleteContact(long id) {
    if (!contacts.containsKey(id)) {
      throw new ArrayIndexOutOfBoundsException("The contact id [" + id + "] does not exist in the database.");
    }

    contacts.remove(id);
  }

  /**
   * Add a DietType to the database.
   *
   * @param dietType The DietType to add.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Add a PhoneType to the database.
   *
   * @param phoneType The PhoneType to add.
   */
  public static void addPhoneType(PhoneType phoneType) {
    phoneTypes.put(phoneType.getPhoneType(), phoneType);
  }

  /**
   * Get a DietType object from the dietTypes database.
   *
   * @param dietType The type of diet to get.
   * @return A DietType object.
   */
  public static DietType getDietType(String dietType) {
    if (!dietTypes.containsKey(dietType)) {
      throw new RuntimeException("Unable to find DietType [" + dietType + "]");
    }
    return dietTypes.get(dietType);
  }

  /**
   * Get a PhoneType object from the phoneTypes database.
   *
   * @param phoneType The type of phone to get.
   * @return A PhoneType object.
   */
  public static PhoneType getPhoneType(String phoneType) {
    if (!phoneTypes.containsKey(phoneType)) {
      throw new RuntimeException("Unable to find PhoneType [" + phoneType + "]");
    }
    return phoneTypes.get(phoneType);
  }

}
