package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * RegistrationSystem class.
 */
public class RegistrationSystem {
  private static final RegistrationSystem INSTANCE = new RegistrationSystem();
  private List<IRegistration> registrations = new ArrayList<>();

  /**
   * Private constructor.
   */
  private RegistrationSystem() {}

  /**
   * Singleton.
   * @return only instance
   */
  public static RegistrationSystem getInstance() {
    return INSTANCE;
  }

  /**
   * Creates vehicle.
   * @param kind vehicle kind
   * @param make vehicle make
   * @param productionYear vehicle production year
   * @param purchasePrice vehicle purchase price
   * @return vehicle if successful
   * @throws IllegalArgumentException if vehicle cannot be created
   */
  public IVehicle createVehicle(String kind, String make, int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    if (CreateVehicleHelper.isValidVehicle(kind, make, productionYear, purchasePrice)) {
      return new Vehicle(kind, make, productionYear, purchasePrice);
    }
    return null;
  }

  /**
   * Register vehicle into system.
   * @param vehicle vehicle to register
   * @param jurisdiction jurisdiction to register in
   * @param registrationYear registration year
   * @param owners owners of vehicle
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction,
                       int registrationYear, List<Person> owners) {
    IRegistration newReg = new Registration(vehicle, jurisdiction, registrationYear, owners);
    for (IRegistration registration : registrations) {
      if (newReg.equals(registration)) return;
    }
    this.registrations.add(newReg);
  }

  /**
   * Getter for all registrations in system.
   * @return unmodifiable list of all registrations
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(this.registrations);
  }

  /**
   * Filter registrations in system.
   * @param query predicate
   * @return unmodifiable filtered list
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    List<IRegistration> a = this.registrations.stream().filter(r -> query.test(r))
            .collect(Collectors.toList());
    return Collections.unmodifiableList(a);
  }

  /**
   * Clear all registrations in system.
   */
  public void reboot() {
    this.registrations.clear();
  }
}
