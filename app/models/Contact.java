package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Contains the information for one contact.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
@Entity
public class Contact extends play.db.ebean.Model {
  @Id
  private long id;

  private String firstName;

  private String lastName;

  private String phone;

  @ManyToOne(cascade= CascadeType.PERSIST)
  private PhoneType phoneType;

  @ManyToMany(cascade=CascadeType.PERSIST)
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
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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
   * Set the contact's ID number.
   *
   * @param id The contact's ID number.
   */
  public void setId(long id) {
    this.id = id;
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
   * Set the contact's first name.
   *
   * @param firstName The contact's first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
   * Set the contact's last name.
   *
   * @param lastName The contact's last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
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
   * Set the contact's phone number.
   *
   * @param phone The contact's phone number.
   */
  public void setPhone(String phone) {
    this.phone = phone;
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
   * Set the contact's type of phone.
   *
   * @param phoneType The contact's type of phone.
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  /**
   * Get the contact's type of diets.
   *
   * @return A list of the contact's diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Set the contact's diet types.
   *
   * @param dietTypes The contact's diet types.
   */
  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

}
