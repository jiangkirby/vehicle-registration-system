package registration;

/**
 * Person class.
 */
public class Person {
  private String name;
  private String address;

  /**
   * Person constructor.
   * @param name person name
   * @param address person address
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Getter for name.
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter for address.
   * @return address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * ToString method.
   * @return string
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}