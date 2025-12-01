import java.io.*;
import java.util.*;

/**
 * Amusement ride class (implements RideInterface, covers all Assessment Part1-7 requirements)
 * Core functions: Queue management, ride history, cycle operation, file I/O
 * Key attributes: Operator (Employee), ride name/type, collection containers, operation parameters
 */
public class Ride implements RideInterface {
    // ------------------------------ Basic Attributes ------------------------------
    // Ride operator (must be assigned to run the ride, corresponds to Assessment Part1)
    private Employee operator;
    // Ride name (e.g., "Roller Coaster")
    private String rideName;
    // Ride type (e.g., "Thrill Ride"/"Water Ride")
    private String rideType;

    // ------------------------------ Collection Containers (Part3/4A) ------------------------------
    // Waiting queue (LinkedList for Queue: FIFO + efficient add/remove, corresponds to Assessment Part3)
    private Queue<Visitor> waitingLine;
    // Ride history (LinkedList: efficient iteration + modification, corresponds to Assessment Part4A)
    private LinkedList<Visitor> rideHistory;

    // ------------------------------ Operation Parameters (Part5) ------------------------------
    // Max riders per cycle (configurable per ride, e.g., 8 for roller coasters)
    private int maxRider;
    // Number of cycles completed (tracks ride usage frequency)
    private int numOfCycles;

    /**
     * Default constructor (initializes collections + default parameters)
     */
    public Ride() {
        this.waitingLine = new LinkedList<>(); // LinkedList implementation of Queue
        this.rideHistory = new LinkedList<>(); // Initialize ride history
        this.numOfCycles = 0; // Start with 0 cycles
    }

    /**
     * Parameterized constructor (initializes core attributes)
     * @param operator Ride operator (Employee)
     * @param rideName Ride name
     * @param rideType Ride category
     * @param maxRider Max riders per cycle
     */
    public Ride(Employee operator, String rideName, String rideType, int maxRider) {
        this(); // Call default constructor for collections
        this.operator = operator;
        this.rideName = rideName;
        this.rideType = rideType;
        this.maxRider = maxRider;
    }

    // ------------------------------ Getter/Setter ------------------------------
    /**
     * Get the ride operator
     * @return operator (Employee)
     */
    public Employee getOperator() {
        return operator;
    }

    /**
     * Set the ride operator
     * @param operator Ride operator
     */
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    /**
     * Get the ride name
     * @return rideName (String)
     */
    public String getRideName() {
        return rideName;
    }

    /**
     * Set the ride name
     * @param rideName Ride name
     */
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    /**
     * Get the ride type
     * @return rideType (String)
     */
    public String getRideType() {
        return rideType;
    }

    /**
     * Set the ride type
     * @param rideType Ride category
     */
    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    /**
     * Get max riders per cycle
     * @return maxRider (int)
     */
    public int getMaxRider() {
        return maxRider;
    }

    /**
     * Set max riders per cycle
     * @param maxRider Max riders per cycle
     */
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    /**
     * Get number of completed cycles
     * @return numOfCycles (int)
     */
    public int getNumOfCycles() {
        return numOfCycles;
    }

