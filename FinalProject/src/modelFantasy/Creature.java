package modelFantasy;


public abstract class Creature implements Ability {

    private String name;
    private int age;
    private String species;

    public Creature(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecies() { return species; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setSpecies(String species) { this.species = species; }


    public abstract String getDetails();

    @Override
    public String toString() {
        return getDetails();
    }
}