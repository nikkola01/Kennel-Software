import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * To model a Kennel - a collection of animals
 *
 * @author Nikola Nikolov
 * @version 24rd March 2021
 */
public class Kennel {
    private String name;
    private ArrayList<Animal> animals;
    private int nextFreeLocation;
    private int capacity;

    /**
     * Creates a kennel with a default size 20
     */
    public Kennel() {
        this(20);
    }

    /**
     * Create a kennel
     *
     * @param maxNoAnimals The capacity of the kennel
     */
    public Kennel(int maxNoAnimals) {
        nextFreeLocation = 0; // no Dogs in collection at start
        capacity = maxNoAnimals;
        animals = new ArrayList<Animal>(capacity);
    }

    /**
     * This method sets the value for the name attribute. The purpose of the
     * attribute is: The name of the kennel e.g. "DogsRUs"
     *
     * @param theName
     */
    public void setName(String theName) {
        name = theName;
    }

    /**
     * Set the size of the kennel if there isnt more animals already
     *
     * @param capacity The max animals we can house
     */
    public void setCapacity(int capacity) {

        if (nextFreeLocation > capacity) {
            System.err.println("The kennel already have more than that num. First remove some animals.");
            return;
        }
        this.capacity = capacity;
    }

    /**
     * Maximum capacity of the kennels
     *
     * @return The max size of the kennel
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method gets the value for the name attribute. The purpose of the
     * attribute is: The name of the Kennel e.g. "DogsRUs"
     *
     * @return String The name of the kennel
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the number of animals in a kennel
     *
     * @return int Current number of animals in the kennel
     */
    public int getNumOfAnimals() {
        return nextFreeLocation;
    }

    /**
     * This method returns information if the kennel is full
     *
     * @return true if kennel is full
     */
    public boolean isKennelFull() {
        return nextFreeLocation >= capacity;
    }

    /**
     * Enables a user to add an Animal to the Kennel
     *
     * @param theAnimal A new animal to home
     */
    public void addAnimal(Animal theAnimal) {

        animals.add(theAnimal);
        nextFreeLocation = nextFreeLocation + 1;
    }

    /**
     * Enables a user to delete an Animal from the Kennel.
     *
     * @param who The animal to remove
     */
    public void removeAnimal(String who) {
        Animal which = null;

        for (Animal d : animals) {     // Search for the dog by name
            if (who.equals(d.getName())) {
                which = d;
            }
        }
        if (which != null) {
            animals.remove(which); // Requires that Dog has an equals method
            System.out.println("removed " + who);
            nextFreeLocation = nextFreeLocation - 1;
        } else {
            System.err.println("cannot remove - not in kennel");
        }
    }

    /**
     * Searches for and returns the inmate, if found
     *
     * @param name The name of the inmate
     * @return The inmate or else null if not found
     */
    public Animal search(String name) {
        Animal result = null;
        for (Animal a : animals) {
            if (a.getName().equals(name)) {
                result = a;
                break;
            }
        }

        return result;
    }

    /**
     * @return String showing all the information in the kennel
     */
    @Override
    public String toString() {
        Collections.sort(animals);
        StringBuilder builder = new StringBuilder();
        // CHANGE TO USER StringBuilder class
        builder.append("Data in Kennel ").append(name).append(" is: \n");
        for (Animal d : animals) {
            builder.append(d.toString()).append("\n");
        }
        String results = builder.toString();
        return results;
    }

    /**
     * Reads in Kennel information from the file
     *
     * @param infileName The file to read from
     * @throws FileNotFoundException    if file doesn't exist
     * @throws IOException              if some other IO error occurs
     * @throws IllegalArgumentException if infileName is null or empty
     */
    public void load(String infileName) throws IOException, FileNotFoundException {
        // Using try-with-resource. We will cover this in workshop 15, but
        // what it does is to automatically close the file after the try / catch ends.
        // This means we don't have to worry about closing the file.
        try (FileReader fr = new FileReader(infileName);
             BufferedReader br = new BufferedReader(fr);
             Scanner infile = new Scanner(br)) {

            // Use the delimiter pattern so that we don't have to clear end of line
            // characters after doing a nextInt or nextBoolean
            infile.useDelimiter("\r?\n|\r");

            name = infile.next();
            capacity = infile.nextInt();
            String kind = "";
            while (infile.hasNext()) {
                kind = infile.next();
                if (kind.equals("Cat")) {
                    Cat cat = new Cat();
                    cat.load(infile);
                    this.addAnimal(cat);
                } else if (kind.equals("Dog")) {
                    Dog dog = new Dog();
                    dog.load(infile);
                    this.addAnimal(dog);
                } else {
                    Animal dog = new Animal();
                    dog.load(infile);
                    this.addAnimal(dog);
                }
            }
        }
    }

    /**
     * Saves the kennel information
     *
     * @param filename The file to save to
     * @throws IOException If some IO error occurs
     */
    public void save(String filename) throws IOException {
        // Again using try-with-resource so that I don't need to close the file explicitly
        try (FileWriter fw = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter outfile = new PrintWriter(bw);) {

            outfile.println(name);
            outfile.println(capacity);
            for (Animal d : animals) {
                d.save(outfile);
            }
        }
    }
}