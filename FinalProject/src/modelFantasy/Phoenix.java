package modelFantasy;

public class Phoenix extends Creature {

    private int rebornCount;

    public Phoenix(String name, int age, int rebornCount) {
        super(name, age, "Phoenix");
        this.rebornCount = rebornCount;
    }

    public int getRebornCount() { return rebornCount; }
    public void setRebornCount(int rebornCount) { this.rebornCount = rebornCount; }

    @Override
    public String getDetails() {
        return "Name: " + getName() + " | Age: " + getAge() + " | Species: " + getSpecies() + " | Reborn Count: " + rebornCount;
    }

    @Override
    public String useAbility() {
        return getName() + " bursts into flames and is reborn for the " + rebornCount + " time!";
    }
}