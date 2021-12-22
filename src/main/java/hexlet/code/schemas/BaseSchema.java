package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> predicateList = new ArrayList<>();

    /**
     * @param o
     * @return boolean depends on predicates condition
     */
    public boolean isValid(Object o) {
        for (Predicate<Object> p : predicateList) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * adding predicate to predicate list.
     *
     * @param predicate
     */
    public void addPredicate(Predicate<Object> predicate) {
        this.predicateList.add(predicate);
    }
}
