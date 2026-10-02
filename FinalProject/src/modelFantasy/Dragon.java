package modelFantasy;

public class Dragon extends Creature {

    private int fireStrength;

    public Dragon(String name, int age, int fireStrength) {
        super(name, age, "Dragon");
        this.fireStrength = fireStrength;
    }

    public int getFireStrength() { return fireStrength; }
    public void setFireStrength(int fireStrength) { this.fireStrength = fireStrength; }

    @Override
    public String getDetails() {
        return "Name: " + getName() + " | Age: " + getAge() + " | Species: " + getSpecies() + " | Fire Strength: " + fireStrength;
    }

    @Override
    public String useAbility() {
        return getName() + " breathes fire with a strength of " + fireStrength + "!";
    }
}