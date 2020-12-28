package Source;

import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyUI {
    int width;
    int height;
    String title;
    JFrame frame;
    Element[] numbers;
    public boolean is_sorting;

    public MyUI(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.numbers = new Element[50];
        this.is_sorting = false;

        this.frame = new JFrame(this.title);
        this.frame.setSize(this.width, this.height);
        this.frame.setLocation(650, 100);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {

    }

    public void draw() {
        // draw_board(this.numbers);
        draw_buttonarea();
    }

    public void draw_buttonarea() {
        JPanel button_panel = new JPanel();
        button_panel.setBounds(10, this.height - 80, this.width - 35, 35);
        button_panel.setBackground(Color.GRAY);

        JButton but1 = new JButton("Generate Array");
        JButton but2 = new JButton("Merge sort");
        JButton but3 = new JButton("Quick sort");
        JButton but4 = new JButton("Bubble sort");
        JButton but5 = new JButton("Heap sort");
        JButton but6 = new JButton("Insertion sort");

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only generate a new array if we aren't sorting one atm
                if (!is_sorting) {
                    populate_board();
                    draw_board(numbers);
                }
            }
        });

        // adding actionListeners to our sorting-buttons
        add_buttonaction(but2, "Merge");
        add_buttonaction(but3, "Quick");
        add_buttonaction(but4, "Bubble");
        add_buttonaction(but5, "Heap");
        add_buttonaction(but6, "Insert");

        button_panel.add(but1);
        button_panel.add(but2);
        button_panel.add(but3);
        button_panel.add(but4);
        button_panel.add(but5);
        button_panel.add(but6);

        this.frame.add(button_panel);
    }

    public void add_buttonaction(JButton button, String keyword) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingVisualizer.startSort(keyword);
            }
        });
    }

    public void draw_board(Element[] list) {
        JPanel main_panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(9));
                for (int i = 0; i < list.length; i++) {
                    Element h = list[i];
                    g2d.setColor(list[i].get_color());
                    g2d.drawLine(13 * i + 15, 609, 13 * i + 15, 609 - (h.value * 12));
                }
            }
        };
        main_panel.setBounds(10, 5, this.width - 35, this.height - 90);
        main_panel.setBackground(Color.LIGHT_GRAY);
        this.frame.add(main_panel);

        this.frame.revalidate();
        this.frame.repaint();
    }

    public void populate_board() {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            this.numbers[i] = new Element(i);
        }
        // shuffle
        for (int i = 0; i < this.numbers.length; i++) {
            int randomIndexToSwap = rand.nextInt(this.numbers.length);
            Element temp = this.numbers[randomIndexToSwap];
            this.numbers[randomIndexToSwap] = this.numbers[i];
            this.numbers[i] = temp;
        }
    }

}
