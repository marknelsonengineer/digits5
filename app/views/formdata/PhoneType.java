package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for managing PhoneType.
 *
 * @author Mark Nelson
 * @see http://www.playframework.com
 */
public class PhoneType {

  /**
   * Get a Map object populated with all of the valid phone types.  None of the phone types are set to active.
   *
   * @return A Map of the populated phone types.
   */
  public static Map<String, Boolean> getPhoneTypes() {
    Map<String, Boolean> phoneTypes = new HashMap<String, Boolean>();

    phoneTypes.put("Mobile", false);
    phoneTypes.put("Home", false);
    phoneTypes.put("Work", false);

    return phoneTypes;
  }

  /**
   * Get a Map object of the phone types.  The passed in phone type is selected (the boolean is set to true).  All
   * other phone types are not selected (the booleans are set to false).
   *
   * @param type The phone type to set in the Map.
   * @return A Map of the phone types with type selected.
   */
  public static Map<String, Boolean> getPhoneTypes(String type) {
    Map<String, Boolean> phoneTypes = getPhoneTypes();

    if (!isType(type)) {
      throw new IllegalAccessError("The requested phone type [" + type + "] is not a valid type.");
    }

    phoneTypes.put(type, true);

    return phoneTypes;
  }

  /**
   * Return true if the passed in type is an allowed type of phone.
   *
   * @param type The type of phone to test.
   * @return True if the phone is allowed.  False if it is not allowed.
   */
  public static boolean isType(String type) {
    Map<String, Boolean> phoneTypes = getPhoneTypes();

    if (type == null) {
      return false;
    }

    return phoneTypes.containsKey(type);
  }
}
