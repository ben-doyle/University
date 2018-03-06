package Animal;

public class Cat extends Mammal {
    private String animalType;

    public Cat() {
        this.animalType = "Cat";
    }

    public String getAnimalType() {
        return animalType;
    }

    @Override
    public void speak(Animal a) {
        System.out.println(a.getClass().getSimpleName()  + " says meow!");
    }
}
