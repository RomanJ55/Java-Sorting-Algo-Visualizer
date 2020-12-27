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
        // Don't start another sort if there is one going atm
        if (sortingThread == null || !ui.is_sorting) {
            ui.is_sorting = true;
            switch (type) {
                case "Bubble":
                    sortingThread = new Thread(new Bubble(ui.numbers, ui));
                    break;
                case "Merge":
                    sortingThread = new Thread(new Merge(ui.numbers, ui));
                    break;
                case "Quick":
                    sortingThread = new Thread(new Quick(ui.numbers, ui));
                    break;
                case "Heap":
                    sortingThread = new Thread(new Heap(ui.numbers, ui));
                    break;
                case "Insertion":
                    // sortingThread = new Thread(new Insertion(ui.numbers, ui));
                    break;
                default:
                    ui.is_sorting = false;
                    return;
            }
            sortingThread.start();
        }

    }

}
