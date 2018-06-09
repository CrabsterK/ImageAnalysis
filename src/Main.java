import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		FilesHolder fileHolder = new FilesHolder();
		fileHolder.prepareFiles();
		Image img1 = fileHolder.getImg1();
		Image img2 = fileHolder.getImg2();
		File data1 = fileHolder.getData1();
		File data2 = fileHolder.getData2();

		ImageData imageData1 = new ImageData(img1, data1);
		ImageData imageData2 = new ImageData(img2, data2);

		ArrayList<KeyPoint> keyPoints1 = imageData1.getKeyPoints();
		ArrayList<KeyPoint> keyPoints2 = imageData2.getKeyPoints();

		ArrayList<Pair> pairList = NearestNeighbourAlgorithm.getPairs(keyPoints1, keyPoints2);
		System.out.println("Nulber of pairs: " + pairList.size());
		EventQueue.invokeLater(() -> new Frame(imageData1, imageData2, pairList));
	}
}
