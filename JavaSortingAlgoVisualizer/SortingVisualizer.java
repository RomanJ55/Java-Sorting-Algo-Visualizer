import java.lang.Thread;

public class SortingVisualizer {
    private static Thread sortingThread;
    public static MyUI frame;

    public static void main(String[] args) {
        frame = new MyUI(700, 700, "Sorting Algorithm Visualizer");
        frame.draw();
    }

    public static void startSort(String type) {
        if (type == "Bubble") {
            sortingThread = new Thread(new Bubble(frame.numbers, frame));
            sortingThread.start();
        } else {
            // todo: other algos ;*
        }

    }

}
