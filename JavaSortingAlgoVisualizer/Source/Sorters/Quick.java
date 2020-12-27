package Source.Sorters;

import Source.*;

public class Quick implements Runnable {
    private Element[] list;
    private MyUI ui;

    public Quick(Element[] list, MyUI ui) {
        this.list = list;
        this.ui = ui;
    }

    public void run() {
        quick_sort(this.list, 0, (this.list.length) - 1);
        this.ui.is_sorting = false;
    }

    public void quick_sort(Element[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quick_sort(array, low, pi - 1);
            for (Element e : array) {
                e.reset_color();
            }
            this.ui.draw_board(this.list);
            quick_sort(array, pi + 1, high);
        }
    }

    public int partition(Element[] array, int low, int high) {
        int i = (low - 1);
        Element pivot = array[high];
        int jtemp = 0;
        for (int j = low; j < high; j++) {
            this.ui.draw_board(this.list);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (array[j].value <= pivot.value) {
                array[j].make_open();
                i += 1;
                Element temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            jtemp = j;
        }
        array[jtemp].reset_color();
        this.ui.draw_board(this.list);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Element temp1 = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp1;
        return i + 1;
    }
}
