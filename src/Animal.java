import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * To model an Animal
 *
 * @author Nikola Nikolov
 * @version 24rd March 2021
 */
public class Animal implements Comparable<Animal> {
    String name;
    ArrayList<Owner> originalOwners;
    int foodPerDay;
    String favFood;

    Animal(){
        this("-", 0, "-");
    }

    Animal(String name, int foodPerDay, String favFood){

            this.name = name;
            this.favFood = favFood;
            this.foodPerDay = foodPerDay;
            originalOwners = new ArrayList<Owner>();
    }

    /**
     * This method returns the name of the animal
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value for the name of the animal
     *
     * @param name becomes the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the owner/s of the animal
     *
     * @return originalOwners
     */
    public ArrayList<Owner> getOriginalOwners() {
        return originalOwners;
    }

    /**
     * This method add the Owner of the animal. One animal can have more than one owner.
     *
     * @param o is the new co-/owner
     */
    public void addOriginalOwners(Owner o) {
        this.originalOwners.add(o);
    }

    /**
     * This method returns the number that animal has to be feeded
     *
     * @return foodPerDay
     */
    public int getFoodPerDay() {
        return foodPerDay;
    }

    /**
     * Set the number of time that the animal has to be fed
     *
     * @param foodPerDay
     */
    public void setFoodPerDay(int foodPerDay) {
        this.foodPerDay = foodPerDay;
    }

    /**
     * This method returns the food that the animal like the most
     *
     * @return favFood
     */
    public String getFavFood() {
        return favFood;
    }

    /**
     * Set favorite food of the Animal
     *
     * @param favFood
     */
    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    /**
     * This method compare the names of the animals and return the int value
     * that help the program to sort the names
     *
     * @return
     */
    public  int compareTo(Animal other){
        return name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name.equals(animal.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "\nOriginal Owner: " + originalOwners + "\nFavfood: " + favFood
                + "\nFoodPerDay: " + foodPerDay + '\n';
    }

    /**
     * Reads in information about the animal from the file
     */
    public void load(Scanner infile){

        name = infile.next();
        int numOwners = infile.nextInt();
        originalOwners = new ArrayList<>();
        for (int oCount = 0; oCount < numOwners; oCount++) {
            String name = infile.next();
            String phone = infile.next();
            Owner owner = new Owner(name, phone);
            originalOwners.add(owner);
        }
        foodPerDay = infile.nextInt();
        favFood = infile.next();
    }
    /**
     * Write information about the animal in the file
     */
    public void save(PrintWriter pw){
        pw.println("Animal");
        pw.println(name);
        pw.println(originalOwners.size());
        for (Owner o : originalOwners) {
            pw.println(o.getName());
            pw.println(o.getPhone());
        }
        pw.println(foodPerDay);
        pw.println(favFood);
    }

}
