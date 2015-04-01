package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides test scaffolding for the Home page.
 *
 * @author Mark Nelson
 */
public class HomePage extends FluentPage {
  private String url;

  /**
   * Create the HomePage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public HomePage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits");
    assertThat(pageSource().contains("Current Contacts"));
  }

}
