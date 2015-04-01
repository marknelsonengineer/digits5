package views.formdata;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

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

  /** The minimum number of characters for a valid phone number. */
  public static final int MINIMUM_PHONE_NUMBER_LENGTH = 12;


  /**
   * The Play framework requires an empty constructor.
   */
  public ContactFormData() {
    // No-argument constructor as required by Play.
  }

  /**
   * Perform form (entry) validation on the HTML form before accepting the data into the application.
   *
   * @return If there are no errors, then return null.  If there are errors, return an ArrayLIst with
   *         ValidationError objects.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() <= 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() <= 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (phone == null || phone.length() <= 0) {
      errors.add(new ValidationError("phone", "A phone number is required."));
    }

    if (phone == null || phone.length() < MINIMUM_PHONE_NUMBER_LENGTH) {
      errors.add(new ValidationError("phone", "The phone must be at least "
          + MINIMUM_PHONE_NUMBER_LENGTH + " characters long."));
    }

    return errors.isEmpty() ? null : errors;
  }
}
