package registration;

/**
 * CreateVehicleHelper class.
 */
public class CreateVehicleHelper {
  /**
   * Checks if vehicle is valid.
   * @param kind vehicle type
   * @param make make of vehicle
   * @param productionYear production year of vehicle
   * @param purchasePrice purchase price of vehicle
   * @return boolean for if vehicle is valid
   * @throws IllegalArgumentException if some parameters are illegal
   */
  public static boolean isValidVehicle(String kind, String make,
                                       int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    if (kind == null || kind.isBlank()) {
      throw new IllegalArgumentException("Kind is invalid");
    }
    if (make == null || make.isBlank()) {
      throw new IllegalArgumentException("Make is invalid");
    }
    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Production year is invalid");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Purchase price is invalid");
    }
    for (VehicleType type : VehicleType.values()) {
      if (type.name().equalsIgnoreCase(kind)) return true;
    }
    return false;
  }
}
