package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> predicateList = new ArrayList<>();
    boolean required = false;


    public boolean isValid(Object o) {
           for (Predicate<Object> p : predicateList) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }

    public void addPredicate(Predicate<Object> predicate) {
        predicateList.add(predicate);
    }

    public void setRequired() {
        required = true;
    }

}