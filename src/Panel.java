import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel {
	private ImageData imageA;
	private ImageData imageB;
	private ArrayList<Pair> pairs;

	public Panel(ImageData imageA, ImageData imageB, ArrayList<Pair> pairs) {
		this.imageA = imageA;
		this.imageB = imageB;
		this.pairs = pairs;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		graphics.drawImage(imageA.getImage(), 0, 0, this);
		graphics.drawImage(imageB.getImage(), imageA.getImage().getWidth(null), 0, this);


		Random random = new Random();
		pairs.forEach(pair -> {
			KeyPoint nearest = pair.getKeyPoint1().getNearestPoint();
			graphics.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
			graphics.drawLine((int) pair.getKeyPoint1().getCoordinateX(), (int) pair.getKeyPoint1().getCoordinateY(),
					(int) (imageA.getImage().getWidth(null) + nearest.getCoordinateX()), (int) nearest.getCoordinateY());
			graphics.fillOval((int) pair.getKeyPoint1().getCoordinateX() - 2, (int) pair.getKeyPoint1().getCoordinateY() - 2, 6, 4);
			graphics.fillOval((int) (imageA.getImage().getWidth(null) + nearest.getCoordinateX()) - 2, (int) nearest.getCoordinateY() - 2, 6, 4);
		});

	}
}
