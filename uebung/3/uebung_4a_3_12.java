class Point {
    double x;
    double y;
    String comment;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p)
    {
        this.x = p.x;
        this.y = p.y;
        this.comment = p.comment;
    }
}

public class uebung_4a_3_12 {
    static boolean isIdentical(Point p1, Point p2) {
        return p1 == p2;
    }

    static boolean isSame(Point p1, Point p2) {
        return (p1.x == p2.x) && (p1.y == p2.y);
    }

    public static void main(String[] args) {
        var p1 = new Point(1.0, 2.0);

        var p1_copy1 = new Point(p1) {{ x = 1.0; comment = "Hello"; }};
        System.out.println(isIdentical(p1, p1_copy1) + " " + isSame(p1, p1_copy1)); // false, true

        var p1_copy2 = new Point(p1) {{ x = 4.0; }};
        System.out.println(isIdentical(p1, p1_copy2) + " " + isSame(p1, p1_copy2)); // false, false
    }
}