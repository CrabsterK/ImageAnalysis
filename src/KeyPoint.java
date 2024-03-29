import java.util.ArrayList;

public class KeyPoint {
	private double coordinateX;
	private double coordinateY;
	private int[] attributes = new int[128];
	private KeyPoint nearestPoint;

	public KeyPoint() {
	}

	public KeyPoint getNearestPoint(ArrayList<KeyPoint> keyPoints) {
		double nearestDistance = Double.MAX_VALUE;
		for (int i = 0; i < keyPoints.size(); i++) {
			if (nearestDistance > this.getDistance(keyPoints.get(i))) {
				nearestDistance = this.getDistance(keyPoints.get(i));
				setNearestPoint(keyPoints.get(i));
			}
		}
		return getNearestPoint();
	}

	private double getDistance(KeyPoint kayPoint) {
		double sum = 0;
		for (int i = 0; i < attributes.length; i++){
			sum += Math.pow(attributes[i] - kayPoint.getAttributes()[i], 2);
		}
		return sum;
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

	public int[] getAttributes() {
		return attributes;
	}
}
