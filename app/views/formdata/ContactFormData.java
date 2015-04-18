package views.formdata;

import models.Contact;
import models.DietType;
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
  /**
   * The minimum number of characters for a valid phone number.
   */
  public static final int MINIMUM_PHONE_NUMBER_LENGTH = 12;

  /**
   * The contact's id number.
   */
  public long id = 0;

  /**
   * The contact's first name.
   */
  public String firstName = "";

  /**
   * The contact's last name.
   */
  public String lastName = "";

  /**
   * The contact's phone number.
   */
  public String phone = "";

  /**
   * The contact's phone type.
   */
  public String phoneType = "";

  /**
   * A list of the contact's diet types.
   */
  public List<String> dietTypes = new ArrayList<String>();

  /**
   * The Play framework requires an empty constructor.
   */
  public ContactFormData() {
    // No-argument constructor as required by Play.
  }

  /**
   * Populate a ContactFormData object from a model Contact.
   *
   * @param contact A contact object from the model.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.phone = contact.getPhone();
    this.phoneType = contact.getPhoneType().getPhoneType();
    for (DietType dietType : contact.getDietTypes()) {
      this.dietTypes.add(dietType.getDietType());
    }
  }

  /**
   * Perform form (entry) validation on the HTML form before accepting the data into the application.
   *
   * @return If there are no errors, then return null.  If there are errors, return an ArrayLIst with
   * ValidationError objects.
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

    if (phoneType == null || !PhoneType.isType(phoneType)) {
      errors.add(new ValidationError("phoneType", "A phone type is required."));
    }

    if (!DietTypes.areTypes(dietTypes)) {
      errors.add(new ValidationError("dietType", "One of the diet types is invalid."));
      // Future:  Show the first invalid diet type or the number of invalid diet types... and a list of valid types.
    }

    return errors.isEmpty() ? null : errors;
  }
}
