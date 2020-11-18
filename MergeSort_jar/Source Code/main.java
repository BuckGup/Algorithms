// Java Program made by Sam Strecker to Merge Sort
// CS335 Rushit, Dave
// 10/17/2020

import java.awt.*;
import java.util.Scanner;

class MergeSort
{
    //main method
    public static void main(String args[]) {

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
        System.out.println("|Array Entered by User|");
        printArray(array);

        MergeSort mergeObject = new MergeSort();
        mergeObject.sort(array, 0, array.length-1);

        //final print to show array
        System.out.println("\n|User Array Sorted|");
        printArray(array);
    }

    void merge(int array[], int leftArray, int middleArray, int rightArray)
    {
        // Find sizes of two subarrays to be merged
        int a1 = middleArray - leftArray + 1;
        int a2 = rightArray - middleArray;

        // Temporary arrays used during calculations
        int LEFT[] = new int [a1];
        int RIGHT[] = new int [a2];

        // Copy data to temp arrays
        for (int i = 0; i < a1; ++i) {
            LEFT[i] = array[leftArray + i];
        }

        for (int j = 0; j < a2; ++j) {
            RIGHT[j] = array[middleArray + 1 + j];
        }
        System.out.println("\nLEFT ARRAY");
        printArray(array);


        // Combines the two arrays below

        int i = 0, j = 0;
        int k = leftArray;

        while (i < a1 && j < a2) {
            if (LEFT[i] <= RIGHT[j]) {
                array[k] = LEFT[i];
                i++;
            }
            else {
                array[k] = RIGHT[j];
                j++;
            }
            k++;
        }
        System.out.println("\nRIGHT ARRAY");
        printArray(array);

        // Copy elements in left arrays
        while (i < a1) {
            array[k] = LEFT[i];
            i++;
            k++;
        }

        // Copies remaining elements to RIGHT array
        while (j < a2) {
            array[k] = RIGHT[j];
            j++;
            k++;

        }
        System.out.println("\nARRAYS MERGED");
        printArray(array);
    }

    // Helper function that sorts the array
    void sort(int array[], int leftArray, int rightArray) {

        if (leftArray < rightArray) {
            // Find the middle point of the array
            int middleOfArray = (leftArray + rightArray)/2;

            //prints the division of n to calculate the middle point of n
            System.out.println("\n");
            System.out.println("Division of (n) \nLeft Array: " + leftArray + "\n" +
                    "Middle of Array: " + middleOfArray+ "\n" + "Right Array: " + rightArray);

            // Sort first half of array and second half of second array
            sort(array, leftArray, middleOfArray);
            sort(array , middleOfArray + 1, rightArray);

            // Merge the two sorted arrays
            merge(array, leftArray, middleOfArray, rightArray);
        }
    }

  //prints each element of the array
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
