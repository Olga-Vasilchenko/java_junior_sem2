package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        LinkedList<Animal> animals = new LinkedList<>(); // создаем массив объектов Animals
        Animal cat = new Cat("Irma", 5, true, false);
        Animal dog = new Dog("Black", 7,true, true);
        animals.add(cat);
        animals.add(dog);
        System.out.println("\nКошка" + cat + "\n" + "\nСобака" + dog);

        for (Animal animal : animals) {

            // Получаем класс объекта animal и сохраняем его в переменную childClass
            Class<?> childClass = animal.getClass();

            // С помощью метода getSuperclass получаем родительский класс для childClass
            // и сохраняем его в переменную parentClass
            Class<?> parentClass = childClass.getSuperclass();

            System.out.println("\nКласс " + childClass.getSimpleName() + " имеет поля:\n");

            // Получаем переменные родительского класса для каждого объекта класса Animal
            Field[] parentFields = parentClass.getDeclaredFields();
            for (Field field: parentFields) {
                System.out.println("Поле родительского класса: " + field.getName() + " - " + field.get(animal));
            }

            // Получаем переменные наследного класса для каждого объекта класса Animal
            Field[] fields = childClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.set(animal, 10);
                }
                else if (field.getType() == boolean.class) {
                    field.setAccessible(true);
                    System.out.println("Поле наследного класса: " + field.getName() + " - " + field.get(animal));
                }
            }

            // Вызываем метод "makeSound"
            Method[] methods = childClass.getDeclaredMethods();
            for (Method method: methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                    break;
                }
            }
        }
    }
}