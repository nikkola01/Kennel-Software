import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class runs a Kennel
 *
 * @author Nikola Nikolov
 * @version 24rd March 2021
 */
public class KennelDemo {
    private String filename; // holds the name of the file
    private Kennel kennel; // holds the kennel
    private Scanner scan; // so we can read from keyboard

    /*
     * Notice how we can make this constructor private, since we only call from main which
     * is in this class. We don't want this class to be used by any other class.
     */
    private KennelDemo() {
        scan = new Scanner(System.in);
        System.out.print("Please enter the filename of kennel information: ");
        filename = scan.nextLine();

        kennel = new Kennel();
    }

    /*
     * initialise() method runs from the main and reads from a file
     */
    private void initialise() {
        System.out.println("Using file " + filename);

        try {
            kennel.load(filename);
        } catch (FileNotFoundException e) {
            System.err.println("The file: " + filename + " does not exist. Assuming first use and an empty file." +
                    " If this is not the first use then have you accidentally deleted the file?");
        } catch (IOException e) {
            System.err.println("An unexpected error occurred when trying to open the file " + filename);
            System.err.println(e.getMessage());
        }
    }

    /*
     * runMenu() method runs from the main and allows entry of data etc
     */
    private void runMenu() {
        String response;
        do {
            printMenu();
            System.out.println("What would you like to do:");
            scan = new Scanner(System.in);
            response = scan.nextLine().toUpperCase();
            switch (response) {
                case "1":
                    admitAnimal();
                    break;
                case "2":
                    changeKennelName();
                    break;
                case "3":
                    printAll();
                    break;
                case "4":
                    searchForAnimal();
                    break;
                case "5":
                    removeAnimal();
                    break;
                case "6":
                    setKennelCapacity();
                    break;
                case "S":
                    save();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Try again");
            }
        } while (!(response.equals("Q")));
    }

    private void printMenu() {
        System.out.println("1 -  add a new Animal ");
        System.out.println("2 -  set up Kennel name");
        System.out.println("3 -  display all inmates");
        System.out.println("4 -  search for a Animal");
        System.out.println("5 -  remove a animal");
        System.out.println("6 -  set kennel capacity");
        System.out.println("s - Save");
        System.out.println("q - Quit");
    }

    private void setKennelCapacity() {
        System.out.print("Enter max number of animals: ");
        int max = scan.nextInt();
        scan.nextLine();
        kennel.setCapacity(max);
    }

    /**
     * printAll() method runs from the main and prints status
     */
    private void printAll() {
        System.out.println(kennel);
    }

    private void removeAnimal() {
        System.out.println("which animal do you want to remove");
        String dogToBeRemoved;
        dogToBeRemoved = scan.nextLine();
        kennel.removeAnimal(dogToBeRemoved);
    }

    private void searchForAnimal() {
        System.out.println("which animal do you want to search for");
        String name = scan.nextLine();
        Animal found = kennel.search(name);
        if (found != null) {
            System.out.println(found.toString());
        } else {
            System.out.println("Could not find animal: " + name);
        }
    }

    private void changeKennelName() {
        String name = scan.nextLine();
        kennel.setName(name);
    }

    private void admitAnimal() {
        if(kennel.isKennelFull()){
            System.err.println("Sorry kennel is full - cannot add team");
            return;
        }

        boolean isCat = false;
        while(true){
            System.out.println("Is it a Dog or a Cat (d/c):");
            String text = scan.nextLine().toUpperCase();
            if(text.equals("D")){
                isCat = false;
                break;
            }else if(text.equals("C")){
                isCat = true;
                break;
            }
        }
        boolean lb = false;
        System.out.println("enter the name");
        String name = scan.nextLine();
        System.out.println("What is his/her favourite food?");
        String fav;
        fav = scan.nextLine();
        int numTimes=0;
        try {
            System.out.println("How many times is he/she fed a day? (as a number)");
            numTimes = scan.nextInt();


        }
        catch (InputMismatchException ex) {
            System.err.println("Error!We are expecting integer(number) :" + ex);
        }

        scan.nextLine(); // Clear the end of line characters because I didn't use a delimiter
        Animal newAnimal = null;
        if(isCat){
            System.out.println("Does she/he can share run? (Y/N)");
            String likeBones;
            likeBones = scan.nextLine().toUpperCase();
            if (likeBones.equals("Y")) {
                lb = true;
            }
            newAnimal = new Cat(name, numTimes, fav, lb);
        }else{
            System.out.println("Does he/she like bones? (Y/N)");
            String likeBones;
            likeBones = scan.nextLine().toUpperCase();
            if (likeBones.equals("Y")) {
                lb = true;
            }
            newAnimal = new Dog(name, numTimes, fav, lb);
        }
        ArrayList<Owner> owners = getOwners();
        for(Owner o: owners){
            newAnimal.addOriginalOwners(o);
        }

        kennel.addAnimal(newAnimal);
    }

    private ArrayList<Owner> getOwners() {
        ArrayList<Owner> owners = new ArrayList<Owner>();
        String answer;
        do {
            System.out.println("Enter on separate lines: owner-name owner-phone");
            String ownName = scan.nextLine();
            String ownPhone = scan.nextLine();
            Owner own = new Owner(ownName, ownPhone);
            owners.add(own);
            System.out.println("Another owner (Y/N)?");
            answer = scan.nextLine().toUpperCase();
        } while (!answer.equals("N"));
        return owners;
    }

    /*
     * save() method runs from the main and writes back to file
     */
    private void save() {
        try {
            kennel.save(filename);
        } catch (IOException e) {
            System.err.println("Problem when trying to write to file: " + filename);
        }
    }

    // /////////////////////////////////////////////////
    public static void main(String args[]) {
        System.out.println("**********HELLO***********");
        KennelDemo demo = new KennelDemo();
        demo.initialise();
        demo.runMenu();
        demo.printAll();
        // MAKE A BACKUP COPY OF data.txt JUST IN CASE YOU CORRUPT IT
        demo.save();
        System.out.println("***********GOODBYE**********");
    }
}
