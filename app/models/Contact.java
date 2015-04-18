package models;

import java.util.List;

/**
 * Contains the information for one contact.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class Contact {
  private long id;
  private String firstName;
  private String lastName;
  private String phone;
  private PhoneType phoneType;
  private List<DietType> dietTypes;

  /**
   * Create a new contact from parameterized values.
   *
   * @param id        A synthetic, unique ID number for the contact.
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param phone     The phone number.
   * @param phoneType The type of phone.
   * @param dietTypes The types of diet.
   */
  public Contact(
      long id,
      String firstName,
      String lastName,
      String phone,
      PhoneType phoneType,
      List<DietType> dietTypes) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.phoneType = phoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Get the contact's id number.
   *
   * @return The contact's id number.
   */
  public long getId() {
    return id;
  }

  /**
   * Get the contact's first name.
   *
   * @return The contact's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the contact's last name.
   *
   * @return The contact's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the contact's phone number.
   *
   * @return The contact's phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Get the contact's type of phone.
   *
   * @return The contact's type of phone.
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  /**
   * Get the contact's type of diets.
   *
   * @return A list of the contact's diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }
}
