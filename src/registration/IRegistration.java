package registration;

import java.util.List;

/**
 * IRegistration interface.
 */
public interface IRegistration {
  /**
   * Getter for registration year.
   * @return registration year
   */
  public int getRegistrationYear();

  /**
   * Getter for production year.
   * @return production year
   */
  public int getProductionYear();

  /**
   * Getter for jurisdiction.
   * @return jurisdiction
   */
  public IJurisdiction getJurisdiction();

  /**
   * Getter for owners.
   * @return owners
   */
  public List<Person> getOwners();

  /**
   * Getter for max passengers based on vehicle type.
   * @return max passengers
   */
  public int getMaxPassengers();

  /**
   * Calculates excise tax based on jurisdiction registration is in.
   * @return excise tax
   */
  public double calculateExciseTax();
}