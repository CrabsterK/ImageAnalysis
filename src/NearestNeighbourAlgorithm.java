import java.util.ArrayList;

public class NearestNeighbourAlgorithm {

	public static ArrayList<Pair> getPairs(ArrayList<KeyPoint> keyPoints1, ArrayList<KeyPoint> keyPoints2) {
		ArrayList<Pair> pairList = new ArrayList<>();
		int pair = 1;
		for (int i = 0; i < keyPoints1.size(); i++) {
			KeyPoint pointB = keyPoints1.get(i).getNearestPoint(keyPoints2);
			KeyPoint pointA = pointB.getNearestPoint(keyPoints1);

			if (keyPoints1.get(i) == pointA){
				pairList.add(new Pair(pointA, pointB));
				System.out.println("Pair " + pair++);
			}
		}
		return pairList;
	}
}
