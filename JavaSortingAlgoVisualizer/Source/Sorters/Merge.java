package Source.Sorters;

import Source.*;

import java.util.ArrayList;

public class Merge implements Runnable {
    private Element[] list;
    private MyUI ui;

    public Merge(Element[] list, MyUI ui) {
        this.list = list;
        this.ui = ui;
    }

    public void run() {
        merge_sort(this.list, 0, (this.list.length) - 1);
    }

    public void merge_sort(Element[] array, int l, int r) {
        int middle = (l + r) / 2;
        this.ui.draw_board(this.list);
        if (l < r) {
            merge_sort(array, l, middle);
            merge_sort(array, middle + 1, r);
            merge(array, l, middle, middle + 1, r);
        }
        this.ui.is_sorting = false;
    }

    public void merge(Element[] array, int x1, int y1, int x2, int y2) {
        int i = x1;
        int j = x2;
        ArrayList<Element> temp = new ArrayList<Element>();
        for (Element e : array) {
            e.make_open();
        }
        while (i <= y1 && j <= y2) {
            this.ui.draw_board(this.list);
            if (array[i].value < array[j].value) {
                array[i].reset_color();
                temp.add(array[i]);
                i += 1;
            } else {
                array[j].reset_color();
                temp.add(array[j]);
                j += 1;
            }
        }
        while (i <= y1) {
            array[i].reset_color();
            this.ui.draw_board(this.list);
            temp.add(array[i]);
            i += 1;
        }
        while (j <= y2) {
            array[j].reset_color();
            this.ui.draw_board(this.list);
            temp.add(array[j]);
            j += 1;
        }
        j = 0;
        for (int k = x1; k < y2 + 1; k++) {
            array[k] = temp.get(j);
            j += 1;
            this.ui.draw_board(this.list);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
