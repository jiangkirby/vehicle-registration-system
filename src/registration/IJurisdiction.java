package registration;

/**
 * IJurisdiction interface.
 */
public interface IJurisdiction {
  /**
   * Calculates tax for vehicle.
   * @param vehicle vehicle to calculate tax for
   * @return tax
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}