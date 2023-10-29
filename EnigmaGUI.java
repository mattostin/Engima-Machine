import javax.swing.SwingUtilities;

public class EnigmaGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EnigmaFrame frame = new EnigmaFrame();
                frame.setVisible(true);
            }
        });
    }
}
