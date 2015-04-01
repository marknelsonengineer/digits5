package test;

import models.ContactsDb;
import org.junit.Test;
import play.twirl.api.Content;

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
}
