package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema contains(String str) {
        super.addPredicate(x -> x instanceof String && x.toString().contains(str));
        return this;
    }

    public final StringSchema minLength(int min) {
        super.addPredicate(x -> x instanceof String && x.toString().length() >= min);
        return this;
    }

    public final StringSchema required() {
        super.addPredicate(x -> x instanceof String && !((String) x).isEmpty());
        return this;
    }
}
