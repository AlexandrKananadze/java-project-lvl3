package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private final Predicate<Object> isInteger = j -> j instanceof Integer;

    public final NumberSchema positive() {
        super.addPredicate(x -> x == null || x instanceof Integer && (Integer) x > 0);
        return this;
    }

    public final NumberSchema range(int beginRange, int endRange) {
        super.addPredicate(x -> x instanceof Integer && (Integer) x >= beginRange
                && (Integer) x <= endRange);
        return this;
    }

    public final NumberSchema required() {
        super.addPredicate(isInteger);
        return this;
    }
}
