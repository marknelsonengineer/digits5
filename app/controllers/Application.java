package controllers;

import models.Contact;
import models.ContactsDb;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.About;
import views.html.Home;
import views.html.NewContact;

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

    if (id != 0) {
      contactFormData = new ContactFormData(ContactsDb.getContact(id));
    }
    else {
      contactFormData = new ContactFormData();
    }

    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).fill(contactFormData);

    return ok(NewContact.render(APPLICATION_NAME, "New Contact", contactForm));
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

    if (contactForm.hasErrors()) {
      Logger.error("Error in newContact page.");
      Logger.error(contactForm.errors().toString());
      return badRequest(NewContact.render(APPLICATION_NAME, "New Contact", contactForm));
    }

    ContactFormData contactFormData = contactForm.get();

    Logger.debug("Contact Form Data");
    Logger.debug("  id = [" + contactFormData.id + "]");
    Logger.debug("  firstName = [" + contactFormData.firstName + "]");
    Logger.debug("  lastName = [" + contactFormData.lastName + "]");
    Logger.debug("  phone = [" + contactFormData.phone + "]");

    Contact contact = ContactsDb.createContactFromForm(contactFormData);

    Logger.debug("Contact Data");
    Logger.debug("  id = [" + contact.getId() + "]");
    Logger.debug("  firstName = [" + contact.getFirstName() + "]");
    Logger.debug("  lastName = [" + contact.getLastName() + "]");
    Logger.debug("  phone = [" + contact.getPhone() + "]");

    return ok(Home.render(APPLICATION_NAME, "Home", ContactsDb.getContacts()));
  }
}
