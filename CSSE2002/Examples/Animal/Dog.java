package Animal;

public class Dog extends Mammal {

    private String animalType;

    public Dog() {
        this.animalType = "Dog";
    }

    public String getAnimalType() {
        return animalType;
    }

    @Override
    public void speak(Animal a) {
        System.out.println(a.getClass().getSimpleName()  + " says woof!");
    }
}
