package registration;

/**
 * RedJurisdiction class.
 */
public class RedJurisdiction implements IJurisdiction {
  private static final double tax = 0.05;

  /**
   * Calculates tax for vehicle.
   * @param vehicle vehicle to calculate tax for
   * @return tax
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * tax;
  }

  /**
   * ToString.
   * @return string
   */
  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}
