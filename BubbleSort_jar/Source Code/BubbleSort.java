import java.util.Scanner;
import java.lang.Math;

// Java Program made by Sam Strecker to Bubble Sort
// CS335 Rushit, Dave
// 10/19/2020
class BubbleSort {

    // Driver method to test above
    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        Scanner userInput = new Scanner(System.in);

       System.out.println("Enter the length of the array to be sorted:");

        int n = userInput.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the numbers in the array:");

        //collects input for numbers given
        for (int i = 0; i < n; i++){
            array[i] = userInput.nextInt();
        }

        //System out to show given array user typed
        System.out.println("\n|Array Entered by User|");
        printArray(array);

        //call to sort the array
        ob.bubbleSort(array);
        //System out to show the sorted array
        System.out.println("\n\n|Sorted array|");
        printArray(array);
    }

    void bubbleSort(int array[]) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    System.out.println("\nBUBBLE SORTING ARRAY:");
                    printArray(array);
                    //swap elements in array
                    int tmpArray = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmpArray;
                }
            }
        }
    }

    //helper method used to print array

    static void printArray(int array[]) {
        int a = array.length;

        //prints bracket for formatting
        System.out.print("{");

        for (int i = 0 ; i < a; ++i) {
            //checks to see if it's the last element to not print bracket
            if(i + 1 == a) {
                System.out.print(array[i]);
            }
            else{
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("}");
    }
}