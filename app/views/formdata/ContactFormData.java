package views.formdata;

/**
 * Container for holding data to/from the NewContact HTML form.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class ContactFormData {
  /** The contact's first name. */
  public String firstName = "";

  /** The contact's last name. */
  public String lastName = "";

  /** The contact's phone number. */
  public String phone = "";


  /**
   * The Play framework requires an empty constructor.
   */
  public ContactFormData() {
    // No-argument constructor as required by Play.
  }

}
