import java.util.ArrayList;
import java.util.function.Predicate;

// Generic Pair class
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

public class Marks {
    public static void main(String[] args) {
        ArrayList<Pair<String, Integer>> pairs = new ArrayList<>();
        pairs.add(new Pair<>("Shivansh", 65));
        pairs.add(new Pair<>("Hardik", 95));
        pairs.add(new Pair<>("Virat", 100));

        // Predicate to check if the value is greater than 75
        Predicate<Pair<String, Integer>> highScorePredicate = pair -> pair.getValue() > 75;

        for (Pair<String, Integer> pair : pairs) {
            if (highScorePredicate.test(pair)) {
                System.out.println(pair.getKey() + " scored above 75.");
            }
        }
    }
}
