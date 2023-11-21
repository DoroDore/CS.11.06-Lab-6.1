import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int var1 = challengeOne("inputOneTwo.txt"), var2 = challengeTwo("inputOneTwo.txt"), var3 = challengeThree("inputThreeFour.txt"), var4 = challengeFour("inputThreeFour.txt");
        writeFileAllAnswers("AdventureTime.txt", var1, var2, var3, var4);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int thing = 0;
        int[] arr = readFile(fileName);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] > arr[i]) {
                thing++;
            }
        }
        return thing;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int thing = 0;
        int[] arr = readFile(fileName);
        int first;
        int second;
        int count = 0;
        for (int i = 0; i < arr.length-5; i++) {
            first = arr[i]+arr[i+1]+arr[i+2];
            second = arr[i+1]+arr[i+2]+arr[i+3];
            if (second > first) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int vert = 0;
        int horz = 0;
        String[] temp;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String[][] arr = new String[countLinesInFile(fileName)][2];
        for (int i = 0; i < arr.length; i++) {
            temp = scanner.nextLine().split(" ");
            arr[i][0] = temp[0];
            arr[i][1] = temp[1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i][0], "forward")) {
                horz += Integer.parseInt(arr[i][1]);
            }
            else if (arr[i][0].equals("down")) {
                vert += Integer.parseInt(arr[i][1]);
            }
            else {
                vert -= Integer.parseInt(arr[i][1]);
            }
        }

        return vert*horz;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int aim = 0;
        int horz = 0;
        int vert = 0;
        String[] temp;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[][] arr = new String[countLinesInFile(filename)][2];
        for (int i = 0; i < arr.length; i++) {
            temp = scanner.nextLine().split(" ");
            arr[i][0] = temp[0];
            arr[i][1] = temp[1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i][0], "forward")) {
                horz += Integer.parseInt(arr[i][1]);
                vert += (Integer.parseInt(arr[i][1])*aim);
            }
            else if (arr[i][0].equals("down")) {
                aim += Integer.parseInt(arr[i][1]);
            }
            else {
                aim -= Integer.parseInt(arr[i][1]);
            }
        }

        return vert*horz;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}