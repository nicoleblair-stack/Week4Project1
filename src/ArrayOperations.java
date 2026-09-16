import java.util.Arrays;

public class ArrayOperations {

    // a) Swap the first and the last elements in the array
    public static void swapFirstAndLast(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two elements to swap.");
            return;
        }
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    // b) Remove the middle element if the array length is odd or the middle two elements if the length is even
    public static int[] removeMiddleElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int newLength;
        if (arr.length % 2 != 0) { // Odd length
            if (arr.length == 1) { // If only one element, removing it makes array empty
                return new int[0];
            }
            newLength = arr.length - 1;
        } else { // Even length
            if (arr.length == 2) { // If two elements, removing them makes array empty
                return new int[0];
            }
            newLength = arr.length - 2;
        }

        int[] newArr = new int[newLength];
        int middleIndex = arr.length / 2;

        if (arr.length % 2 != 0) { // Odd length
            System.arraycopy(arr, 0, newArr, 0, middleIndex);
            System.arraycopy(arr, middleIndex + 1, newArr, middleIndex, arr.length - (middleIndex + 1));
        } else { // Even length
            System.arraycopy(arr, 0, newArr, 0, middleIndex - 1);
            System.arraycopy(arr, middleIndex + 1, newArr, middleIndex - 1, arr.length - (middleIndex + 1));
        }
        return newArr;
    }

    // c) Return true if the array contains two adjacent duplicate elements
    public static boolean hasAdjacentDuplicates(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // d) Return the second largest element in the array
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two elements to find the second largest.");
            return Integer.MIN_VALUE; // Sentinel value indicating an error or no second largest found
        }

        // Sort the array to easily find the second largest
        Arrays.sort(arr);

        // Iterate backwards from the second to last element
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }
        System.out.println("All elements are the same, or no distinct second largest found.");
        return Integer.MIN_VALUE; // Sentinel value if no distinct second largest is found
    }

    // e) Return the sum of the elements in the array
    public static int sumArrayElements(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Test program
    public static void main(String[] args) {
        // Test case a: Swap first and last elements
        int[] arrA = {1, 2, 3, 4, 5};
        System.out.println("Original array for swap: " + Arrays.toString(arrA));
        swapFirstAndLast(arrA);
        System.out.println("Array after swap: " + Arrays.toString(arrA));
        System.out.println("-----");

        // Test case b: Remove middle elements (odd length)
        int[] arrB1 = {1, 2, 3, 4, 5};
        System.out.println("Original array for remove middle (odd): " + Arrays.toString(arrB1));
        int[] resultB1 = removeMiddleElements(arrB1);
        System.out.println("Array after removing middle (odd): " + Arrays.toString(resultB1));
        System.out.println("-----");

        // Test case b: Remove middle elements (even length)
        int[] arrB2 = {10, 20, 30, 40, 50, 60};
        System.out.println("Original array for remove middle (even): " + Arrays.toString(arrB2));
        int[] resultB2 = removeMiddleElements(arrB2);
        System.out.println("Array after removing middle (even): " + Arrays.toString(resultB2));
        System.out.println("-----");

        // Test case b: Removing middle from a single-element array (edge case)
        int[] arrB3 = {100};
        System.out.println("Original array for remove middle (single element): " + Arrays.toString(arrB3));
        int[] resultB3 = removeMiddleElements(arrB3);
        System.out.println("Array after removing middle (single element): " + Arrays.toString(resultB3));
        System.out.println("-----");

        // Test case b: Removing middle from a two-element array (edge case)
        int[] arrB4 = {1, 2};
        System.out.println("Original array for remove middle (two elements): " + Arrays.toString(arrB4));
        int[] resultB4 = removeMiddleElements(arrB4);
        System.out.println("Array after removing middle (two elements): " + Arrays.toString(resultB4));
        System.out.println("-----");

        // Test case c: Check for adjacent duplicates
        int[] arrC1 = {1, 2, 2, 4, 5};
        System.out.println("Original array for adjacent duplicates: " + Arrays.toString(arrC1));
        System.out.println("Has adjacent duplicates: " + hasAdjacentDuplicates(arrC1));
        System.out.println("-----");

        int[] arrC2 = {1, 2, 3, 4, 5};
        System.out.println("Original array for adjacent duplicates: " + Arrays.toString(arrC2));
        System.out.println("Has adjacent duplicates: " + hasAdjacentDuplicates(arrC2));
        System.out.println("-----");

        // Test case d: Find second largest element
        int[] arrD1 = {1, 7, 3, 9, 5};
        System.out.println("Original array for second largest: " + Arrays.toString(arrD1));
        System.out.println("Second largest element: " + findSecondLargest(arrD1));
        System.out.println("-----");

        int[] arrD2 = {5, 5, 5, 5, 5};
        System.out.println("Original array for second largest (all same): " + Arrays.toString(arrD2));
        System.out.println("Second largest element: " + findSecondLargest(arrD2)); // Will print an error message
        System.out.println("-----");

        // Test case e: Sum of array elements
        int[] arrE1 = {10, 20, 30, 40, 50};
        System.out.println("Original array for sum: " + Arrays.toString(arrE1));
        System.out.println("Sum of elements: " + sumArrayElements(arrE1));
        System.out.println("-----");
    }
}
