/**
 * Abstract base class for people (corresponds to Assessment Part1, Part2)
 * Designed as abstract because we never instantiate "generic people"—only Employees/Visitors
 * Contains common attributes for all people: unique ID, name, age
 */
public abstract class Person {
    // Unique identifier for the person (e.g., ID card number/system ID)
    private String id;
    // Person's full name
    private String name;
    // Person's age (used to check ride age restrictions)
    private int age;

    /**
     * Default constructor (follows JavaBean standards)
     */
    public Person() {}

    /**
     * Parameterized constructor (initializes all common attributes)
     * @param id Unique identifier
     * @param name Full name
     * @param age Age
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // ------------------------------ Getter/Setter ------------------------------
    /**
     * Get the person's unique ID
     * @return id (String)
     */
    public String getId() {
        return id;
    }

    /**
     * Set the person's unique ID
     * @param id Unique identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the person's name
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Set the person's name
     * @param name Full name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the person's age
     * @return age (int)
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the person's age
     * @param age Age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Override toString for readable person info
     * @return String with all common attributes
     */
    @Override
    public String toString() {
        return "Person{id='" + id + "', name='" + name + "', age=" + age + "}";
    }
}