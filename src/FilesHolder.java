import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FilesHolder {
    private String imgPath1 = "watch2.png";
	private String dataPath1 = "watch2.png.haraff.sift";
    private String imgPath2 = "cd3.png";
    private String dataPath2 = "cd3.png.haraff.sift";
    private Image img1 = null;
    private Image img2 = null;
    private File data1 = null;
    private File data2 = null;

    public FilesHolder() {
    }

    public void prepareFiles() {
        try {
            this.img1 = ImageIO.read(new File(imgPath1));
            this.img2 = ImageIO.read(new File(imgPath2));
            this.data1 = new File(dataPath1);
            this.data2 = new File(dataPath2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImg1() {
        return img1;
    }

    public Image getImg2() {
        return img2;
    }

    public File getData1() {
        return data1;
    }

    public File getData2() {
        return data2;
    }
}
