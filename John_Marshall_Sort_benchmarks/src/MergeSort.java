public class MergeSort {

    /* ---------------- !! MERGESORT TAKEN DIRECTLY FROM MERGESORT DEMO  !!! ________________________________________*/
    public static void mergeSort(int[] intArray, int[] temp, int low, int high){
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted

        int mid;//middle value for middle index

        //condition so that it will stop when the indexes are the same
        if (high > low){
            mid = (high+low)/2; // find middle
            //break up into two areas
            mergeSort(intArray, temp, low, mid);
            mergeSort(intArray, temp, mid+1, high);
            merge(intArray, temp, low, mid, high);
        }
        return;
    }

    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     *
     * The work of sorting occurs as the two halves are merged back into one
     * sorted set.
     *
     * This version of mergesort copies the set to be sorted into the same
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */

    private static void merge(int[] intArray, int[] temp, int low, int mid, int high){

        //copy array into temp array
        for (int i = low; i <= high; i++) {
            temp[i] = intArray[i];
        }

        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        while ((lowP <= mid) && (highP <= high)) {

            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                intArray[aP] = temp[lowP];
                lowP++;

            } else {

                // move item at highP back to array a and increment high pointer
                intArray[aP] = temp[highP];
                highP++;
            }

            // increment pointer for location in original array
            aP++;
        }


        /* When the while loop is done, either the low half or the high half is done
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid)

            for (int i = highP; i <= high; i++) {

                intArray[aP] = temp[i];
                aP++;

            // high half is done, move rest of low half
            }else {

            for (int i = lowP; i <= mid; i++) {  // Begin  for (int i = lowP; i <= mid; i++)

                intArray[aP] = temp[i];
                aP++;

            }

        return;
        }
    }

}
