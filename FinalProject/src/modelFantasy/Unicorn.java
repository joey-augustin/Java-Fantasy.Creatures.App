package modelFantasy;

public class Unicorn extends Creature {

    private String sparkleColor;

    public Unicorn(String name, int age, String sparkleColor) {
        super(name, age, "Unicorn");
        this.sparkleColor = sparkleColor;
    }

    public String getSparkleColor() { return sparkleColor; }
    public void setSparkleColor(String sparkleColor) { this.sparkleColor = sparkleColor; }

    @Override
    public String getDetails() {
        return "Name: " + getName() + " | Age: " + getAge() + " | Species: " + getSpecies() + " | Sparkle Color: " + sparkleColor;
    }

    @Override
    public String useAbility() {
        return getName() + " sparkles a brilliant " + sparkleColor + " and casts a magic spell!";
    }
}