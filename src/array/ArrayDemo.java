/*
 *   Created by IntelliJ IDEA.
 *   User: divyanshb
 *   Date: 08/01/20
 *   Time: 3:46 PM
 */

package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static boolean searchInArray(int[] array, int value)//method For Inserting the given Element in an Array
    {
        boolean response = false;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                response = true;
                break;
            }
        }
        return response;
    }

    public static int searchElementIndex(int[] array, int value)//method For Searching the element in array
    {
        int elementIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                elementIndex = i + 1;
                break;
            }
        }
        return elementIndex;
    }

    public static void deleteElement(int[] array, int element)// method for deleting the given  element in array
    {
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
    }

    public static void insertElement(int[] array, int element, int index, int Size)//method for inserting the element in array
    {
        int[] modifyarray = new int[Size + 1];
        modifyarray[index - 1] = element;
        for (int i = 0; i < index - 1; i++) {
            modifyarray[i] = array[i];
        }
        for (int i = index - 1; i < Size; i++) {
            modifyarray[i + 1] = array[i];
        }
        System.out.println("Element inserted");
        System.out.println(Arrays.toString(modifyarray));

    }

    public static int sortArray(int[] integer)//method for sorting the element
    {
        for (int i = 0; i < integer.length; i++) {
            for (int j = i; j < integer.length; j++) {

                if (integer[i] > integer[j]) {
                    int great = integer[i];
                    integer[i] = integer[j];
                    integer[j] = great;
                }

            }
        }
        System.out.println("Array after performing operation");
        System.out.print(Arrays.toString(integer));
        return 0;
    }

    public static void printValue(int[] integer)//method for display element in array
    {
        System.out.println(Arrays.toString(integer));
    }

    public static void initialiseInetgerArray(int[] integer)// method for inserting element in an array from user
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element in array");
        for (int i = 0; i < integer.length; i++) {
            integer[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) //main method
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Size of an array");
        int Size = sc.nextInt();
        int[] integer = new int[Size];
        initialiseInetgerArray(integer);
        System.out.println("Enter the option");
        System.out.println("1.Sorting the array");
        System.out.println("2.Searching the Element in the array");
        System.out.println("3.Deleting the Element in the array");
        System.out.println("4.Inserting the Element in the array");
        int option = sc.nextInt();
        System.out.println("Initial Array ");
        printValue(integer);
        switch (option) {                                                         //Option selection
            case 1:
                sortArray(integer);
                break;

            case 2:
                System.out.println("Enter the Element to be searched");
                int searchElement = sc.nextInt();
                boolean response = searchInArray(integer, searchElement);//calling the method to search and storing the value
                System.out.println(response ? "Element found at index " + searchElementIndex(integer, searchElement) + "" : " Element not found");//printing the index of the search element
                break;
            case 3:
                System.out.println("Enter the Element to be Deleted");
                int delInteger = sc.nextInt();
                deleteElement(integer, delInteger);//calling the method to delete the give element
                System.out.println("Element Deleted");//Display the array after performing the operation
                System.out.print("[");
                for (int i1 = 0; i1 < integer.length - 1; i1++) {
                    System.out.print(integer[i1] + ",");
                }
                System.out.print("]");
                break;
            case 4:
                System.out.println("Enter the element to be inserted and index");
                int insertValue = sc.nextInt();
                int index = sc.nextInt();
                insertElement(integer, insertValue, index, Size);//calling the method to insert the element
                break;
            default:
                System.out.println("Select valid option");
        }


    }

}
