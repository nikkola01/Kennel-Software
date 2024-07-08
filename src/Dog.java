import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To model an Dog
 *
 * @author Nikola Nikolov
 * @version 24rd March 2021
 */
public class Dog extends  Animal {

    private boolean likesBones;

    Dog() {
        this("-", 0, "-",false);
    }

    Dog(String n, int foodPerDay, String favFood, boolean likesBones){
        this.name=n;
        this.foodPerDay = foodPerDay;
        this.favFood = favFood;
        this.likesBones = likesBones;
        originalOwners = new ArrayList<Owner>();
    }

    /**
     * This method returns the true if the dog likes bones
     *
     * @return likesBones
     */
    public boolean isLikesBones() {
        return likesBones;
    }

    /**
     * This method sets the value for likesBones
     *
     * @param likesBones becomes the value
     */
    public void setLikesBones(boolean likesBones) {
        this.likesBones = likesBones;
    }

    @Override
    public String toString() {
        return "Dog name: " + name + "\nLikes Bones?: " + likesBones
                + "\nOriginal Owner: " + originalOwners + "\nFavfood: " + favFood
                + "\nFoodPerDay: " + foodPerDay + '\n';
    }

    /**
     * Reads in information about the dog from the file
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
        likesBones = infile.nextBoolean();
        foodPerDay = infile.nextInt();
        favFood = infile.next();
    }

    public void save(PrintWriter pw){
        pw.println("Dog");
        pw.println(name);
        pw.println(originalOwners.size());
        for (Owner o : originalOwners) {
            pw.println(o.getName());
            pw.println(o.getPhone());
        }
        pw.println(likesBones);
        pw.println(foodPerDay);
        pw.println(favFood);
    }
}
