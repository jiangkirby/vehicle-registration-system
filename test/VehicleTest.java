import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import registration.IVehicle;
import registration.Vehicle;
import registration.VehicleType;

/**
 * VehicleTest class.
 */
public class VehicleTest {
  private IVehicle motorcycle;
  private IVehicle auto;
  private IVehicle boat;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    motorcycle = new Vehicle("Motorcycle", "Harley Davidson", 1990, 12000.00);
    auto = new Vehicle("Auto", "Kia", 2020, 23500.00);
    boat = new Vehicle("Boat", "Skidoo", 2000, 12500.00);
  }

  /**
   * Tests all getters for a motorcycle vehicle.
   */
  @Test
  public void testFirst() {
    assertEquals("Harley Davidson", motorcycle.getMake());
    assertEquals(1990, motorcycle.getProductionYear());
    assertEquals(12000.00, motorcycle.getPurchasePrice(), 0);
    assertEquals(VehicleType.MOTORCYCLE, motorcycle.getVehicleType());
    assertEquals(2, motorcycle.getPassengers());
  }

  /**
   * Tests all getters for an auto vehicle.
   */
  @Test
  public void testSecond() {
    assertEquals("Kia", auto.getMake());
    assertEquals(2020, auto.getProductionYear());
    assertEquals(23500.00, auto.getPurchasePrice(), 0);
    assertEquals(VehicleType.AUTO, auto.getVehicleType());
    assertEquals(5, auto.getPassengers());
  }

  /**
   * Tests all getters for a boat vehicle.
   */
  @Test
  public void testThird() {
    assertEquals("Skidoo", boat.getMake());
    assertEquals(2000, boat.getProductionYear());
    assertEquals(12500.00, boat.getPurchasePrice(), 0);
    assertEquals(VehicleType.BOAT, boat.getVehicleType());
    assertEquals(10, boat.getPassengers());
  }

  /**
   * Tests equals method.
   */
  @Test
  public void testFourth() {
    IVehicle motorcycle2 = new Vehicle("Motorcycle", "Harley Davidson", 1990, 12000.00);
    IVehicle motorcycle3 = new Vehicle("Motorcycle", "Harley Davidson", 2000, 12000.00);
    assertTrue(motorcycle.equals(motorcycle2));
    assertFalse(motorcycle.equals(motorcycle3));
  }
}
