package registration;

/**
 * IVehicle interface.
 */
public interface IVehicle {
  /**
   * Getter for vehicle make.
   * @return make
   */
  String getMake();

  /**
   * Getter for production year.
   * @return production year
   */
  int getProductionYear();

  /**
   * Getter for purchase price.
   * @return purchase price
   */
  double getPurchasePrice();

  /**
   * Getter for vehicle type.
   * @return vehicle type
   */
  VehicleType getVehicleType();

  /**
   * Getter for max passengers of vehicle.
   * @return max passengers
   */
  int getPassengers();
}
