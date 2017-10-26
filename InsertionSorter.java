package ca.uwo.eng.se2205.lab6;

public class InsertionSorter implements Sorter {


    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {

        int i, j;
        int index;

        for (i = 0; i < sort.size(); i++){
            index = i;
            for (j = i + 1; j < sort.size(); j++) {
                if (comparator.compare(sort.get(index), sort.get(j)) > 0) {
                    sort.add(i, sort.remove(j));
                }

            }
        }


    }

}
