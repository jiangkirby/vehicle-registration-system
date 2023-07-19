package registration;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

/**
 * Registration class.
 */
public class Registration implements IRegistration {
  private IVehicle vehicle;
  private IJurisdiction jurisdiction;
  private int registrationYear;
  private List<Person> owners;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Registration constructor.
   * @param vehicle vehicle to register
   * @param jurisdiction juridiction to register in
   * @param registrationYear registration year
   * @param owners owners of vehicle
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction,
                      int registrationYear, List<Person> owners) {
    this.vehicle = vehicle;
    this.jurisdiction = jurisdiction;
    this.registrationYear = registrationYear;
    this.owners = owners;
  }

  /**
   * Getter for registration year.
   * @return registration year
   */
  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }

  /**
   * Getter for production year.
   * @return production year
   */
  @Override
  public int getProductionYear() {
    return this.vehicle.getProductionYear();
  }

  /**
   * Getter for jurisdiction.
   * @return jurisdiction
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  /**
   * Getter for owners.
   * @return owners
   */
  @Override
  public List<Person> getOwners() {
    return this.owners;
  }

  /**
   * Getter for max passengers.
   * @return max passengers
   */
  @Override
  public int getMaxPassengers() {
    return this.vehicle.getPassengers();
  }

  /**
   * Calculates excise tax based on jurisdiction registration is in.
   * @return excise tax
   */
  @Override
  public double calculateExciseTax() {
    return this.jurisdiction.exciseTax(this.vehicle);
  }

  /**
   * ToString method.
   * @return string
   */
  @Override
  public String toString() {
    String allOwners = "";
    for (Person p : this.owners) {
      allOwners += p.getName() + ", " + p.getAddress() + "; ";
    }
    return "Registration:\n"
            + this.vehicle.getVehicleType().name() + ": " + this.vehicle.getMake()
            + " Year(" + this.vehicle.getProductionYear()
            + ") Price = $" + df.format(this.vehicle.getPurchasePrice())
            + "\nOwned By: " + allOwners.substring(0, allOwners.length() - 2)
            + "\nYear: " + this.registrationYear
            + "\nExcise Tax: $" + df.format(this.jurisdiction.exciseTax(this.vehicle));
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
    Registration that = (Registration) o;
    return registrationYear == that.registrationYear && vehicle.equals(that.vehicle)
            && owners.equals(that.owners);
  }

  /**
   * HashCode.
   * @return hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicle, registrationYear, owners);
  }
}
