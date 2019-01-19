package test;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello!");
    }


    static {
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set("Hello!", "Worlds".toCharArray());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
