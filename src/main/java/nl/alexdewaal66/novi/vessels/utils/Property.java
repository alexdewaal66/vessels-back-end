package nl.alexdewaal66.novi.vessels.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Property {
    String name;
    Type type;

    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public static List<Property> makeList(Object[][] tupels) {
        List<Property> list = new ArrayList<>();
        for (Object[] tupel : tupels) {
            list.add(new Property((String) tupel[0], (Type) tupel[1]));
        }
//        System.out.println("» Property » makeList \n\t list = " + list);
        return list;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
