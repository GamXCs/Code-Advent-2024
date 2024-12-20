import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1Advent {

    public static void main(String[] args) {
        ArrayList<Integer> row1 = new ArrayList<>(); //create list to hold row 1
        ArrayList<Integer> row2 = new ArrayList<>(); //create list to hold row 2

        try (Scanner scanner = new Scanner(Paths.get("src/Day1Advent.txt"))) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split("   "); //list has 3 spaces in between each; this splits them
                row1.add(Integer.parseInt(data[0])); //adds each item in row 1 into a string array (data)
                row2.add(Integer.parseInt(data[1])); //adds each item in row 2 into a string array (data)
            }
            scanner.close();
        } catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
        System.out.println("The sum is: " + subtract(row1,row2));
        System.out.println("Similar score: " + similiarityScore(row1,row2));


    }
    //method to calculate the difference
    public static int subtract(ArrayList<Integer> row1, ArrayList<Integer> row2){
        Collections.sort(row1); //sort row 1
        Collections.sort(row2); //sort row 2

        int sum = 0; //initialize sum counter

        //loop through each entry & take the abs value, add the sum of the difference of each row
        for (int i = 0; i < row1.size(); i++) {
            sum += Math.abs(row1.get(i) - row2.get(i));
        }
        return sum; //return the final sum
    }

    public static int similiarityScore(ArrayList<Integer> row1, ArrayList<Integer>row2){
        int score = 0;

        for (int i = 0; i < row1.size();i++){
            int currentNum = row1.get(i);
            int countInRow2 = 0;

            for (int j = 0; j < row2.size();j++){
                if (row2.get(j) == currentNum){
                    countInRow2++;
                }
            }
            score += currentNum * countInRow2;
        }
        return score;
    }
}

/*I have two rows of data. For the assignment, I need to get the distance between each point and then total that distance
to get one number.
Separate into 2 lists by splitting
subtract each row from each other
add every row
print total
 */
