package org.example;

public class Dog extends Animal{
    private boolean command; // выполняет команды
    private boolean pedigree; // имеет родословную

    public Dog(String name, int age, boolean command, boolean pedigree) {
        super(name, age);
        this.command = command;
        this.pedigree = pedigree;
    }

    @Override
    public String toString() {
        return "\nИмя: " + name +
                "\nВозраст: " + age + " лет" +
                "\nВыполняет команды: " + command +
                "\nИмеет родословную: " + pedigree;
    }

    public void makeSound(){
        System.out.println("Голос: ГАВ!");
    }
    public void executesCommands(){
        System.out.println("Собака приносит игрушку");
    }

}

