import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

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

        








    }
}
