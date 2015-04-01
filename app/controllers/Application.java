package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.About;
import views.html.Home;

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
  public static Result home() {
    return ok(Home.render(APPLICATION_NAME, "Home"));
  }

  /**
   * Render the About page.
   *
   * @return An HTTP OK message along with the HTML content for the About page.
   */
  public static Result about() {
    return ok(About.render(APPLICATION_NAME, "About"));
  }

}
