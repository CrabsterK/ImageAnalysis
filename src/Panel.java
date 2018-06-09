import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
	private ImageData img1;
	private ImageData img2;
	private ArrayList<Pair> pairList;

	public Panel(ImageData img1, ImageData img2, ArrayList<Pair> pairList) {
		this.img1 = img1;
		this.img2 = img2;
		this.pairList = pairList;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		graphics.drawImage(img1.getImage(), 0, 0, this);
		graphics.drawImage(img2.getImage(), img1.getImage().getWidth(null), 0, this);

		for (int i = 0; i < pairList.size(); i++){
			KeyPoint nearest = pairList.get(i).getKeyPoint1().getNearestPoint();
			graphics.setColor(new Color((int)(Math.random() * 0x1000000)));
			graphics.drawLine((int) pairList.get(i).getKeyPoint1().getCoordinateX(), (int) pairList.get(i).getKeyPoint1().getCoordinateY(),
					(int) (img1.getImage().getWidth(null) + nearest.getCoordinateX()), (int) nearest.getCoordinateY());
		}
	}
}
