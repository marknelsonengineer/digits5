package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A type of phone.
 */
@Entity
public class PhoneType extends play.db.ebean.Model {
  @Id
  private long id;

  private String phoneType;

  @OneToMany(mappedBy = "phoneType", cascade= CascadeType.PERSIST)
  private List<Contact> contacts;


  /**
   * Construct a new instance of PhoneType.
   *
   * @param phoneType The phone type.
   */
  public PhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  /**
   * Initialize a PhoneType value.  If the value exists, simply return it.  If it does not exist, then
   * add it to the database.
   *
   * @param inPhoneType The PhoneType to initialize.
   * @return A database-backed PhoneType object.
   */
  public static PhoneType init(String inPhoneType) {
    PhoneType phoneType = getPhoneType(inPhoneType);

    if (phoneType == null) {
      phoneType = new PhoneType(inPhoneType);
      phoneType.save();
    }

    return getPhoneType(inPhoneType);
  }

  /**
   * Get a PhoneType object from the phoneTypes database.
   *
   * @param phoneType The type of phone to get.
   * @return A PhoneType object.
   */
  public static PhoneType getPhoneType(String phoneType) {
    return PhoneType.find().where().eq("phoneType", phoneType).findUnique();
  }


  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, PhoneType> find() {
    return new Finder<Long, PhoneType>(Long.class, PhoneType.class);
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
