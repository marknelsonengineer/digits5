package test;

import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;


/**
 * Test the live interaction of the web application with a simulated browser.
 */
public class IntegrationTest {

  /**
   * The port number on which to run the tests.
   */
  private static final int TEST_PORT = 3333;


  /**
   * Utilize a test browser to exercise the Home page.
   */
  @Test
  public void testHomePage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new F.Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + TEST_PORT);
        assertThat(browser.pageSource()).contains("Current Contacts");

        browser.goTo("http://localhost:" + TEST_PORT + "/");
        assertThat(browser.pageSource()).contains("Current Contacts");
      }
    });
  }

  /**
   * Utilize a test browser to exercise the New Contact page.
   */
  @Test
  public void testNewContactPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new F.Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + TEST_PORT + "/newContact");
        assertThat(browser.pageSource()).contains("New Contact");
      }
    });
  }

  /**
   * Utilize a test browser to exercise the About page.
   */
  @Test
  public void testAboutPage() {
    running(testServer(TEST_PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new F.Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + TEST_PORT + "/about");
        assertThat(browser.pageSource()).contains("Digits was written by:");
      }
    });
  }

}
