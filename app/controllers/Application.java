package controllers;

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
    return ok(Home.render(APPLICATION_NAME, "Home"));
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
   * @return An HTTP OK message along with the HTML content for the New Contact page.
   */
  public static Result getNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class);

    return ok(NewContact.render(APPLICATION_NAME, "New Contact", contactForm));
  }


  /**
   * Process an HTTP Post from the New Contact page.
   *
   * @return An HTTP OK message along with the HTML content for the New Contact page.
   */
  public static Result postNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();

    if (contactForm.hasErrors()) {
      Logger.error("Error in newContact page.");
      return badRequest(NewContact.render(APPLICATION_NAME, "New Contact", contactForm));
    }

    ContactFormData contactFormData = contactForm.get();

    Logger.debug("Contact Form Data");
    Logger.debug("  firstName = [" + contactFormData.firstName + "]");
    Logger.debug("  lastName = [" + contactFormData.lastName + "]");
    Logger.debug("  phone = [" + contactFormData.phone + "]");

    return ok(NewContact.render(APPLICATION_NAME, "New Contact", contactForm));
  }
}
