package models;

import java.util.List;

/**
 * The types of diets a Contact likes.
 */
public class DietType {
  private long id;
  private String dietType;
  private List<Contact> contacts;

  /**
   * Construct a new instance of DietType.
   *
   * @param dietType The diet type.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Add a contact to the list of contacts that use this diet type.
   *
   * @param contact The contact to add.
   */
  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  /**
   * Get the contacts that use this DietType.
   *
   * @return The list of contacts that use this DietType.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Set the contacts that use this DietType.
   *
   * @param contacts The lsit of contacts that use this DietType.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Get the diet type.
   *
   * @return The diet type.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Set the type of diet.
   *
   * @param dietType The type of diet.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Get the ID of the DietType.
   *
   * @return The ID of the DietType.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the ID of the DietType.
   *
   * @param id The ID of the DietType.
   */
  public void setId(long id) {
    this.id = id;
  }
}
