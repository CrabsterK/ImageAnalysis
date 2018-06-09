import javax.swing.*;
import java.util.ArrayList;

public class Frame extends JFrame {
	public Frame(ImageData img1, ImageData img2, ArrayList<Pair> pairList) {
		JPanel panel = new Panel(img1, img2, pairList);
		JScrollPane scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
}
