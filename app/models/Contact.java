package models;

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

  /**
   * Create a new contact from parameterized values.
   *
   * @param id        A synthetic, unique ID number for the contact.
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param phone     The phone number.
   */
  public Contact(long id, String firstName, String lastName, String phone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
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
}
