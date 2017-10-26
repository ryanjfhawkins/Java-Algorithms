package ca.uwo.eng.se2205.lab6;


public class MergeSorter implements Sorter {

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {

        mergeSort(sort, comparator, 0, sort.size() - 1);

    }

    private <E> void mergeSort(DelayedList<E> sort, DelayedComparator<E> comparator, int startIndex, int endIndex) {

        if (endIndex - startIndex == 0) {
            return;
        } else if (endIndex - startIndex == 1) {
            if (comparator.compare(sort.get(endIndex), sort.get(startIndex)) < 0) {
                E temp = sort.get(startIndex);
                sort.set(startIndex, sort.get(endIndex));
                sort.set(endIndex, temp);
            }
        } else {
            int midIndex = Math.abs((endIndex + startIndex) / 2);

            mergeSort(sort, comparator, startIndex, midIndex);
            mergeSort(sort, comparator, midIndex + 1, endIndex);
            merge(sort, comparator, startIndex, midIndex, endIndex);
        }
    }

    private <E> void merge(DelayedList<E> sort, DelayedComparator<E> comparator, int startIndex, int midIndex, int endIndex) {

        E temp1, temp2;
        int i = startIndex;
        while (i <= midIndex) {
            if (comparator.compare(sort.get(i), sort.get(midIndex + 1)) > 0) {
                temp1 = sort.get(i);
                sort.set(i, sort.get(midIndex + 1));
                sort.set(midIndex + 1, temp1);

                for (int j = midIndex + 1; j < endIndex; j++) {
                    if (comparator.compare(sort.get(j), sort.get(j + 1)) > 0) {
                        temp2 = sort.get(j);
                        sort.set(j, sort.get(j + 1));
                        sort.set(j + 1, temp2);
                    }
                }
            }
            i++;
        }
    }
}
