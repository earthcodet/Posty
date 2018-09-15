import com.mongodb.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;

public class MainPosty {
        private JButton postsButton;
        private JButton homeButton;
        private JButton loginRegisterButton;
        private JPanel mainPanel;
        private JLabel imagelogo;
    private JLabel Lb1;
    private JLabel Lb2;
    private JLabel Lb3;
    private JLabel Lb4;
    private JLabel Lb5;
    private JPanel room;
    private JButton btnroom;
    private JTextField tfSe;
    private JPanel panelroom;
    private JTable table;
    private JButton selectButton;
    private JLabel lprocess;
    private JProgressBar progressBar;
    private JLabel status;
    static int countroom=0;
    static Thread thread = new Thread();
    static ArrayList<String> tempID = new ArrayList<String>() ;

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    public  MainPosty(){
        ImageIcon icon = new ImageIcon("./image/logo.png");
        imagelogo.setBounds(200,200,40,40);
        int offset = imagelogo.getInsets().left;
        imagelogo.setIcon(resizeIcon(icon, imagelogo.getWidth() - offset, imagelogo.getHeight() - offset));
        icon = new ImageIcon("./image/love.png");
        Lb1.setBounds(200,200,40,40);
        offset = Lb1.getInsets().left;
        Lb1.setIcon(resizeIcon(icon, Lb1.getWidth() - offset, Lb1.getHeight() - offset));
        icon = new ImageIcon("./image/Game.png");
        Lb2.setBounds(200,200,40,40);
        offset = Lb2.getInsets().left;
        Lb2.setIcon(resizeIcon(icon, Lb2.getWidth() - offset, Lb2.getHeight() - offset));
        icon = new ImageIcon("./image/Food.png");
        Lb3.setBounds(200,200,40,40);
        offset = Lb3.getInsets().left;
        Lb3.setIcon(resizeIcon(icon, Lb3.getWidth() - offset, Lb3.getHeight() - offset));
        icon = new ImageIcon("./image/Cat.png");
        Lb4.setBounds(200,200,40,40);
        offset = Lb4.getInsets().left;
        Lb4.setIcon(resizeIcon(icon, Lb4.getWidth() - offset, Lb4.getHeight() - offset));
        icon = new ImageIcon("./image/catoon.png");
        Lb5.setBounds(200,200,40,40);
        offset = Lb5.getInsets().left;
        Lb5.setIcon(resizeIcon(icon, Lb5.getWidth() - offset, Lb5.getHeight() - offset));
            /* Start*/

        try {
            MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds046677.mlab.com:46677/posty");
            MongoClient client = new MongoClient(uri);
            DB db = client.getDB("posty");
            try {
                db.getCollection("post");
            } catch (Exception exp) {
                db.createCollection("username", null);
            }
            DBCollection collection = db.getCollection("post");

            //
            JTableHeader header = table.getTableHeader();
            header.setFont(new Font("Tahoma",Font.BOLD,15));
            table.setRowHeight(40);
            DBCursor cursor = null;
            cursor = collection.find();
            String[] columnNames = {"ห้องที่","ชื่อเรื่อง","ห้องของ", "จำนวนคอมเม้น","จำนวนยอดวิว"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            model.addRow(new Object[] { "ห้องที่","ชื่อเรื่อง","ห้องของ", "จำนวนคอมเม้น","จำนวนยอดวิว"});
            int run = 1 ;
            while(cursor.hasNext()) {
                try{
                    DBObject obj = cursor.next();
                    Object id = obj.get("_id");
                    tempID.add(id+"");
                    String topic = (String)obj.get("topic");
                    String name = (String)obj.get("roomowner");
                    int topview = (int)obj.get("topview");
                    int countcomment = (int)obj.get("countcomment");
                    model.addRow(new Object[] { run,topic,name,topview,countcomment});
                    run++;
                }
                catch(Exception e){
                    System.out.println("E "+e);
                }
            }

            table.setModel(model);

            cursor.close();





            //
            client.close();
        }catch (Exception exp){
            System.out.println(exp);
        }
        /* Stop */





        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(countroom==0){
                    room.setVisible(true);
                    countroom++;
                }else{
                    room.setVisible(false);
                    countroom--;
                }

            }
        });


        tfSe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){

                    tfSe.setText("");

                }
            }
        });

        tfSe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfSe.setText("");
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    MongoClientURI uri = new MongoClientURI("mongodb://admin:admin1234@ds046677.mlab.com:46677/posty");
                    MongoClient client = new MongoClient(uri);
                    DB db = client.getDB("posty");
                    try {
                        db.getCollection("post");
                    } catch (Exception exp) {
                        db.createCollection("username", null);
                    }
                    DBCollection collection = db.getCollection("post");

                    //
                    DBCursor cursor = null;
                    cursor = collection.find();
                    String[] columnNames = {"ห้องที่","ชื่อเรื่อง","ห้องของ", "จำนวนคอมเม้น","จำนวนยอดวิว"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    model.addRow(new Object[] { "ห้องที่","ชื่อเรื่อง","ห้องของ", "จำนวนคอมเม้น","จำนวนยอดวิว"});
                    removeArray();
                    int run =1;
                    while(cursor.hasNext()) {
                        try{
                            DBObject obj = cursor.next();
                            Object id = obj.get("_id");
                            tempID.add(id+"");
                            String topic = (String)obj.get("topic");
                            String name = (String)obj.get("roomowner");
                            int topview = (int)obj.get("topview");
                            int countcomment = (int)obj.get("countcomment");
                            model.addRow(new Object[] { run,topic,name,topview,countcomment});
                            run ++;
                        }
                        catch(Exception exp){
                            System.out.println("E "+exp);
                        }
                    }
                    table.setModel(model);
                    cursor.close();

                    client.close();



                }catch (Exception exp){
                    System.out.println(exp);
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if(row!=0)
                status.setText("./Posty/post/"+tempID.get(row-1));
            }
        });
        table.addMouseListener(new MouseAdapter() {
           
        });
    }
    public static void removeArray(){
while(!tempID.isEmpty()){
    tempID.remove(0);
}

    }



    public static void main(String[] args)  {
        JFrame frame = new JFrame("Posty - Home");
        MainPosty form = new MainPosty();
        frame.setContentPane(form.mainPanel);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image icon = kit.createImage("./image/logo.png");
        frame.setIconImage(icon);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000,800));
        frame.setVisible(true);
    }


}

