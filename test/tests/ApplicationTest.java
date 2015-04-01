package tests;

import models.ContactsDb;
import org.junit.Test;
import play.twirl.api.Content;
import views.formdata.PhoneType;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

/**
 * JUnit tests that exercise any part of the application.
 */
public class ApplicationTest {

  /**
   * Basic Junit test to validate JUnit functionality.
   */
  @Test
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }

  /**
   * Ensure the Home page renders.
   */
  @Test
  public void renderHomePage() {
    Content html = views.html.Home.render("Digits", "Home", ContactsDb.getContacts());
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("Current Contacts");
  }

  /**
   * Exercise the PhoneTypes utility class.
   */
  @Test
  public void testPhoneTypes() {
    Map<String, Boolean> phoneTypes = PhoneType.getPhoneTypes();
    assertThat(phoneTypes.get("Home")).isFalse();
    assertThat(phoneTypes.get("Work")).isFalse();
    assertThat(phoneTypes.get("Mobile")).isFalse();

    assertThat(PhoneType.isType("Home")).isTrue();
    assertThat(PhoneType.isType("Work")).isTrue();
    assertThat(PhoneType.isType("Mobile")).isTrue();

    assertThat(PhoneType.isType(null)).isFalse();
    assertThat(PhoneType.isType("")).isFalse();
    assertThat(PhoneType.isType(" ")).isFalse();
    assertThat(PhoneType.isType("  ")).isFalse();
    assertThat(PhoneType.isType(" Mobile")).isFalse();
    assertThat(PhoneType.isType("Mobile ")).isFalse();
    assertThat(PhoneType.isType("XMobile")).isFalse();
    assertThat(PhoneType.isType("MobileX")).isFalse();
    assertThat(PhoneType.isType("XXMobileXX")).isFalse();

    phoneTypes = PhoneType.getPhoneTypes("Mobile");
    assertThat(phoneTypes.get("Home")).isFalse();
    assertThat(phoneTypes.get("Work")).isFalse();
    assertThat(phoneTypes.get("Mobile")).isTrue();
  }
}
