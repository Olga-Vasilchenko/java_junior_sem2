package org.example;

public class Cat extends Animal{
    private boolean participationInExhibitions; // участвует в выставках
    private boolean walkingOnTheStreet; // гуляет на улице

    public Cat(String name, int age, boolean participationInExhibitions, boolean walkingOnTheStreet) {
        super(name, age);
        this.participationInExhibitions = participationInExhibitions;
        this.walkingOnTheStreet = walkingOnTheStreet;
    }

    @Override
    public String toString() {
        return "\nИмя: " + name +
                "\nВозраст: " + age + " лет" +
                "\nУчаствует в выставках: " + participationInExhibitions +
                "\nГуляет на улице: " + walkingOnTheStreet;
    }

    public void makeSound(){
        System.out.println("Голос: МЯУ!");
    }
    public void showAffection(){
        System.out.println("Кошка мурлыкает");
    }

    public boolean isParticipationInExhibitions() {
        return participationInExhibitions;
    }

    public boolean isWalkingOnTheStreet() {
        return walkingOnTheStreet;
    }
}

