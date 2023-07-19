package registration;

/**
 * GreenJurisdiction class.
 */
public class GreenJurisdiction implements IJurisdiction {
  private static final double tax = 0.04;
  private static final int passengerTax = 100;

  /**
   * Calculates tax for vehicle.
   * @param vehicle vehicle to calculate tax for
   * @return tax
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    return (vehicle.getPurchasePrice() * tax) + (vehicle.getPassengers() * passengerTax);
  }

  /**
   * ToString.
   * @return string
   */
  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}
