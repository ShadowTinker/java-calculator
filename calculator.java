import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
/**
 * calculator
 */
class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  class OutputBox {
    JPanel p = new JPanel();
    JLabel result = new JLabel("1234567890", SwingConstants.RIGHT);
    JLabel pending = new JLabel("1234567890", SwingConstants.RIGHT);
    public OutputBox () {
      // load customed fonts
      Font smallFont = null;
      Font bigFont = null;
      try {
        smallFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/outputbox/ProFont For Powerline.ttf")).deriveFont(24f);
        bigFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/outputbox/ProFont For Powerline.ttf")).deriveFont(40f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(smallFont);
        ge.registerFont(bigFont);
      } catch (Exception e) {
        
      }
      // add the output box panel
      p.setPreferredSize(new Dimension(200, 250));
      p.setBackground(Color.WHITE);
      p.setLayout(new BorderLayout());
      add(p, BorderLayout.PAGE_START);
      // add 2 labels for showing results of calculating
      result.setPreferredSize(new Dimension(200, 200));
      pending.setPreferredSize(new Dimension(200, 50));
      result.setFont(bigFont);
      pending.setFont(smallFont);
      p.add(result, BorderLayout.SOUTH);
      p.add(pending, BorderLayout.NORTH);
    }
  }
  class FunctionButtons {
    // load icons
    ImageIcon iconClear = new ImageIcon("assets/icons/buttons/CE.png");
    ImageIcon iconClearAll = new ImageIcon("assets/icons/buttons/C.png");
    ImageIcon iconBackspace = new ImageIcon("assets/icons/buttons/backspace.png");
    ImageIcon iconOver = new ImageIcon("assets/icons/buttons/over.png");
    ImageIcon iconSeven = new ImageIcon("assets/icons/buttons/7.png");
    ImageIcon iconEight = new ImageIcon("assets/icons/buttons/8.png");
    ImageIcon iconNine = new ImageIcon("assets/icons/buttons/9.png");
    ImageIcon iconTimes = new ImageIcon("assets/icons/buttons/times.png");
    ImageIcon iconFour = new ImageIcon("assets/icons/buttons/4.png");
    ImageIcon iconFive = new ImageIcon("assets/icons/buttons/5.png");
    ImageIcon iconSix = new ImageIcon("assets/icons/buttons/6.png");
    ImageIcon iconMinus = new ImageIcon("assets/icons/buttons/minus.png");
    ImageIcon iconOne = new ImageIcon("assets/icons/buttons/1.png");
    ImageIcon iconTwo = new ImageIcon("assets/icons/buttons/2.png");
    ImageIcon iconThree = new ImageIcon("assets/icons/buttons/3.png");
    ImageIcon iconPlus = new ImageIcon("assets/icons/buttons/plus.png");
    ImageIcon iconSignal = new ImageIcon("assets/icons/buttons/signal.png");
    ImageIcon iconZero = new ImageIcon("assets/icons/buttons/0.png");
    ImageIcon iconDot = new ImageIcon("assets/icons/buttons/dot.png");
    ImageIcon iconEqual = new ImageIcon("assets/icons/buttons/equal.png");
    // register the panel and buttons
    JPanel p = new JPanel();
    JButton clear = new JButton(iconClear);
    JButton clearAll = new JButton(iconClearAll);
    JButton backspace = new JButton(iconBackspace);
    JButton over = new JButton(iconOver);
    JButton seven = new JButton(iconSeven);
    JButton eight = new JButton(iconEight);
    JButton nine = new JButton(iconNine);
    JButton times = new JButton(iconTimes);
    JButton four = new JButton(iconFour);
    JButton five = new JButton(iconFive);
    JButton six = new JButton(iconSix);
    JButton minus = new JButton(iconMinus);
    JButton one = new JButton(iconOne);
    JButton two = new JButton(iconTwo);
    JButton three = new JButton(iconThree);
    JButton plus = new JButton(iconPlus);
    JButton signal = new JButton(iconSignal);
    JButton zero = new JButton(iconZero);
    JButton dot = new JButton(iconDot);
    JButton equal = new JButton(iconEqual);

    public FunctionButtons () {
      // set basic frame of the button area
      p.setPreferredSize(new Dimension(200, 100));
      p.setBackground(Color.GRAY);
      p.setLayout(new GridLayout(5, 4));
      // add all the buttons into the grid panel
      p.add(clear);
      p.add(clearAll);
      p.add(backspace);
      p.add(over);
      p.add(seven);
      p.add(eight);
      p.add(nine);
      p.add(times);
      p.add(four);
      p.add(five);
      p.add(six);
      p.add(minus);
      p.add(one);
      p.add(two);
      p.add(three);
      p.add(plus);
      p.add(signal);
      p.add(zero);
      p.add(dot);
      p.add(equal);
      add(p, BorderLayout.CENTER);
    }
  }
  public MainFrame (String title) {
    super(title);
    // set basic attributes
    setBounds(500, 30, 530, 800);
    setResizable(false);
    // Add components
    OutputBox output = new OutputBox();
    FunctionButtons buttons = new FunctionButtons();
    setVisible(true);
  }
}
public class calculator {
  public static void main(String[] args) {
    new MainFrame("Calculator");
  }
}