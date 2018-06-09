import javax.swing.*;
import java.util.ArrayList;

public class Frame extends JFrame {
	public Frame(ImageData imageA, ImageData imageB, ArrayList<Pair> pairs) {
		JPanel panel = new Panel(imageA, imageB, pairs);
		JScrollPane scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
}
