package registration;

/**
 * VehicleType enum.
 */
public enum VehicleType {
  MOTORCYCLE(2), AUTO(5), BOAT(10);

  private int value;

  /**
   * Constructor.
   * @param value value of vehicle type
   */
  VehicleType(int value) {
    this.value = value;
  }

  /**
   * Getter for value.
   * @return value
   */
  public int getValue() {
    return this.value;
  }
}
