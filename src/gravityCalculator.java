
import java.util.Scanner;

public class gravityCalculator {
    public static void main(String[] args) {
        //TODO code application logic is here

        //a string type variable used to store text
        String textvar = "";
        //creating new scanner object which takes InputStream as parameter
        Scanner in = new Scanner(System.in);
        double gravity = -9.81; // Earth’s gravity in p/s’2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;

        do {
            System.out.println("Earth’s gravity = -9.81");
            System.out.println("Initial position of object = " + initialPosition
                    + " (input \"pos\" to change it)");
            System.out.println("Initial velocity of object = " + initialVelocity
                    + " (input \"vel	\" to change it)");
            System.out.println("Falling time of object = " + fallingTime
                    + " (input \"time\" to change it)");
            finalPosition = 0.5 * gravity * fallingTime * fallingTime
                    + initialVelocity * fallingTime + initialPosition;
            System.out.println("The object’s position after "
                    + fallingTime + " seconds is " + finalPosition + " m.");
            System.out.println("Input \"quit\" to exit the application");
            textvar = in.nextLine();
            if ("pos".equals(textvar)) {
                System.out.println("Enter new initial position of object:");
                while (!in.hasNextDouble())
                    in.next();
                initialPosition = in.nextDouble();
            } else if ("vel".equals(textvar)) {
                System.out.println("Enter new initial velocity of object:");
                while (!in.hasNextDouble())
                    in.next();
                initialVelocity = in.nextDouble();
            } else if ("time".equals(textvar)) {
                System.out.println("Enter new falling time of object:");
                while (!in.hasNextDouble())
                    in.next();
                fallingTime = in.nextDouble();
            } else if (!"quit".equals(textvar)) {
                System.out.println("\b");
            }
        }
        while (!"quit".equals(textvar)) ;
        //loop will repeat until	reaches the necessary value
    }
}

