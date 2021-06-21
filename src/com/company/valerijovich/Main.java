package com.company.valerijovich;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(9999);
        }

        System.out.print("Initial array is: ");
        System.out.println(arrayToString(array));

        for (int step = 0; step < array.length; step++) {
            int minIndex = min(array, step);

            if (array[step] > array[minIndex]) {
                int temp = array[minIndex];
                array[minIndex] = array[step];
                array[step] = temp;
            }
        }

        System.out.print("Sorted array is: ");
        System.out.println(arrayToString(array));
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];

        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minIndex = i;
                minValue = array[i];
            }
        }

        return minIndex;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0)
                sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
