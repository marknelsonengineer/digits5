package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * The types of diets a Contact likes.
 */
@Entity
public class DietType extends play.db.ebean.Model {
  @Id
  private long id;

  private String dietType;

  @ManyToMany(mappedBy = "dietTypes", cascade= CascadeType.PERSIST)
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
   * Get a DietType object from the dietTypes database.
   *
   * @param dietType The type of diet to get.
   * @return A DietType object.
   */
  public static DietType getDietType(String dietType) {
    return DietType.find().where().eq("dietType", dietType).findUnique();
  }


  /**
   * Initialize a DietType value.  If the value exists, simply return it.  If it does not exist, then
   * add it to the database.
   *
   * @param inDietType The DietType to initialize.
   * @return A database-backed DietType object.
   */
  public static DietType init(String inDietType) {
    DietType dietType = getDietType(inDietType);

    if (dietType == null) {
      dietType = new DietType(inDietType);
      dietType.save();
    }

    return getDietType(inDietType);
  }


  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method.
   */
  public static Finder<Long, DietType> find() {
    return new Finder<Long, DietType>(Long.class, DietType.class);
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
