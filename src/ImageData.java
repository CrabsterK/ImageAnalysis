import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageData {
	private final int FIRST_ATTRIBUTE_IN_FILE = 5;
	private ArrayList<KeyPoint> keyPoints;
	private Image image;

	public ImageData(Image imgage, File file) {
		this.keyPoints = getPointsFromFile(file);
		this.image = imgage;
	}

	private ArrayList<KeyPoint> getPointsFromFile(File file){
		ArrayList<KeyPoint> keyPoints = new ArrayList<>();

		try {
			Scanner sc = new Scanner(file);
			sc.nextLine();
			sc.nextLine();
			while (sc.hasNextLine()) {
				KeyPoint keyPoint = new KeyPoint();

				String line = sc.nextLine();
				String[] splitLine = line.split(" ");
				keyPoint.setCoordinateX(Double.parseDouble(splitLine[0]));
				keyPoint.setCoordinateY(Double.parseDouble(splitLine[1]));

				int[] attributes = new int[128];
				int j = 0;
				for (int i = FIRST_ATTRIBUTE_IN_FILE; i < splitLine.length; i++) {
					attributes[j] = Integer.parseInt(splitLine[i]);
					j++;
				}
				keyPoint.setAttributes(attributes);
				keyPoints.add(keyPoint);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return keyPoints;
	}

	public ArrayList<KeyPoint> getKeyPoints() {
		return keyPoints;
	}

	public Image getImage() {
		return image;
	}
}
