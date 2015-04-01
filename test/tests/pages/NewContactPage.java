package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the NewContact page.
 *
 * @author Mark Nelson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the NewContact Page.
   *
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newContact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits");
    assertThat(pageSource().contains("New Contact"));
  }

  /**
   * Set passed values into the form, then submit it.
   *
   * @param firstName A contact's first name.
   * @param lastName A contact's last name.
   * @param phone A contact's phone number.
   * @param phoneType A contact's type of phone.
   */
  public void submitForm(String firstName, String lastName, String phone, String phoneType) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#phone").with(phone);
    fill("#phoneType").with(phoneType);

    submit("#submit");
  }
}

