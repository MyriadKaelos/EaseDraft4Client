import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Ease extends JPanel implements KeyListener, MouseListener {
    int refreshRate;
    private Socket s;
    public BufferedReader in;
    public PrintWriter out;
    boolean start = true;
    public Ease(int refreshRate,boolean server) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Game");
        frame.add(this);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setVisible(true);
        frame.setSize(400,422);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
//        this.height = height/res;
//        this.width = width/res;
//        this.trueHeight = height;
//        this.trueWidth = width;
//        this.res = res;
        this.refreshRate = refreshRate;
        if(server) {
            ServerSocket listener = new ServerSocket(9000);
            System.out.println("Is a server.");
            System.out.println("Listening on " + listener.getLocalPort());
            while (start) {
                try {
                    s = listener.accept();
                    start = false;
                } finally {

                }
            }
        } else {
            while(start) {
                try {
                    s = new Socket("10.137.41.74",9090);
                    start = false;
                } finally {

                }
            }
        }
        System.out.println("Socket instantiated.");
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("In and Out streams instantiated.");
        System.out.println("Repainting...");
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        if(!start) {
            try {
                paint();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(refreshRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
    public void paint() throws IOException {

    }
//    public void pixel(int x, int y, Color color) {
//        g2d.setColor(color);
//        g2d.fillRect(x*res,y*res,res,res);
//    }
//    public void rect(int x, int y, int w, int h, Color color) {
//        g2d.setColor(color);
//        g2d.fillRect(x*res, y*res, w*res, h*res);
//    }
//    public void text(int x, int y, String text,Color textColor) {
//        g2d.setColor(textColor);
//        g2d.drawString(text,x,y);
//    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
