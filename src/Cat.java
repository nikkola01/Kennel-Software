import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To model an Cat
 *
 * @author Nikola Nikolov
 * @version 24rd March 2021
 */
public class Cat extends Animal {
    private boolean shareRun;

    Cat() {
        this("-", 0, "-", false);
    }

    Cat(String n, int foodPerDay, String favFood, boolean shareRun) {
        this.name = n;
        this.foodPerDay = foodPerDay;
        this.favFood = favFood;
        this.shareRun = shareRun;
        originalOwners = new ArrayList<Owner>();
    }

    /**
     * This method returns the true if the cat can share run
     *
     * @return shareRun
     */
    public boolean isShareRun() {
        return shareRun;
    }

    /**
     * This method sets the value for shareRun
     *
     * @param shareRun becomes the value
     */
    public void setShareRun(boolean shareRun) {
        this.shareRun = shareRun;
    }

    /**
     * Reads in information about the dog from the file
     */
    public void load(Scanner infile) {

        name = infile.next();
        int numOwners = infile.nextInt();
        originalOwners = new ArrayList<>();
        for (int oCount = 0; oCount < numOwners; oCount++) {
            String name = infile.next();
            String phone = infile.next();
            Owner owner = new Owner(name, phone);
            originalOwners.add(owner);
        }
        shareRun = infile.nextBoolean();
        foodPerDay = infile.nextInt();
        favFood = infile.next();
    }

    public void save(PrintWriter pw) {
        pw.println("Cat");
        pw.println(name);
        pw.println(originalOwners.size());
        for (Owner o : originalOwners) {
            pw.println(o.getName());
            pw.println(o.getPhone());
        }
        pw.println(shareRun);
        pw.println(foodPerDay);
        pw.println(favFood);
    }

    public String toString() {
        return "Cat name: " + name + "\nShere Ketel : " + shareRun
                + "\nOriginal Owner: " + originalOwners + "\nFavfood: " + favFood
                + "\nFoodPerDay: " + foodPerDay + '\n';
    }


}
