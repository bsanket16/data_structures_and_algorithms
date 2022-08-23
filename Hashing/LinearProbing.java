package Hashing;

import java.util.Arrays;

public class LinearProbing {
    public static void main(String[] args) {
        int[] arr = {9, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999, 99, 999, 9999};
        int hashSize = 100, sizeOfArray = 100;
        System.out.println(Arrays.toString(linearProbing(arr, hashSize, sizeOfArray)));
    }

    static int[] linearProbing(int[] arr, int hashSize, int sizeOfArray) {
        int[] ht = new int[hashSize];
        Arrays.fill(ht, -1);

        int where, count = 0, index = 0;

        while (index < sizeOfArray && count != hashSize) {
            where = ((arr[index] + count) % hashSize);

            if (ht[where] == -1) {
                ht[where] = arr[index];
                index++;
                count = 0;
            } else {
                count++;
            }
        }

        return ht;
    }
}
