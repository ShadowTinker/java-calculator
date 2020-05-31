import java.awt.*;
import javax.swing.*;
/**
 * calculator
 */
class MainFrame extends JFrame {
  static JPanel p = new JPanel();
  public MainFrame (String title) {
    super(title);
    setBounds(0, 0, 600, 600);
    setResizable(false);
    setVisible(true);
    p.setBounds(58, 50, 100, 100);
    p.setBackground(Color.black);
    // setLayout(null);
    this.add(p);
  }
}
public class calculator {
  public static void main(String[] args) {
    new MainFrame("Calculator");
  }
}