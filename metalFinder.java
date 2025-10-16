/*
Name: Maddie Gee
Description: This program will get user info about which metal their sphere is likely to be
Date: 07/10/2024
Location: Edinburgh College - Sighthill 
Version: 1.0
Notes: <if any updates or changes we note them here>
 */

package metalfinder;
// import for user input 
import java.util.Scanner;

public class MetalFinder
{
       public void start()
       {
        int menuChoice = 1;
        
        do{
        // open scanner
        Scanner keyboard = new Scanner(System.in); 
        
        // display main menu choices
        System.out.println
("********************************\n"
+ "            Main Menu            \n" +
"********************************\n" +
"Choice 1: Greet new user\n" +
"Choice 2: Estimate the cost of assessment of objects\n" +
"Choice 3: Determine density and predict metal\n" +
"Choice 4: Exit the program \n" + 
"Enter Either 1, 2, 3 or 4 ");
        // get main menu choice from user
        menuChoice = keyboard.nextInt();

        // receive choice and assign to choice name
        switch (menuChoice)
                    {
            case 1: Choice1(); break;
            case 2: Choice2(); break;
            case 3: Choice3(); break;
            case 4: Choice4(); break;
        // if the user enters anything other than 1, 2, 3 or 4 it will display an error
            default:
                System.out.println("Invalid choice.");
                break;
                    }
       
        }
        
       while (menuChoice != 4);
        }   

// PARAMETER PASS       
private void Choice1()
{
   
    // create scanner
    Scanner sc = new Scanner(System.in);
            
    // get details for full name
    String initName;
    System.out.println("What is your first name? ");
    String firstName = sc.next();     
    System.out.println("What is your last name? ");
    String lastName = sc.next();
    // takes the first letter of the first name and concatenates with the last name 
    initName = firstName.charAt(0) + lastName;
    // displays welcome message
    System.out.println("Welcome " + initName + " to the NMI Density Calculator and Metal Predictor");
    
  
}

// PARAMETER PASS 
private void Choice2()
{
    // declare variable
    double totalCost = 0;
    
    // create scanner
    Scanner sc1 = new Scanner(System.in);
    
    System.out.println("Enter the number of objects: ");
    int objectNum = sc1.nextInt();  
    totalCost = (2.5 * objectNum) + 7.99;
    
    // have to round as java calculates differently to decimal 
    String roundedTotalCost = String.format("%.4g%n", totalCost); 
    System.out.println(objectNum + " object(s) cost " + "£" + roundedTotalCost );

}

// PARAMETER PASS 
private void Choice3()
{
    
    //Declare variables mass, diameter, volume, density, objectName 
    double mass, diameter, volume, density;
    String objectName;
    int count = 1;
    
    // create scanner
    Scanner sc2 = new Scanner(System.in);
    System.out.println("How many objects would you like to calculate the density for? ");
    int densityNum = sc2.nextInt();
    while (count <= densityNum) 
    {
        // get user input required for calculations
        System.out.println("Enter the mass of object " + count + " (in kg): ");
        mass = sc2.nextDouble();
        
        // input validation for mass
        while (mass < 0 || mass > 3) {
            System.out.println("Error. Impossible mass. Please enter again.");
            mass = sc2.nextDouble();
        }
        
        System.out.println("Enter the diameter of object " + count + " (in m): ");
        diameter =  sc2.nextDouble();
        
        // input validation for diameter
        while (diameter <= 0 || diameter > 100) {
            System.out.println("Error. Impossible diameter. Please enter again.");
            diameter = sc2.nextDouble();
        }
        
        // calculate the volume of sphere using formula 4/3 x pi x r^3
        volume = Math.PI * (diameter/2)*(diameter/2)*(diameter/2);
        volume = volume / 3 * 4;
        
        // calculate density in kg/m^3
        density = mass / volume;
        System.out.println("The density of object " + count + " is " + Math.round(density) + "kg/m^3");
        
        // determines the closest metal density value to the calculated density
        // using +/- 2.5% for all except nickel and copper since they are close in density
        if (density < 2768 && density > 2633) {
            objectName = "Aluminium";
        }
        
        else if (density < 4613 && density > 4388) {
            objectName = "Titanium";
        }
        else if (density < 7313 && density > 6957) {
            objectName = "Zinc";
        }
        else if (density < 8071 && density > 7677) {
            objectName = "Iron";
        }
        else if (density < 8917 && density > 8899) {
            objectName = "Nickel";
        }
        else if (density < 8969 && density > 8951) {
            objectName = "Copper";
        }
        else if (density < 10752 && density > 10228) {
            objectName = "Silver";
        }
        else if (density < 11624 && density > 11057) {
            objectName = "Lead";
        }
        else if (density < 19783 && density > 18818) {
            objectName = "Gold";
        }
        else if (density < 20914 && density > 21986) {
            objectName = "Platinum";
        }
        else {
            objectName = "objectunknown";
        }
        
        if (objectName != "objectunknown") {
            // displays metal to user
            System.out.println("Object " + count + " is likely to be " + objectName);
        }
        else {
            System.out.println("Unknown object.");
        }
        
        // increment counter
        count = count + 1;
    }
}

// PARAMETER PASS 
private void Choice4()
{
    System.out.println("Successfully exited");
    System.exit(0);
}


public static void main(String[] args) 
        { 
            // run code above defined in public void start
            new MetalFinder().start();    
         }


}