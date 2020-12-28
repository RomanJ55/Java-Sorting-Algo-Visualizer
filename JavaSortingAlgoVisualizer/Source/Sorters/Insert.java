package Source.Sorters;

import Source.*;

public class Insert implements Runnable {
    private Element[] list;
    private MyUI ui;

    public Insert(Element[] list, MyUI ui) {
        this.list = list;
        this.ui = ui;
    }

    public void run() {
        insertion_sort(this.list);
        this.ui.is_sorting = false;
    }

    public void insertion_sort(Element[] array) {
        int n = array.length;
        for (Element e : array) {
            e.make_open();
        }
        for (int i = 1; i < n; i++) {
            Element key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].value > key.value) {
                // shift the elements
                array[j + 1] = array[j];
                j = j - 1;
                array[j + 1].reset_color();
                this.ui.draw_board(this.list);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // insert
            array[j + 1] = key;
            array[j + 1].reset_color();
            this.ui.draw_board(this.list);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
