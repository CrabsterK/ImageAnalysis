import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageData {

    private Image image;
    private ArrayList<Point> points;
    private final int FIRST_ATTRIBUTE_IN_FILE = 5;

    public ImageData(Image image, File file) {
        this.image = image;
        this.points = getPointsFromFile(file);
    }

    private ArrayList<Point> getPointsFromFile(File file){
        ArrayList<Point> pointsTmp = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                Point point = new Point();

                String line = sc.nextLine();
                String[] splitLine = line.split(" ");
                point.setCoordinateX(Double.parseDouble(splitLine[0]));
                point.setCoordinateY(Double.parseDouble(splitLine[1]));

                int[] attributes = new int[128];
                int j = 0;
                for (int i = FIRST_ATTRIBUTE_IN_FILE; i < splitLine.length; i++) {
                    attributes[j] = Integer.parseInt(splitLine[i]);
                    j++;
                }
                point.setAttributes(attributes);
                pointsTmp.add(point);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pointsTmp;
    }
}
