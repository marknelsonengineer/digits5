package controllers;

import models.Contact;
import models.ContactsDb;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.PhoneType;
import views.html.About;
import views.html.Home;
import views.html.NewContact;

import java.util.Map;

/**
 * The application's MVC Controller class.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class Application extends Controller {

  /**
   * The name of the application.
   */
  public static final String APPLICATION_NAME = "Digits";

  /**
   * Render the Home page.
   *
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result getHome() {
    return ok(Home.render(APPLICATION_NAME, "Home", ContactsDb.getContacts()));
  }

  /**
   * Render the About page.
   *
   * @return An HTTP OK message along with the HTML content for the About page.
   */
  public static Result getAbout() {
    return ok(About.render(APPLICATION_NAME, "About"));
  }

  /**
   * Render the New Contact page.
   *
   * @param id The ID of the contact to get.
   * @return An HTTP OK message along with the HTML content for the New Contact page.
   */
  public static Result getNewContact(long id) {
    ContactFormData contactFormData = null;
    Map<String, Boolean> phoneType = null;
    Map<String, Boolean> dietTypes = null;

    if (id != 0) {
      contactFormData = new ContactFormData(ContactsDb.getContact(id));
      phoneType = PhoneType.getPhoneTypes(contactFormData.phoneType);
      dietTypes = DietTypes.getDietTypes(contactFormData.dietTypes);
    }
    else {
      contactFormData = new ContactFormData();
      phoneType = PhoneType.getPhoneTypes();
      dietTypes = DietTypes.getDietTypes();
    }

    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).fill(contactFormData);

    return ok(NewContact.render(APPLICATION_NAME, "New Contact", contactForm, phoneType, dietTypes));
  }

  /**
   * Delete a contact and render the Home page.
   *
   * @param id The contact ID to delete.
   * @return An HTTP OK message along with the HTML content for the Home page.
   */
  public static Result deleteContact(long id) {
    ContactsDb.deleteContact(id);

    return ok(Home.render(APPLICATION_NAME, "Home", ContactsDb.getContacts()));
  }

  /**
   * Process an HTTP Post from the New Contact page.
   *
   * @return An HTTP OK message along with the HTML content for the New Contact page.
   */
  public static Result postNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();

    Logger.debug("Raw Form Data");
    Logger.debug("  id = [" + contactForm.field("id").value() + "]");
    Logger.debug("  firstName = [" + contactForm.field("firstName").value() + "]");
    Logger.debug("  lastName = [" + contactForm.field("lastName").value() + "]");
    Logger.debug("  phone = [" + contactForm.field("phone").value() + "]");
    Logger.debug("  phoneType = [" + contactForm.field("phoneType").value() + "]");

    if (contactForm.hasErrors()) {
      Logger.error("Error in newContact page.");
      Logger.error(contactForm.errors().toString());

      Map<String, Boolean> phoneType = null;
      if (PhoneType.isType(contactForm.field("phoneType").value())) {
        phoneType = PhoneType.getPhoneTypes(contactForm.field("phoneType").value());
      }
      else {
        phoneType = PhoneType.getPhoneTypes();
      }

      Map<String, Boolean> dietTypes = DietTypes.getDietTypes();

      return badRequest(NewContact.render(APPLICATION_NAME, "New Contact", contactForm, phoneType, dietTypes));
    }

    ContactFormData contactFormData = contactForm.get();

    Logger.debug("Contact Form Data");
    Logger.debug("  id = [" + contactFormData.id + "]");
    Logger.debug("  firstName = [" + contactFormData.firstName + "]");
    Logger.debug("  lastName = [" + contactFormData.lastName + "]");
    Logger.debug("  phone = [" + contactFormData.phone + "]");
    Logger.debug("  phoneType = [" + contactFormData.phoneType + "]");

    Contact contact = ContactsDb.createContactFromForm(contactFormData);

    Logger.debug("Contact Data");
    Logger.debug("  id = [" + contact.getId() + "]");
    Logger.debug("  firstName = [" + contact.getFirstName() + "]");
    Logger.debug("  lastName = [" + contact.getLastName() + "]");
    Logger.debug("  phone = [" + contact.getPhone() + "]");
    Logger.debug("  phoneType = [" + contact.getPhoneType() + "]");

    return ok(Home.render(APPLICATION_NAME, "Home", ContactsDb.getContacts()));
  }
}
