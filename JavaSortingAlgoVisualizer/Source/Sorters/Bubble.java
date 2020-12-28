package Source.Sorters;

import Source.*;

public class Bubble implements Runnable {
    private Element[] list;
    private MyUI ui;

    public Bubble(Element[] list, MyUI ui) {
        this.list = list;
        this.ui = ui;
    }

    public void run() {
        bubble_sort();
        this.ui.is_sorting = false;
    }

    public void bubble_sort() {
        for (Element e : this.list) {
            e.make_open();
        }
        for (int i = 0; i < this.list.length - 1; i++) {
            for (int j = 0; j < this.list.length - i - 1; j++) {
                if (this.list[j].value > this.list[j + 1].value) {
                    this.list[j].reset_color();
                    Element temp = this.list[j];
                    this.list[j] = this.list[j + 1];
                    this.list[j + 1] = temp;
                    this.list[j + 1].reset_color();
                }
                this.ui.draw_board(this.list);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
