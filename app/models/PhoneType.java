package models;

import java.util.List;

/**
 * A type of phone.
 */
public class PhoneType {
  private long id;
  private String phoneType;
  private List<Contact> contacts;


  /**
   * Contstruct a new instance of PhoneType.
   *
   * @param phoneType The phone type.
   */
  public PhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  /**
   * Add a contact to the list of contacts that use this phone type.
   *
   * @param contact The contact to add.
   */
  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  /**
   * Get the ID of this PhoneType.
   *
   * @return The ID of this Phone Type.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID of this PhoneType.
   *
   * @param id The ID of this PhoneType.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get the type of phone.
   *
   * @return The type of phone.
   */
  public String getPhoneType() {
    return phoneType;
  }

  /**
   * Set the type of phone.
   *
   * @param phoneType The type of phone.
   */
  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  /**
   * Get the contacts that use this type of phone.
   *
   * @return A list of the contacts that use this type of phone.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Set the contacts that use this type of phone.
   *
   * @param contacts A list of the contacts that use this type of phone.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
}
