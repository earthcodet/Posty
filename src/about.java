import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class about extends JFrame {
    private JPanel mainPanel;
    private JLabel imagelogo;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JButton OKButton;

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    about(){
        add(mainPanel);
        setSize(350,500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Label1.setText("โปรแกรม Posty");
        Label2.setText("เวอร์ชั่น : 1.0.0.1");
        Label3.setText("โปรแกรมนี้เป็น Open source");
        Label4.setText("สถานที่ตั้ง ประเทศไทย");
        Label5.setText("โปรแกรมจัดทำโดย BUU Wifi by AIS");

        ImageIcon icon = new ImageIcon("./image/logo.png");
        imagelogo.setBounds(200,200,152,152);
        int offset = imagelogo.getInsets().left;
        imagelogo.setIcon(resizeIcon(icon, imagelogo.getWidth() - offset, imagelogo.getHeight() - offset));
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
    }

}
