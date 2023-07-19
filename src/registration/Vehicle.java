package registration;

import java.util.Objects;

/**
 * Vehicle class.
 */
public class Vehicle implements IVehicle {
  private String make;
  private int productionYear;
  private double purchasePrice;
  private VehicleType kind;

  /**
   * Vehicle constructor.
   * @param kind vehicle kind
   * @param make vehicle make
   * @param productionYear vehicle production year
   * @param purchasePrice vehicle purchase price
   */
  public Vehicle(String kind, String make, int productionYear, double purchasePrice) {
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
    this.kind = VehicleType.valueOf(kind.toUpperCase());
  }

  /**
   * Getter for make.
   * @return make
   */
  @Override
  public String getMake() {
    return this.make;
  }

  /**
   * Getter for production year.
   * @return production year
   */
  @Override
  public int getProductionYear() {
    return this.productionYear;
  }

  /**
   * Getter for purchase price.
   * @return purchase price
   */
  @Override
  public double getPurchasePrice() {
    return this.purchasePrice;
  }

  /**
   * Getter for vehicle type.
   * @return vehicle type
   */
  @Override
  public VehicleType getVehicleType() {
    return this.kind;
  }

  /**
   * Getter for max passengers.
   * @return max passengers
   */
  @Override
  public int getPassengers() {
    return this.kind.getValue();
  }

  /**
   * Equals method.
   * @param o other object
   * @return equal or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vehicle vehicle = (Vehicle) o;
    return productionYear == vehicle.productionYear
            && Double.compare(vehicle.purchasePrice, purchasePrice) == 0
            && make.equals(vehicle.make) && kind == vehicle.kind;
  }

  /**
   * HashCode.
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(make, productionYear, purchasePrice, kind);
  }
}