package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * The application's MVC Controller class.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class Application extends Controller {

  /**
   * Render an index page.
   *
   * @return An HTTP OK message along with the HTML content for the page.
   */
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

}
