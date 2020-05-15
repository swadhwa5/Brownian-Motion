import java.util.Random;
import java.util.Scanner;


/** This project is a graphical replication of the "Brownian Motion", which 
takes input from the user to determine the no of particles and the no of 
steps per walk and then generates a step length and angle of movement
for each particle at each step of its particular walk. This program also 
calculates the minimun and maximum walk length thus obtained. 
*/
/**
Author's name: Shreya Wadhwa.
JHED ID: swadhwa5
Student ID:3D5DB3
Date: 09/03/2019
*/


public class ProjectA {

/** Main method.
   * @param args not used
   */

  
   public static void main(String[] args) {
   
      Scanner kb = new Scanner(System.in);  // this allows us to collect input
      Random rand = new Random();  // random number generator object
   
      int red, green, blue;  // will store random color info
      int angle;             // will store random heading
      int length;            // will store random step length
      double total;          // will store current walk's total length
   
      double min = 0.0;
      double max = 0.0;  // min and max lengths over all walks so far
   
      int numParticles;  // how many particles to simulate
      int totalSteps;    // how many steps each particle should take
   
      int stepCount;     // number of steps in current walk
      double x0, y0, x1, y1;  //old and new position values
      
      
      final int colormax = 256;
      final int canvasCoordinateMax = 256;
      final int stepmin = 5;
      final int steprange = 11; 
      System.out.print("Enter number of particles to simulate: ");
      numParticles = kb.nextInt();
      System.out.print("Enter number of steps per walk: ");
      totalSteps = kb.nextInt();
    
      // Adjust the scale of the canvas; (0,0) is now in center
      StdDraw.setScale(-canvasCoordinateMax, canvasCoordinateMax);
   
      int i = 0;
   
   
      for (i = 1; i <= numParticles; i++) {
      
         
         x0 = 0.0;
         y0 = 0.0;
         red = rand.nextInt(colormax);
         green = rand.nextInt(colormax);
         blue = rand.nextInt(colormax);
         StdDraw.setPenColor(red, green, blue);
         total = 0.0;
      
         for (stepCount = 1; stepCount <= totalSteps; stepCount++) {
         
            angle = rand.nextInt(360);
            length = rand.nextInt(steprange) + stepmin;
            total = total + length;
            
            if (angle >= 0 && angle < 90) {
               y1 = length * Math.sin(Math.toRadians(angle)) + y0; 
               x1 = length * Math.cos(Math.toRadians(angle)) + x0;
               StdDraw.line(x0, y0, x1, y1);
               x0 = x1;
               y0 = y1;
            
            }
            else if (angle >= 90 && angle < 180) {
               y1 = length * Math.sin(Math.toRadians(180 - angle)) + y0;
               x1 = x0 - length * Math.cos(Math.toRadians(180 - angle));
               StdDraw.line(x0, y0, x1, y1);
               x0 = x1;
               y0 = y1;
            
            }
            else if (angle >= 180 && angle < 270) {
               y1 = y0 - length * Math.cos(Math.toRadians(270 - angle));
               x1 = x0 - length * Math.sin(Math.toRadians(270 - angle));
               StdDraw.line(x0, y0, x1, y1);
               x0 = x1;
               y0 = y1;
            
            }
            else if (angle >= 270 && angle < 360) {
               y1 = y0 - length * Math.sin(Math.toRadians(360 - angle));
               x1 = length * Math.cos(Math.toRadians(360 - angle)) + x0;
               StdDraw.line(x0, y0, x1, y1);
               x0 = x1;
               y0 = y1;
            
            }
            
            
         }
            
         if (i == 1) {
            min = total;
            max = total;
         }
         
         else if (i != 1) {
         
            if (total < min) {
               min = total;
            }
            else if (total > max) {
               max = total;
            }
         } 
         
      }   
      System.out.println("Minimum walk length: " + min);
      System.out.println("Maximum walk length: " + max);          
      
              
   }  
         
}
