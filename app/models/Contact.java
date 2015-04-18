package models;

import views.formdata.ContactFormData;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the information for one contact and persists it in a database.
 *
 * @see http://www.playframework.com
 */
@Entity
public class Contact extends play.db.ebean.Model {
  @Id
  private long id;

  private String firstName;

  private String lastName;

  private String phone;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private PhoneType phoneType;

  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;


  /**
   * Create a new contact from parameterized values.
   *
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param phone     The phone number.
   * @param phoneType The type of phone.
   * @param dietTypes The types of diet.
   */
  public Contact(
      String firstName,
      String lastName,
      String phone,
      PhoneType phoneType,
      List<DietType> dietTypes) {
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
   * Create a new contact object from ContactFormData, add it to the database and return the newly created contact.
   *
   * @param contactFormData The source of the data for the contact.
   * @return A fully populated contact object that's just been persisted in the database.
   */
  public static Contact createContactFromForm(ContactFormData contactFormData) {
    Contact contact = null;
    PhoneType phoneType = PhoneType.getPhoneType(contactFormData.phoneType);
    List<DietType> dietTypes = new ArrayList<DietType>();

    for (String formDietType : contactFormData.dietTypes) {
      dietTypes.add(DietType.getDietType(formDietType));
    }

    if (contactFormData.id == 0) {
      contact = new Contact(
          contactFormData.firstName,
          contactFormData.lastName,
          contactFormData.phone,
          phoneType,
          dietTypes
      );
    }
    else {
      contact = Contact.find().byId(contactFormData.id);

      contact.setFirstName(contactFormData.firstName);
      contact.setLastName(contactFormData.lastName);
      contact.setPhone(contactFormData.phone);
      contact.setPhoneType(phoneType);
      contact.setDietTypes(dietTypes);
    }

    contact.save();
    return contact;
  }

  /**
   * Initialize the database with data.  If the data is not present, then add it to the database.
   *
   * @param contactFormData A seed contact for the database.
   */
  public static void init(ContactFormData contactFormData) {
    Contact contact = Contact.find().where()
        .eq("firstName", contactFormData.firstName)
        .eq("lastName", contactFormData.lastName)
        .eq("phone", contactFormData.phone)
        .findUnique();

    if (contact == null) {
      createContactFromForm(contactFormData);
    }
  }


  /**
   * List of all of the contacts in the application.
   *
   * @return A list of all of the contacts.
   */
  public static List<Contact> getContacts() {
    return Contact.find().all();
  }


  /**
   * Get a contact from the database.
   *
   * @param id The ID of the contact to get.
   * @return A contact from the database.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);

    if (contact == null) {
      throw new ArrayIndexOutOfBoundsException("The contact id [" + id + "] does not exist in the database.");
    }

    return contact;
  }


  /**
   * Delete a contact from the database.
   *
   * @param id A contact ID from the database to delete.
   */
  public static void deleteContact(long id) {
    Contact contact = Contact.find().byId(id);

    if (contact == null) {
      throw new ArrayIndexOutOfBoundsException("The contact id [" + id + "] does not exist in the database.");
    }

    contact.getDietTypes().clear();
    contact.save();
    contact.delete();
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
