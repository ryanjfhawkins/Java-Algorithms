package ca.uwo.eng.se2205.lab6;


public class QuickSorter implements Sorter {


    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {

        quickSort(sort, comparator, 0, sort.size() - 1);
    }

    public <E> void quickSort(DelayedList<E> sort, DelayedComparator<E> comparator, int startIndex, int endIndex) {

        int index = part(sort,comparator, startIndex,endIndex);

        if (startIndex < index - 1) {
            quickSort(sort, comparator, startIndex, index - 1);
        }

        if (endIndex > index) {
            quickSort(sort, comparator, index, endIndex);
        }
    }

    public static <E> int part(DelayedList<E> sort, DelayedComparator<E> comparator, int ls, int rs){

        E pivot = sort.get(ls);

        while (ls <= rs) {

            while (comparator.compare(sort.get(ls), pivot) < 0) {
                ls++;
            }

            while (comparator.compare(sort.get(rs), pivot) > 0) {
                rs--;
            }

            if (ls <= rs) {
                E temp = sort.get(ls);
                sort.set(ls, sort.get(rs));
                sort.set(rs, temp);

                ls++;
                rs--;
            }
        }
        return ls;
    }
}


