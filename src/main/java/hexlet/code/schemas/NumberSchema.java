package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private final Predicate<Object> isInteger = j -> j instanceof Integer;
    private final Predicate<Object> positiveInt = j -> (Integer) j > 0;

    public final NumberSchema positive() {
        super.addPredicate(isInteger);
        super.addPredicate(positiveInt);
        return this;
    }

    public final void range(int beginRange, int endRange) {
        super.addPredicate(isInteger);
        Predicate<Object> rangeInt = j -> (Integer) j >= beginRange && (Integer) j <= endRange;
        super.addPredicate(rangeInt);
    }

    public final NumberSchema required() {
        super.addPredicate(isInteger);
        super.setRequired();
        return this;
    }
}
