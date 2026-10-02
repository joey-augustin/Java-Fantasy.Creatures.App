# Java - Fantasy.Creature.System
I built a console-based Java application, _Fantasy Creature Management System_, for adding, removing, filtering, and saving fantasy creatures like Dragons, Unicorns, and Phoenixes.
## Project - Fantasy Creature Management System

- **Creature Model (`modelFantasy`)**: `Creature`, `Dragon`, `Unicorn`, `Phoenix`, `Ability`

  I learned how abstract classes and interfaces work together. `Creature` is an abstract base class that implements the `Ability` interface, and each species extends it with its own attribute (fire strength, sparkle color, or reborn count) and its own `getDetails()` and `useAbility()` behavior.

- **Creature Manager (`managerFantasy`)**: `CreatureManager`

  I practiced polymorphism by storing every species in a single `List<Creature>`. The manager adds and removes creatures, filters them by species, and shows statistics like species counts and average age, using the Java Streams API and lambdas.

- **File Persistence (`managerFantasy`)**: `FileHandler`

  I learned to save and load data with `BufferedWriter` and `BufferedReader`. Creatures are stored in `creatures.txt` as comma-separated lines, with `try-with-resources` and exception handling for missing or unreadable files.

- **Console Menu (`mainFantasy`)**: `FantasyCreatureSystem`

  I built an 8-option menu loop with input validation, so non-numeric entries are re-prompted instead of crashing the program. This is where the manager and file handler come together into a usable application.

- **Unit Testing (`testFantasy`)**: `CreatureManagerTest`, `FileHandlerTest`

  I wrote JUnit 5 tests that cover adding, removing, and filtering creatures, each species' ability, and the save and load round trip. I learned how `@BeforeEach` sets up the same starting data for every test.

## Running the Project
1. Clone the repository: `git clone https://github.com/joey-augustin/Java-Fantasy.Creatures.App/tree/main`
2. Build with Maven: `mvn clean compile`
3. Run `FantasyCreatureSystem` from your IDE
4. Run the tests with `mvn test` (note: the file handler tests overwrite `creatures.txt`)

## Technologies Used
- Java 21
- Maven
- JUnit 5
- IntelliJ IDEA
