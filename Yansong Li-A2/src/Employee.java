/**
 * Amusement park employee class (inherits from Person, corresponds to Assessment Part1)
 * Adds employee-specific attributes: employee ID (for HR management), position (e.g., "Roller Coaster Operator")
 */
public class Employee extends Person {
    // Employee ID (distinct from Person's id, for internal HR systems)
    private String employeeId;
    // Job position (identifies the ride type the employee operates)
    private String position;

    /**
     * Default constructor (follows JavaBean standards)
     */
    public Employee() {}

    /**
     * Parameterized constructor (initializes parent + subclass attributes)
     * @param id Base person ID (inherited from Person)
     * @param name Employee's name (inherited from Person)
     * @param age Employee's age (inherited from Person)
     * @param employeeId Internal HR system ID
     * @param position Job title (e.g., "Roller Coaster Operator")
     */
    public Employee(String id, String name, int age, String employeeId, String position) {
        super(id, name, age); // Call parent constructor for common attributes
        this.employeeId = employeeId;
        this.position = position;
    }

    // ------------------------------ Getter/Setter ------------------------------
    /**
     * Get the employee's ID
     * @return employeeId (String)
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the employee's ID
     * @param employeeId Internal HR ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get the employee's position
     * @return position (String)
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the employee's position
     * @param position Job title
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Override toString for complete employee info (parent + subclass attributes)
     * @return Full employee details as String
     */
    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", employeeId='" + employeeId + "', position='" + position + "'}";
    }
}