import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;
import registration.RegistrationSystem;
import registration.Vehicle;

/**
 * RegistrationSystemTest class.
 */
public class RegistrationSystemTest {
  private RegistrationSystem registrations;
  private List<Person> owners;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    registrations = RegistrationSystem.getInstance();
    Person flash = new Person("The Flash", "Central City");
    Person arrow = new Person("Green Arrow", "Star City");
    owners = new ArrayList<>();
    owners.add(flash);
    owners.add(arrow);
  }

  /**
   * Tests createVehicle method.
   */
  @Test
  public void testFirst() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    assertTrue(auto instanceof IVehicle);
    assertTrue(auto instanceof Vehicle);
    IVehicle auto2 = new Vehicle("auto", "BMW", 2016, 30000);
    assertTrue(auto.equals(auto2));
  }

  /**
   * Tests createVehicle with empty String for kind.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond1() {
    registrations.createVehicle("", "BMW", 2016, 30000);
  }

  /**
   * Tests createVehicle with null for kind.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond2() {
    registrations.createVehicle(null, "BMW", 2016, 30000);
  }

  /**
   * Tests createVehicle with empty String for make.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond3() {
    registrations.createVehicle("auto", "", 2016, 30000);
  }

  /**
   * Tests createVehicle with null for make.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond4() {
    registrations.createVehicle("auto", null, 2016, 30000);
  }

  /**
   * Tests createVehicle with productionYear value less than 1900.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond5() {
    registrations.createVehicle("auto", "BMW", 1899, 30000);
  }

  /**
   * Tests createVehicle with productionYear value greater than 2023.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond6() {
    registrations.createVehicle("auto", "BMW", 2024, 30000);
  }

  /**
   * Tests createVehicle with negative purchasePrice.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond7() {
    registrations.createVehicle("auto", "BMW", 2016, -1);
  }

  /**
   * Tests createVehicle with vehicle kind that's not in VehicleTypes.
   */
  @Test
  public void testSecond8() {
    IVehicle truck = registrations.createVehicle("Truck", "BMW", 2016, 30000);
    assertEquals(null, truck);
  }

  /**
   * Tests register method and getAllRegistrations method.
   */
  @Test
  public void testThird() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    IVehicle auto2 = registrations.createVehicle("auto", "BMW", 2017, 35000);
    IVehicle auto3 = registrations.createVehicle("auto", "BMW", 2018, 40000);
    registrations.register(auto, new BlueJurisdiction(), 2016, owners);
    registrations.register(auto2, new RedJurisdiction(), 2017, owners);
    registrations.register(auto3, new GreenJurisdiction(), 2018, owners);
    IRegistration registration1 = new Registration(auto, new BlueJurisdiction(), 2016, owners);
    IRegistration registration2 = new Registration(auto2, new RedJurisdiction(), 2017, owners);
    IRegistration registration3 = new Registration(auto3, new GreenJurisdiction(), 2018, owners);
    assertEquals(registration1, registrations.getAllRegistrations().get(0));
    assertEquals(registration2, registrations.getAllRegistrations().get(1));
    assertEquals(registration3, registrations.getAllRegistrations().get(2));
    registrations.reboot();
  }

  /**
   * Tests registering the same vehicle, but in different jurisdictions.
   */
  @Test
  public void testFourth() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    registrations.register(auto, new BlueJurisdiction(), 2016, owners);
    registrations.register(auto, new RedJurisdiction(), 2016, owners);
    registrations.register(auto, new GreenJurisdiction(), 2016, owners);
    assertEquals(1, registrations.getAllRegistrations().size());
    registrations.reboot();
  }

  /**
   * Tests registering the same vehicle, but with different registrationYear.
   */
  @Test
  public void testFifth() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    registrations.register(auto, new BlueJurisdiction(), 2016, owners);
    registrations.register(auto, new BlueJurisdiction(), 2017, owners);
    assertEquals(2, registrations.getAllRegistrations().size());
    registrations.reboot();
  }

  /**
   * Tests getFilteredList method.
   */
  @Test
  public void testSixth() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    registrations.register(auto, new BlueJurisdiction(), 2016, owners);
    registrations.register(auto, new BlueJurisdiction(), 2017, owners);
    registrations.register(auto, new BlueJurisdiction(), 2018, owners);
    assertEquals(2, registrations
            .getFilteredList(registration -> registration.getRegistrationYear() > 2016).size());
    assertEquals(1, registrations
            .getFilteredList(registration -> registration.getRegistrationYear() > 2017).size());
    registrations.reboot();
  }

  /**
   * Tests reboot method.
   */
  @Test
  public void testSeventh() {
    IVehicle auto = registrations.createVehicle("auto", "BMW", 2016, 30000);
    registrations.register(auto, new BlueJurisdiction(), 2015, owners);
    assertEquals(1, registrations.getAllRegistrations().size(), 0);
    registrations.reboot();
    assertEquals(0, registrations.getAllRegistrations().size());
    registrations.reboot();
  }
}
