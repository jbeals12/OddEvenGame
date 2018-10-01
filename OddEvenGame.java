import java.util.Scanner;
import java.util.Random;

public class OddEvenGame
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      Random r = new Random();
      
      int numGames = 0;
      String userCall = ""; // User calls odd or even for end result
      int userThrow = 0;//User throws odd or even, which will be added to the computer result to get the total.
      int cpuThrow = 0;//odd (1) or even (2) 
      int throwTotal = 0;
      boolean isOdd = false; // true = odd, false = even
      int userWins = 0;
      int cpuWins = 0;
      
      
      //Get the number of games to play from the user
      System.out.println("How many games do you want to play?");
      numGames = in.nextInt();
      
      while (numGames % 2 == 0) //Even number
      {
         System.out.println("Number of games must be an odd number. Try again");
         numGames = in.nextInt();
      }
      //Flush the buffer
      in.nextLine();
      //play the game for the number of times the user specified
      for (int i = 1; i <= numGames; i++)
      {
         System.out.println("Call it: Odd or Even");
         userCall = in.nextLine(); 
         //Check for valid input
         while (!userCall.equalsIgnoreCase("odd") && !userCall.equalsIgnoreCase("Even"))
         {
            System.out.println("Sorry that is not a valid choice. Please try again");
            userCall = in.nextLine();
         }
         //Ask for "throw"
         System.out.println("Do you want to throw a 1 or a 2?");
         userThrow = in.nextInt();
         
         //check for valid user selection
         while (userThrow != 1 && userThrow != 2)
         {
            System.out.println("You need to select a 1 or 2. Try again");
            userThrow = in.nextInt();
         }
         
         in.nextLine();

         //Make a random choice for the computer
         cpuThrow = r.nextInt(2) + 1;
         System.out.println("Computer threw a " + cpuThrow);
         //decide whether the number was even or odd
         throwTotal = userThrow + cpuThrow;
         
         if (throwTotal == 2 || throwTotal == 4)
         {
            isOdd = false;
            System.out.println("Number was even");
         }
         if (throwTotal == 3)
         {
            isOdd = true;
            System.out.println("Number was odd");
         }
         //Decide who wins the round
         if ((userCall.equalsIgnoreCase("odd") && isOdd) || userCall.equalsIgnoreCase("Even") && !isOdd)
         {
            System.out.println("User wins!");
            userWins++;
         }
         if ((userCall.equalsIgnoreCase("Even") && isOdd) || userCall.equalsIgnoreCase("Odd") && !isOdd)
         {
            System.out.println("Computer wins!");
            cpuWins++;
         }
         System.out.println();
      }// end for
      //Print results
      System.out.println("User wins: " + userWins);
      System.out.println("Computer wins: " + cpuWins);
      if (userWins > cpuWins)
      {
         System.out.println("User Won!");
      }
      else if (cpuWins < userWins)
      {
         System.out.println("Computer Won!");
      }
   }
}//end class