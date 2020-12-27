public class Bubble implements Runnable {
    private int[] array;
    private MyUI frame;

    public Bubble(int[] array, MyUI frame) {
        this.array = array;
        this.frame = frame;
    }

    public void run() {
        bubble_sort();
    }

    public void bubble_sort() {
        for (int i = 0; i < this.array.length - 1; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    int temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                }
                this.frame.draw_board(this.array);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.frame.is_sorting = false;
    }
}
