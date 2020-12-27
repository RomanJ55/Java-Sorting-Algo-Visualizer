package Source;

import java.awt.Color;

public class Element {
    public int value;
    public Color color;

    public Element(int value) {
        this.value = value;
        this.color = Color.BLUE;
    }

    public Color get_color() {
        return this.color;
    }

    public void reset_color() {
        this.color = Color.BLUE;
    }

    public void make_open() {
        this.color = Color.RED;
    }

    public boolean is_open() {
        if (this.color == Color.RED) {
            return true;
        }
        return false;
    }

    public void reset() {
        reset_color();
        this.value = 0;
    }

    public void set_value(int value) {
        this.value = value;
    }
}
