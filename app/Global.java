import models.ContactsDb;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import views.formdata.ContactFormData;

/**
 * The Global object for the Digits web application.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);
    Logger.info("Digits has started");

    ContactFormData cfd1 = new ContactFormData();
    cfd1.firstName = "Sam";
    cfd1.lastName = "Nelson";
    cfd1.phone = "+1 (808) 555-1111";
    cfd1.phoneType = "Mobile";
    ContactsDb.createContactFromForm(cfd1);

    ContactFormData cfd2 = new ContactFormData();
    cfd2.firstName = "Joe";
    cfd2.lastName = "Schmoe";
    cfd2.phone = "+1 (808) 555-2222";
    cfd2.phoneType = "Home";
    ContactsDb.createContactFromForm(cfd2);

    ContactFormData cfd3 = new ContactFormData();
    cfd3.firstName = "Jane";
    cfd3.lastName = "Doe";
    cfd3.phone = "+1 (808) 555-3333";
    cfd3.phoneType = "Work";
    ContactsDb.createContactFromForm(cfd3);
  }
}
