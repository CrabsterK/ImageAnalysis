public class Point {
    private double coordinateX;
    private double coordinateY;
    private int[] attributes;

    public Point() {
        this.attributes = new int[128];
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }
}
