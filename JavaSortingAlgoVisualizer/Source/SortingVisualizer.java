package Source;

import Source.Sorters.*;
import java.lang.Thread;

public class SortingVisualizer {
    private static Thread sortingThread;
    public static MyUI ui;

    public static void main(String[] args) {
        ui = new MyUI(700, 700, "Sorting Algorithm Visualizer");
        ui.draw();
    }

    public static void startSort(String type) {
        if (type == "Bubble") {
            sortingThread = new Thread(new Bubble(ui.numbers, ui));
            sortingThread.start();
        } else if (type == "Merge") {
            sortingThread = new Thread(new Merge(ui.numbers, ui));
            sortingThread.start();
        }

    }

}
