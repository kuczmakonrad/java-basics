package pl.kuczdev.__work_questions.equals_and_hashcode.mine_example_equals;

public class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ColorPoint)) return false;
        ColorPoint cp = (ColorPoint) o;
        return this.getX() == cp.getX() && this.getY() == cp.getY() && this.color.equals(cp.color);
    }
}
