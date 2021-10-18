package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private final Predicate<Object> isString = j -> j instanceof String;

    public final StringSchema contains(String str) {
        super.addPredicate(isString);
        Predicate<Object> containsPredicate = p -> ((String) p).contains(str);
        super.addPredicate(containsPredicate);
        return this;
    }

    public final StringSchema minLength(int min) {
        super.addPredicate(isString);
        Predicate<Object> minLengthPredicate = p -> ((String) p).length() >= min;
        super.addPredicate(minLengthPredicate);
        return this;
    }

    public final StringSchema required() {
        minLength(1);
        super.setRequired();
        return this;
    }
}
