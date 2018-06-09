import java.util.ArrayList;

public class KeyPoint {
	private double coordinateX;
	private double coordinateY;
	private int[] attributes = new int[128];
	int id = 0;
	private static int count;
	private KeyPoint nearestPoint;

	public KeyPoint() {
		id=count;
		count++;
	}

	public KeyPoint getNearestPoint(ArrayList<KeyPoint> points) {
		double nearestDistance = 1000000000;
		int nearestPointId = -1;

		for(int i=0; i<points.size(); i++) {
			if (nearestDistance > this.getDistance(points.get(i))) {
				nearestPointId = points.get(i).id;
				nearestDistance = this.getDistance(points.get(i));
			}
		}

		for(int i=0; i<points.size(); i++) {
			if(points.get(i).id==nearestPointId) {
				setNearestPoint(points.get(i));
				return points.get(i);
			}
		}
		return null;
	}

	private double getDistance(KeyPoint kayPoint) {
		return Math.hypot(this.coordinateX - kayPoint.coordinateX, this.coordinateY - kayPoint.coordinateY);
	}

	public KeyPoint getNearestPoint() {
		return nearestPoint;
	}

	public void setNearestPoint(KeyPoint nearestPoint) {
		this.nearestPoint = nearestPoint;
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public void setAttributes(int[] attributes) {
		this.attributes = attributes;
	}
}
