import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
// this part of code is not needed
//     public static void newPrintArray(int[] array){
//       //had to make a for each loop to loop through elements in createRandomArray();
//         for(int a : array){
//             System.out.println(a + " ");
//         }
//         System.out.println();

// }

public static int[] createRandomArray(int arrayLength){
    int[] array = new int[arrayLength];
    Random random = new Random();
    for(int i= 0; i< arrayLength; i ++){
    array[i] = random.nextInt(100);
}
return array;
}
public static void writeArrayToFile(int[] array, String fileName) throws Exception {
    try {
    FileWriter fileWriter = new FileWriter(fileName);
    for (int a: array) {
    fileWriter.write(a + "\n");
     }
    fileWriter.close();
    } catch(IOException e) {
    System.out.println("Encounter and IOEception");
    e.printStackTrace();
    }
}

public static int[] readFileToArray(String filename){
File file = new File(filename);
try{
Scanner scanner = new Scanner(file);
ArrayList <Integer> arrayList = new ArrayList<>();
while (scanner.hasNextLine()){
    String str = scanner.nextLine();
    int a = Integer.parseInt(str);
    arrayList.add(a);
}
int [] array = new int[arrayList.size()];
for( int i =0; i < arrayList.size(); i++) {
    array[i] = arrayList.get(i);
}
scanner.close();
return array;
} catch(FileNotFoundException e){
    e.printStackTrace();
}
return null;
}
public static void bubbleSort(int[] array){
    for(int i= array.length -1; i >0; i--){
        for(int j= 0; j < i; j++){
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                
        }
        }
      // newPrintArray(array);
    }
}
    public static void main(String[] args) throws Exception {
    // static would be used for other methods because it was what your main folder has methods wont work if dont use static
       // int arrayLength = 5;
        //int [] array = createRandomArray(arrayLength);
        //String fileName = "intergers.txt";
        //printArray(array);
        //make sure to method call the fuction or code wont work
        //writeArrayToFile(array, fileName);
        //int[] array = readArrayFromFile(fileName);
        
       // writeArrayToFile(array, "sorted.txt");
    
       // printArray(array);
       Scanner scanner = new Scanner(System.in);
       System.out.println("\n Try my new application called bubblesort, where you can make files: \n");
       System.out.println("Would you like to make new file : Please enter 2(yes) or 1(no)?: \n");
       int answerChoice = scanner.nextInt();
       String filename;
       int[] array;
       
        if (answerChoice == 1) {
            System.out.println("Please enter a filename make sure it ends with .txt for example; name.txt:");
            filename = scanner.next();
            array = readFileToArray(filename);
            bubbleSort(array);
            System.out.println("Do you want to view sorted array in file? (Enter yes or no)");
            String save = scanner.next();
            if (save.equals("yes")) {
                writeArrayToFile(array, "bubble.txt");
                System.out.println("The sorted array is saved in file name bubble.txt");
            } else { System.out.println("Thanks for playing!");
                try{
                    FileInputStream fiStream = new FileInputStream(filename);
                    Scanner fileScan = new Scanner(fiStream);
                    while (fileScan.hasNextLine()){
                        System.out.printf("\t" + fileScan.hasNextLine());
                        
                        fiStream.close();
                        fileScan.close();
                }
                 } catch (FileNotFoundException e){
                        System.out.printf("system error");
                     
                  } catch (Exception e) {
                 e.printStackTrace();
            }
            scanner.close();
            }
        } else if (answerChoice == 2) {
            System.out.println("Please enter the number of random integers you want to appear in file:");
            int number = scanner.nextInt();
            array = createRandomArray(number);
            System.out.println("Please enter the filename to save:");
            filename = scanner.next();
            if (filename == "") {
                filename = "integers.txt";
                try{
                        FileInputStream fiStream = new FileInputStream(filename);
                        Scanner fileScan = new Scanner(fiStream);
                        while (fileScan.hasNextLine()){
                            System.out.printf("\t" + fileScan.hasNextLine());
                            
                            fiStream.close();
                            fileScan.close();
                        }
                         } catch (FileNotFoundException e){
                            System.out.printf("system error");
                         
                        } catch (Exception e) {
                         e.printStackTrace();
                }
            }
            writeArrayToFile(array, filename);
            bubbleSort(array);
        }
        scanner.close();
    }
}