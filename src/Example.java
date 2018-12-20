import java.awt.event.KeyEvent;
import java.io.IOException;

public class Example extends Ease{
    public Example(int refreshRate,boolean server) throws InterruptedException, IOException {
        super(refreshRate,server);
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        Example c = new Example(100,true);
    }
    public void paint() throws IOException {
        if(!start) {

        }
    }

    public void keyPressed(KeyEvent e) {
        System.err.println("HEEY");
        if(e.getKeyChar() == 'a') {
            out.print(e.getKeyCode());
        } else if(e.getKeyChar() == 's') {
            try {
                System.out.println(in.read());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
