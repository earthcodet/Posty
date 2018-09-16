import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        MainPosty form = new MainPosty();
        form.setVisible(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image icon = kit.createImage("./image/logo.png");
        form.setIconImage(icon);
        form.setTitle("Posty - main");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setVisible(true);

    }
}
