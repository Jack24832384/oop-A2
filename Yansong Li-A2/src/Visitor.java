/**
 * Amusement park visitor class (inherits from Person, corresponds to Assessment Part1)
 * Adds visitor-specific attributes: visitor ID (for ticketing), membership type (affects queue priority)
 */
public class Visitor extends Person {
    // Visitor ID (distinct from Person's id, for ticketing/queue systems)
    private String visitorId;
    // Membership type (e.g., "Standard"/"VIP"—VIPs get fast-track access)
    private String membershipType;

    /**
     * Default constructor (follows JavaBean standards)
     */
    public Visitor() {}

    /**
     * Parameterized constructor (initializes parent + subclass attributes)
     * @param id Base person ID (inherited from Person)
     * @param name Visitor's name (inherited from Person)
     * @param age Visitor's age (inherited from Person)
     * @param visitorId Ticketing system ID
     * @param membershipType Membership tier (Standard/VIP)
     */
    public Visitor(String id, String name, int age, String visitorId, String membershipType) {
        super(id, name, age); // Call parent constructor for common attributes
        this.visitorId = visitorId;
        this.membershipType = membershipType;
    }

    // ------------------------------ Getter/Setter ------------------------------
    /**
     * Get the visitor's ID
     * @return visitorId (String)
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Set the visitor's ID
     * @param visitorId Ticketing system ID
     */
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    /**
     * Get the visitor's membership type
     * @return membershipType (String)
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * Set the visitor's membership type
     * @param membershipType Membership tier
     */
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * Convert to CSV string (for file export, corresponds to Assessment Part6)
     * Format: ClassName,PersonId,Name,Age,VisitorId,MembershipType
     * @return CSV-formatted string
     */
    public String toCsvString() {
        return getClass().getSimpleName() + "," + getId() + "," + getName() + "," + getAge() + "," + visitorId + "," + membershipType;
    }

    /**
     * Parse Visitor from CSV string (for file import, corresponds to Assessment Part7)
     * @param csvLine Single line from CSV file
     * @return Visitor object (null if parsing fails)
     */
    public static Visitor fromCsvString(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            return null;
        }
        String[] parts = csvLine.split(",");
        // Validate CSV field count (must be 6 columns)
        if (parts.length != 6 || !"Visitor".equals(parts[0])) {
            return null;
        }
        try {
            // Parse fields and create Visitor
            String personId = parts[1];
            String name = parts[2];
            int age = Integer.parseInt(parts[3]);
            String visitorId = parts[4];
            String membershipType = parts[5];
            return new Visitor(personId, name, age, visitorId, membershipType);
        } catch (NumberFormatException e) {
            // Return null if age parsing fails
            return null;
        }
    }

    /**
     * Override toString for complete visitor info (parent + subclass attributes)
     * @return Full visitor details as String
     */
    @Override
    public String toString() {
        return "Visitor{" + super.toString() + ", visitorId='" + visitorId + "', membershipType='" + membershipType + "'}";
    }
}