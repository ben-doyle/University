package Animal;

public class Mammal implements Animal {

    private String animalType;

    public Mammal() {
        this.animalType = "Mammal";
    }

    public String getAnimalType() {
        return animalType;
    }

    public void speak(Animal a) {
        System.out.println(a.getClass().getSimpleName() + " says generic Mammal sound");
    }
}
