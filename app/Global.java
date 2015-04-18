import models.ContactsDb;
import models.DietType;
import models.PhoneType;
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
    Logger.info(controllers.Application.APPLICATION_NAME + " has started");

    PhoneType.init("Mobile");
    PhoneType.init("Home");
    PhoneType.init("Work");

    DietType.init("Chicken");
    DietType.init("Fish");
    DietType.init("Beef");
    DietType.init("Dairy");
    DietType.init("Gluten");

    ContactFormData cfd1 = new ContactFormData();
    cfd1.firstName = "Sam";
    cfd1.lastName = "Nelson";
    cfd1.phone = "+1 (808) 555-1111";
    cfd1.phoneType = "Mobile";
    cfd1.dietTypes.add("Dairy");
    ContactsDb.createContactFromForm(cfd1);

    ContactFormData cfd2 = new ContactFormData();
    cfd2.firstName = "Joe";
    cfd2.lastName = "Schmoe";
    cfd2.phone = "+1 (808) 555-2222";
    cfd2.phoneType = "Home";
    cfd2.dietTypes.add("Fish");
    cfd2.dietTypes.add("Beef");
    ContactsDb.createContactFromForm(cfd2);

    ContactFormData cfd3 = new ContactFormData();
    cfd3.firstName = "Jane";
    cfd3.lastName = "Doe";
    cfd3.phone = "+1 (808) 555-3333";
    cfd3.phoneType = "Work";
    cfd3.dietTypes.add("Dairy");
    cfd3.dietTypes.add("Fish");
    cfd3.dietTypes.add("Chicken");
    cfd3.dietTypes.add("Beef");
    cfd3.dietTypes.add("Gluten");
    ContactsDb.createContactFromForm(cfd3);
  }
}
