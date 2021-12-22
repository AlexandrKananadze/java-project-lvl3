package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    private final Predicate<Object> isMap = j -> j instanceof Map;


    public final MapSchema required() {
        super.addPredicate(isMap);
        return this;
    }

    public final MapSchema sizeof(int size) {
        super.addPredicate(isMap);
        super.addPredicate(p -> ((Map<?, ?>) p).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        super.addPredicate(x -> {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) x).entrySet()) {
                if (!map.get(entry.getKey()).isValid(entry.getValue())) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
