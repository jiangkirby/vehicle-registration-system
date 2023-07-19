package registration;

/**
 * BlueJurisdiction class.
 */
public class BlueJurisdiction implements IJurisdiction {
  private static final int year = 2000;
  private static final double tax = 0.03;
  private static final int oldVehicleTax = 99;

  /**
   * Calculates tax for vehicle.
   * @param vehicle vehicle to calculate tax for
   * @return tax
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    if (vehicle.getProductionYear() < year) {
      return vehicle.getPurchasePrice() * tax + oldVehicleTax;
    }
    return vehicle.getPurchasePrice() * tax;
  }

  /**
   * ToString.
   * @return string
   */
  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}
