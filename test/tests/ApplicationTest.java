package tests;

import org.junit.Test;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.PhoneType;

import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

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

  /**
   * Exercise the DietTypes utility class.
   */
  @Test
  public void testDietTypes() {
    Map<String, Boolean> dietTypes = DietTypes.getDietTypes();
    assertThat(dietTypes.get("Dairy")).isFalse();
    assertThat(dietTypes.get("Fish")).isFalse();
    assertThat(dietTypes.get("Chicken")).isFalse();
    assertThat(dietTypes.get("Beef")).isFalse();
    assertThat(dietTypes.get("Gluten")).isFalse();

    assertThat(DietTypes.isType("Dairy")).isTrue();
    assertThat(DietTypes.isType("Fish")).isTrue();
    assertThat(DietTypes.isType("Chicken")).isTrue();
    assertThat(DietTypes.isType("Beef")).isTrue();
    assertThat(DietTypes.isType("Gluten")).isTrue();

    assertThat(DietTypes.isType(null)).isFalse();
    assertThat(DietTypes.isType("")).isFalse();
    assertThat(DietTypes.isType(" ")).isFalse();
    assertThat(DietTypes.isType("  ")).isFalse();
    assertThat(DietTypes.isType(" Dairy")).isFalse();
    assertThat(DietTypes.isType("Dairy ")).isFalse();
    assertThat(DietTypes.isType("XDairy ")).isFalse();
    assertThat(DietTypes.isType("DairyX")).isFalse();
    assertThat(DietTypes.isType("XXDairyXX")).isFalse();

    List<String> validDietTypes = new ContactFormData().dietTypes;
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // Test the empty list
    validDietTypes.add("Dairy");
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // One valid value
    validDietTypes.add("Fish");
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // Two valid values
    validDietTypes.add("Chicken");
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // Three valid values
    validDietTypes.add("Beef");
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // Four valid values
    validDietTypes.add("Gluten");
    assertThat(DietTypes.areTypes(validDietTypes)).isTrue();  // A full set of valid values

    List<String> invalidDietTypes1 = new ContactFormData().dietTypes;
    invalidDietTypes1.add("Candy");
    assertThat(DietTypes.areTypes(invalidDietTypes1)).isFalse();  // One invalid value
    invalidDietTypes1.add("Dairy");
    assertThat(DietTypes.areTypes(invalidDietTypes1)).isFalse();  // One valid value
    invalidDietTypes1.add("Soda");
    assertThat(DietTypes.areTypes(invalidDietTypes1)).isFalse();  // One invalid value
    invalidDietTypes1.add("Fish");
    assertThat(DietTypes.areTypes(invalidDietTypes1)).isFalse();  // One valid value

    List<String> invalidDietTypes2 = new ContactFormData().dietTypes;
    invalidDietTypes2.add("Dairy");
    assertThat(DietTypes.areTypes(invalidDietTypes2)).isTrue();   // One valid value
    invalidDietTypes2.add("Soda");
    assertThat(DietTypes.areTypes(invalidDietTypes2)).isFalse();  // One invalid value
    invalidDietTypes2.add("Fish");
    assertThat(DietTypes.areTypes(invalidDietTypes2)).isFalse();  // One valid value
  }
}
