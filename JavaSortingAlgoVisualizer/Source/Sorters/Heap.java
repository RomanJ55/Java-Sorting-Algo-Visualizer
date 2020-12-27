package Source.Sorters;

import Source.*;

public class Heap implements Runnable {
    private Element[] list;
    private MyUI ui;

    public Heap(Element[] list, MyUI ui) {
        this.list = list;
        this.ui = ui;
    }

    public void run() {
        heap_sort(this.list);
        this.ui.is_sorting = false;
    }

    public void heap_sort(Element[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i > -1; i--) {
            heapify(array, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            Element temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            array[i].reset_color();
            this.ui.draw_board(this.list);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            heapify(array, 0, i);
        }
    }

    public void heapify(Element[] array, int root, int size) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int largest = root;
        if (left < size && array[left].value > array[largest].value) {
            largest = left;
        }
        if (right < size && array[right].value > array[largest].value) {
            largest = right;
        }
        if (largest != root) {
            Element temp1 = array[root];
            array[root] = array[largest];
            array[largest] = temp1;
            this.ui.draw_board(this.list);
            array[largest].make_open();
            array[root].make_open();
            heapify(array, largest, size);
            this.ui.draw_board(this.list);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
