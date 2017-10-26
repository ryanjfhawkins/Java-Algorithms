package ca.uwo.eng.se2205.lab6;


public class SelectionSorter implements Sorter {

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {

        int i, j;
        int index;

        for (i = 0; i < sort.size() - 1; i++) {
            index = i;
            for (j = i + 1; j < sort.size(); j++) {
                if (comparator.compare(sort.get(j), sort.get(index)) < 0) {
                    index = j;
                }
            }
            E temp = sort.get(i);
            sort.set(i, sort.get(index));
            sort.set(index, temp);
        }
    }
}