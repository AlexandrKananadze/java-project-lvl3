package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    private final List<BaseSchema> listOfSchemas = new ArrayList<>();
    private final List<String> listOfKeys = new ArrayList<>();
    private final Predicate<Object> isMap = j -> j instanceof Map;


    public final void required() {
        super.addPredicate(isMap);
        super.setRequired();
    }

    public final void sizeof(int size) {
        super.addPredicate(isMap);
        Predicate<Object> sizeofMap = j -> ((Map) j).size() == size;
        super.addPredicate(sizeofMap);
        super.setRequired();
    }


    @Override
    public final boolean isValid(Object o) {
        if (listOfSchemas.isEmpty()) {
            return super.isValid(o);
        }
        return shapeCheck(((HashMap<String, String>) o));
    }

    private boolean shapeCheck(HashMap<String, String> map) {
        for (int i = 0; i < listOfSchemas.size(); i++) {
            BaseSchema schema = listOfSchemas.get(i);
            if (!schema.isValid(map.get(listOfKeys.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public final void shape(Map<String, BaseSchema> map) {
        for (Map.Entry<String, BaseSchema> temp : map.entrySet()) {
            listOfKeys.add(temp.getKey());
            listOfSchemas.add(temp.getValue());
        }
    }

}