    // ------------------------------ Part3: Queue Management ------------------------------
    /**
     * Add visitor to waiting queue (implements RideInterface)
     * Uses Queue.offer(): avoids NullPointerException, returns false on failure
     * @param visitor Visitor to add
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("[Failed] Cannot add null visitor to queue");
            return;
        }
        waitingLine.offer(visitor); // Safe addition to Queue
        System.out.println("[Success] Visitor " + visitor.getName() + " added to " + rideName + " queue");
    }

    /**
     * Remove first visitor from queue (implements RideInterface)
     * Uses Queue.poll(): returns null if queue is empty (avoids NoSuchElementException)
     */
    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("[Failed] " + rideName + " queue is empty—cannot remove visitor");
            return;
        }
        Visitor removed = waitingLine.poll(); // Remove and return front element
        System.out.println("[Success] Visitor " + removed.getName() + " removed from " + rideName + " queue");
    }

    /**
     * Print waiting queue details (implements RideInterface)
     * Prints all visitors in order of joining, including queue size
     */
    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + " waiting queue is currently empty");
            return;
        }
        System.out.println("\n" + rideName + " Waiting Queue (" + waitingLine.size() + " visitors):");
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // ------------------------------ Part4A: Ride History Management ------------------------------
    /**
     * Add visitor to ride history (implements RideInterface)
     * @param visitor Visitor who rode the ride
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("[Failed] Cannot add null visitor to ride history");
            return;
        }
        rideHistory.add(visitor); // Add to end of LinkedList
        System.out.println("[Success] Visitor " + visitor.getName() + " added to " + rideName + " history");
    }

    /**
     * Check if visitor exists in ride history (implements RideInterface)
     * Uses visitorId for comparison (avoids object reference issues)
     * @param visitor Visitor to check
     * @return true = exists, false = does not exist
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null || rideHistory.isEmpty()) {
            return false;
        }
        // Iterate history to match visitorId
        for (Visitor v : rideHistory) {
            if (v.getVisitorId().equals(visitor.getVisitorId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get total visitors in ride history (implements RideInterface)
     * @return Number of visitors in history (int)
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    /**
     * Print ride history (implements RideInterface, mandatory Iterator usage)
     * Prints all visitors in order of riding, including history size
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is currently empty");
            return;
        }
        System.out.println("\n" + rideName + " Ride History (" + rideHistory.size() + " visitors):");
        Iterator<Visitor> iterator = rideHistory.iterator(); // Mandatory Iterator (Assessment requirement)
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // ------------------------------ Part4B: Ride History Sorting ------------------------------
    /**
     * Sort ride history (uses VisitorComparator, corresponds to Assessment Part4B)
     * Sorting rules: Age (ascending) → Name (alphabetical)
     */
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[Info] " + rideName + " ride history is empty—no sorting needed");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator()); // Sort with custom comparator
        System.out.println("[Success] " + rideName + " history sorted by: Age (ascending) → Name (alphabetical)");
    }

    // ------------------------------ Part5: Ride Cycle Operation ------------------------------
    /**
     * Run one ride cycle (implements RideInterface, corresponds to Assessment Part5)
     * Core logic: Check operator → Check queue → Move visitors → Update cycle count
     */
    @Override
    public void runOneCycle() {
        // 1. Check if operator is assigned
        if (operator == null) {
            System.out.println("[Failed] " + rideName + " has no operator—cannot run");
            return;
        }
        // 2. Check if queue is empty
        if (waitingLine.isEmpty()) {
            System.out.println("[Failed] " + rideName + " queue is empty—cannot run");
            return;
        }
        // 3. Calculate riders for this cycle (capped at maxRider)
        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("\n[Starting Cycle] " + rideName + " Cycle " + (numOfCycles + 1) + "—planned riders: " + ridersThisCycle);

        // 4. Move visitors from queue to history
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingLine.poll(); // Remove front visitor
            if (rider != null) {
                addVisitorToHistory(rider); // Reuse Part4A method
            }
        }

        // 5. Update cycle count
        numOfCycles++;
        System.out.println("[Cycle Complete] " + rideName + " Cycle " + numOfCycles + " finished—total cycles: " + numOfCycles);
    }

    // ------------------------------ Part6: Export Ride History to File ------------------------------
    /**
     * Export ride history to CSV file (corresponds to Assessment Part6)
     * Uses try-with-resources for auto stream closing; handles IO exceptions
     * @param filePath File save path (e.g., "ride_history.csv")
     */
    public void exportRideHistory(String filePath) {
        if (rideHistory.isEmpty()) {
            System.out.println("[Failed] " + rideName + " history is empty—cannot export");
            return;
        }

        // try-with-resources: auto-closes BufferedWriter (no manual finally needed)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write CSV header (for readability and parsing)
            writer.write("Type,PersonId,Name,Age,VisitorId,MembershipType");
            writer.newLine();
            // Write each visitor record
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toCsvString());
                writer.newLine();
            }
            System.out.println("[Success] " + rideName + " history exported to: " + filePath);
        } catch (IOException e) {
            // Catch IO exceptions (file not found/permissions)
            System.out.println("[Error] Failed to export file: " + e.getMessage());
        }
    }

    // ------------------------------ Part7: Import Ride History from File ------------------------------
    /**
     * Import ride history from CSV file (corresponds to Assessment Part7)
     * Uses try-with-resources for auto stream closing; handles IO/format exceptions
     * @param filePath File path (e.g., "ride_history.csv")
     */
    public void importRideHistory(String filePath) {
        File file = new File(filePath);
        // Check if file exists
        if (!file.exists()) {
            System.out.println("[Failed] File not found: " + filePath);
            return;
        }

        int importedCount = 0; // Count successfully imported records
        // try-with-resources: auto-closes BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip CSV header (first line)
            // Read and parse each line
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Skip empty lines
                // Parse CSV to Visitor
                Visitor visitor = Visitor.fromCsvString(line);
                if (visitor != null) {
                    rideHistory.add(visitor);
                    importedCount++;
                } else {
                    System.out.println("[Warning] Skipping invalid record: " + line);
                }
            }
            System.out.println("[Success] Imported " + importedCount + " records from " + filePath + " to " + rideName);
        } catch (IOException e) {
            // Catch IO exceptions (file read failure)
            System.out.println("[Error] Failed to import file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Catch age parsing exceptions (non-numeric age)
            System.out.println("[Error] Invalid record format (age not numeric): " + e.getMessage());
        }
    }
}