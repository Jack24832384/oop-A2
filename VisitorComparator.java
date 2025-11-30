import java.util.Comparator;

/**
 * Visitor comparator class (implements Comparator, corresponds to Assessment Part4B)
 * Sorting rules: 1. Age (ascending), 2. Name (alphabetical, case-insensitive)
 * Design purpose: Multi-condition sorting for ride history records
 */
public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Compare two Visitor objects (core method of Comparator interface)
     * @param v1 First visitor
     * @param v2 Second visitor
     * @return Negative = v1 < v2, 0 = equal, Positive = v1 > v2
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 1. Compare age first (ascending)
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        // 2. If ages match, compare names (alphabetical, case-insensitive)
        return v1.getName().compareToIgnoreCase(v2.getName());
    }
}