
class Test {
    public static void main(String[] args) {
        var p1 = new Point(1.0, 2.0);
        var p1_copy1 = new Point(p1) {
            {
                x = 1.0;
                comment = "Hello";
            }
        };
        println(isIdentical(p1, p1_copy1), isSame(p1, p1_copy1)); // false, true
        var p1_copy2 = new Point(p1) {
            {
                x = 4.0;
            }
        };
        println(isIdentical(p1, p1_copy2), isSame(p1, p1_copy2)); // false, false
    }
}