package tests;

import models.PhoneType;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Test the PhoneType model class.
 */
public class PhoneTypeTest {

  /**
   * Exercise the CRUD of the PhoneType model class.
   */
  @Test
  public void testPhoneType() {
    running(fakeApplication(inMemoryDatabase()), new Runnable() {
      public void run() {
        PhoneType phoneType;

        List<PhoneType> phoneTypes = PhoneType.find().all();
        assertThat(phoneTypes.size()).isGreaterThanOrEqualTo(3);

        phoneType = PhoneType.find().where().eq("phoneType", "Mobile").findUnique();
        assertThat(phoneType).isNotNull();

        phoneType = PhoneType.find().where().eq("phoneType", "Home").findUnique();
        assertThat(phoneType).isNotNull();

        phoneType = PhoneType.find().where().eq("phoneType", "Work").findUnique();
        assertThat(phoneType).isNotNull();

        String testPhoneType = "XX Test Phone Type 01";
        phoneType = PhoneType.init(testPhoneType);

        phoneType = PhoneType.find().where().eq("phoneType", testPhoneType).findUnique();
        assertThat(phoneType).isNotNull();

        phoneType.delete();

        phoneType = PhoneType.find().where().eq("phoneType", testPhoneType).findUnique();
        assertThat(phoneType).isNull();
      }
    });

  }
}
