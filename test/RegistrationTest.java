import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import registration.Vehicle;

/**
 * RegistrationTest class.
 */
public class RegistrationTest {
  private IRegistration registration1;
  private IVehicle motorcycle;
  private List<Person> owners;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    Person flash = new Person("The Flash", "Central City");
    Person arrow = new Person("Green Arrow", "Star City");
    owners = new ArrayList<>();
    owners.add(flash);
    owners.add(arrow);
    motorcycle = new Vehicle("Motorcycle", "Harley Davidson", 1990, 12000.00);
  }

  /**
   * Tests all getters.
   */
  @Test
  public void testFirst() {
    registration1 = new Registration(motorcycle, new BlueJurisdiction(), 2000, owners);
    assertEquals(2000, registration1.getRegistrationYear());
    assertEquals(1990, registration1.getProductionYear());
    assertEquals("Blue Jurisdiction", registration1.getJurisdiction().toString());
    assertEquals("[The Flash, Central City, Green Arrow, Star City]",
            registration1.getOwners().toString());
    assertEquals(2, registration1.getMaxPassengers());
  }

  /**
   * Tests all tax possibilities from the blue jurisdiction.
   */
  @Test
  public void testSecond() {
    registration1 = new Registration(motorcycle, new BlueJurisdiction(), 2000, owners);
    assertEquals(459.0, registration1.calculateExciseTax(), 0);
    IVehicle motorcycle2 = new Vehicle("Motorcycle",
            "Harley Davidson", 2010, 12000.00);
    registration1 = new Registration(motorcycle2, new BlueJurisdiction(), 2000, owners);
    assertEquals(360.0, registration1.calculateExciseTax(), 0);
  }

  /**
   * Tests all tax possibilities from the red jurisdiction.
   */
  @Test
  public void testThird() {
    registration1 = new Registration(motorcycle, new RedJurisdiction(), 2000, owners);
    assertEquals(600.0, registration1.calculateExciseTax(), 0);
  }

  /**
   * Tests all tax possibilities from the green jurisdiction.
   */
  @Test
  public void testFourth() {
    registration1 = new Registration(motorcycle, new GreenJurisdiction(), 2000, owners);
    assertEquals(680.0, registration1.calculateExciseTax(), 0);
    IVehicle auto = new Vehicle("Auto", "Kia", 2020, 12000.00);
    registration1 = new Registration(auto, new GreenJurisdiction(), 2000, owners);
    assertEquals(980.0, registration1.calculateExciseTax(), 0);
    IVehicle boat = new Vehicle("Boat", "Skidoo", 2000, 12000.00);
    registration1 = new Registration(boat, new GreenJurisdiction(), 2000, owners);
    assertEquals(1480.0, registration1.calculateExciseTax(), 0);
  }

  /**
   * Tests toString method.
   */
  @Test
  public void testFifth() {
    registration1 = new Registration(motorcycle, new GreenJurisdiction(), 2000, owners);
    assertEquals("Registration:\n"
            + "MOTORCYCLE: Harley Davidson Year(1990) Price = $12000.00\n"
            + "Owned By: The Flash, Central City; Green Arrow, Star City\n"
            + "Year: 2000\n"
            + "Excise Tax: $680.00", registration1.toString());
  }

  /**
   * Tests equals override method. Should still be equal even if jurisdictions are different, to
   * catch duplicate registrations in the system if needed.
   */
  @Test
  public void testSixth() {
    registration1 = new Registration(motorcycle, new GreenJurisdiction(), 2000, owners);
    assertTrue(registration1.equals(registration1));
    IRegistration registration2 = new Registration(motorcycle,
            new RedJurisdiction(), 2000, owners);
    IRegistration registration3 = new Registration(motorcycle,
            new BlueJurisdiction(), 2000, owners);
    assertTrue(registration1.equals(registration2));
    assertTrue(registration1.equals(registration3));
    IRegistration registration4 = new Registration(motorcycle,
            new GreenJurisdiction(), 2020, owners);
    assertFalse(registration1.equals(registration4));
  }
}
