package pl.kuczdev.__work_questions.equals_and_hashcode.mine_example_equals;

public class MainTest {
    public static void main(String[] args) {
        Point point = new Point(5,10);
        Point colorPoint = new ColorPoint(5,10, "BLACK");

        System.out.println("point.equals(colorPoint): " + point.equals(colorPoint));
        System.out.println("colorPoint.equals(point): " + colorPoint.equals(point));
    }
}
