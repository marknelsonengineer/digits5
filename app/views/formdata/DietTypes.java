package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for managing DietTypes.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class DietTypes {

  /**
   * Get a Map object populated with all of the valid diet types.  None of the diet types are set to active.
   *
   * @return A Map of the populated diet types.
   */
  public static Map<String, Boolean> getDietTypes() {
    Map<String, Boolean> dietTypes = new HashMap<String, Boolean>();

    dietTypes.put("Dairy", false);
    dietTypes.put("Fish", false);
    dietTypes.put("Chicken", false);
    dietTypes.put("Beef", false);
    dietTypes.put("Gluten", false);

    return dietTypes;
  }

  /**
   * Get a Map object of the diet types.  The passed in diet types are selected (the boolean is set to true).  All
   * other diet types are not selected (the booleans are set to false).
   *
   * @param types The diet types to set in the Map.
   * @return A Map of the diet types with type selected.
   */
  public static Map<String, Boolean> getDietTypes(List<String> types) {
    Map<String, Boolean> dietTypes = getDietTypes();

    if (types == null) {
      return dietTypes;
    }

    for (String type : types) {
      if (!isType(type)) {
        throw new IllegalAccessError("The requested diet type [" + type + "] is not a valid type.");
      }

      dietTypes.put(type, true);
    }

    return dietTypes;
  }

  /**
   * Return true if the passed in type is an allowed type of diet.
   *
   * @param type The type of diet to test.
   * @return True if the diet is allowed.  False if it is not allowed.
   */
  public static boolean isType(String type) {
    Map<String, Boolean> dietTypes = getDietTypes();

    if (type == null) {
      return false;
    }

    return dietTypes.containsKey(type);
  }

  /**
   * Return true if the passed in types list contains all valid types.  Return false if the list contains any invalid
   * types.  This should return true on an empty list.  This should thrown an exception if the types parameter
   * is null.
   *
   * @param types A list of diet types to check.
   * @return True if types contain a valid list.  False if anything hinkey is passed in.
   */
  public static boolean areTypes(List<String> types) {
    Map<String, Boolean> dietTypes = getDietTypes();

    for (String type : types) {
      if (!isType(type)) {
        return false;
      }
    }

    return true;
  }
}
