import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
/**
 * calculator
 */
class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  // load icons
  ImageIcon iconCalculator = new ImageIcon("assets/icons/calculator.png");
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
  JPanel buttonPanel = new JPanel();
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

  // load customed fonts
  Font smallFont = null;
  Font bigFont = null;
  // register components for output box
  JPanel outputBoxPanel = new JPanel();
  JLabel result = new JLabel("", SwingConstants.RIGHT);
  JLabel pending = new JLabel("", SwingConstants.RIGHT);
  // add some variables to implement the calculation function
  String resultShow = "";
  String pendingShow = "";
  boolean isInitialized = false; // this is used to judge whether the first input is initialized
  Double first = null; // this is the left operand of the equation
  Double second = null; // this is the right operand of the equation
  char lastOperator = '0';
  public void  addOutputBox () {
    try {
      smallFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/outputbox/ProFont For Powerline.ttf")).deriveFont(24f);
      bigFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/outputbox/ProFont For Powerline.ttf")).deriveFont(40f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(smallFont);
      ge.registerFont(bigFont);
    } catch (Exception e) {
      
    }
    // add the output box panel
    outputBoxPanel.setPreferredSize(new Dimension(200, 250));
    outputBoxPanel.setBackground(Color.WHITE);
    outputBoxPanel.setLayout(new BorderLayout());
    add(outputBoxPanel, BorderLayout.PAGE_START);
    // add 2 labels for showing results of calculating
    result.setPreferredSize(new Dimension(200, 200));
    pending.setPreferredSize(new Dimension(200, 50));
    result.setFont(bigFont);
    pending.setFont(smallFont);
    outputBoxPanel.add(result, BorderLayout.SOUTH);
    outputBoxPanel.add(pending, BorderLayout.NORTH);
  }
  public void addButtons () {
    // set basic frame of the button area
    buttonPanel.setPreferredSize(new Dimension(200, 100));
    buttonPanel.setBackground(Color.GRAY);
    buttonPanel.setLayout(new GridLayout(5, 4));
    // add all the buttons into the grid buttonPanelanel
    buttonPanel.add(clear);
    buttonPanel.add(clearAll);
    buttonPanel.add(backspace);
    buttonPanel.add(over);
    buttonPanel.add(seven);
    buttonPanel.add(eight);
    buttonPanel.add(nine);
    buttonPanel.add(times);
    buttonPanel.add(four);
    buttonPanel.add(five);
    buttonPanel.add(six);
    buttonPanel.add(minus);
    buttonPanel.add(one);
    buttonPanel.add(two);
    buttonPanel.add(three);
    buttonPanel.add(plus);
    buttonPanel.add(signal);
    buttonPanel.add(zero);
    buttonPanel.add(dot);
    buttonPanel.add(equal);
    add(buttonPanel, BorderLayout.CENTER);
  }
  public void contanenatePending (String text) {
    pending.setText(pending.getText() + text);
  }
  public void setResult (String text) {
    result.setText(text);
  }
  class buttonOne implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 1.0;
        } else {
          first = first * 10 + 1;
        }
      } else {
        if (second == null) {
          second = 1.0;
        } else {
          second = second * 10 + 1;
        }
      }
      contanenatePending("1");
    }
  }
  class buttonTwo implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 2.0;
        } else {
          first = first * 10 + 2;
        }
      } else {
        if (second == null) {
          second = 2.0;
        } else {
          second = second * 10 + 2;
        }
      }
      contanenatePending("2");
    }
  }
  class buttonThree implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 3.0;
        } else {
          first = first * 10 + 3;
        }
      } else {
        if (second == null) {
          second = 3.0;
        } else {
          second = second * 10 + 3;
        }
      }
      contanenatePending("3");
    }
  }
  class buttonFour implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 4.0;
        } else {
          first = first * 10 + 4;
        }
      } else {
        if (second == null) {
          second = 4.0;
        } else {
          second = second * 10 + 4;
        }
      }
      contanenatePending("4");
    }
  }
  class buttonFive implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 5.0;
        } else {
          first = first * 10 + 5;
        }
      } else {
        if (second == null) {
          second = 5.0;
        } else {
          second = second * 10 + 5;
        }
      }
      contanenatePending("5");
    }
  }
  class buttonSix implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 6.0;
        } else {
          first = first * 10 + 6;
        }
      } else {
        if (second == null) {
          second = 6.0;
        } else {
          second = second * 10 + 6;
        }
      }
      contanenatePending("6");
    }
  }
  class buttonSeven implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 7.0;
        } else {
          first = first * 10 + 7;
        }
      } else {
        if (second == null) {
          second = 7.0;
        } else {
          second = second * 10 + 7;
        }
      }
      contanenatePending("7");
    }
  }
  class buttonEight implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 8.0;
        } else {
          first = first * 10 + 8;
        }
      } else {
        if (second == null) {
          second = 8.0;
        } else {
          second = second * 10 + 8;
        }
      }
      contanenatePending("8");
    }
  }
  class buttonNine implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 9.0;
        } else {
          first = first * 10 + 9;
        }
      } else {
        if (second == null) {
          second = 9.0;
        } else {
          second = second * 10 + 9;
        }
      }
      contanenatePending("9");
    }
  }
  class buttonZero implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
        } else {
          first = first * 10;
        }
      } else {
        if (second == null) {
          second = 0.0;
        } else {
          second = second * 10;
        }
      }
      contanenatePending("0");
    }
  }
  class buttonPlus implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
        }
        isInitialized = true;
      } else {
        if (second == null) {
          if (lastOperator == '*') {
            first = 0.0;
            contanenatePending("0");
          } else if (lastOperator == '/') {
            setError("You cannot divide a 0");
            return;
          }
        } else {
          switch (lastOperator) {
            case '+': {
              first += second;
              break;
            }
            case '-': {
              first -= second;
              break;
            }
            case '*': {
              first *= second;
              break;
            }
            case '/': {
              if (Math.abs(second) < 0.0000001) {
                setError("You cannot divide a 0");
                return;
              } else {
                first /= second;
              }
              break;
            }
            default: {
              first += second;
              break;
            }
          }
        }
        second = null;
        setResult(Double.toString(first));
      }
      lastOperator = '+';
      contanenatePending("+");
    }
  }
  class buttonMinus implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
        }
        isInitialized = true;
      } else {
        if (second == null) {
          if (lastOperator == '*') {
            first = 0.0;
            contanenatePending("0");
          } else if (lastOperator == '/') {
            setError("You cannot divide a 0");
            return;
          }
        } else {
          switch (lastOperator) {
            case '+': {
              first += second;
              break;
            }
            case '-': {
              first -= second;
              break;
            }
            case '*': {
              first *= second;
              break;
            }
            case '/': {
              if (Math.abs(second) < 0.0000001) {
                setError("You cannot divide a 0");
                return;
              } else {
                first /= second;
              }
              break;
            }
            default: {
              first -= second;
              break;
            }
          }
        }
        second = null;
        setResult(Double.toString(first));
      }
      lastOperator = '-';
      contanenatePending("-");
    }
  }
  class buttonTimes implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
          contanenatePending("0");
        }
        isInitialized = true;
      } else {
        if (second == null) {
          if (lastOperator == '*') {
            first = 0.0;
            contanenatePending("0");
          } else if (lastOperator == '/') {
            setError("You cannot divide a 0");
            return;
          }
        } else {
          switch (lastOperator) {
            case '+': {
              first += second;
              break;
            }
            case '-': {
              first -= second;
              break;
            }
            case '*': {
              first *= second;
              break;
            }
            case '/': {
              if (Math.abs(second) < 0.0000001) {
                setError("You cannot divide a 0");
                return;
              } else {
                first /= second;
              }
              break;
            }
            default: {
              first *= second;
              break;
            }
          }
        }
        second = null;
        setResult(Double.toString(first));
      }
      lastOperator = '*';
      contanenatePending("*");
    }
  }
  class buttonOver implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
          contanenatePending("0");
        }
        isInitialized = true;
      } else {
        if (second == null) {
          if (lastOperator == '*') {
            first = 0.0;
            contanenatePending("0");
          } else if (lastOperator == '/') {
            setError("You cannot divide a 0");
            return;
          }
        } else {
          switch (lastOperator) {
            case '+': {
              first += second;
              break;
            }
            case '-': {
              first -= second;
              break;
            }
            case '*': {
              first *= second;
              break;
            }
            case '/': {
              if (Math.abs(second) < 0.0000001) {
                setError("You cannot divide a 0");
                return;
              } else {
                first /= second;
              }
              break;
            }
            default: {
              first /= second;
              break;
            }
          }
        }
        second = null;
        setResult(Double.toString(first));
      }
      lastOperator = '/';
      contanenatePending("/");
    }
  }
  class buttonEqual implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      if (!isInitialized) {
        if (first == null) {
          first = 0.0;
          setResult("0");
          contanenatePending("0");
        }
        isInitialized = true;
      } else {
        if (second == null) {
          if (lastOperator == '*') {
            first = 0.0;
          } else if (lastOperator == '/') {
            setError("You cannot divide a 0");
          }
          contanenatePending("0");
        } else {
          switch (lastOperator) {
            case '+': {
              first += second;
              break;
            }
            case '-': {
              first -= second;
              break;
            }
            case '*': {
              first *= second;
              break;
            }
            case '/': {
              if (Math.abs(second) < 0.0000001) {
                setError("You cannot divide a 0");
              } else {
                first /= second;
              }
              break;
            }
            default: {
              first /= second;
              break;
            }
          }
        }
        second = null;
        setResult(Double.toString(first));
      }
      pending.setText("");
      second = null;
      isInitialized = false;
      lastOperator = '=';
    }
  }
  class buttonClear implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      String current = pending.getText();
      if (!isInitialized || lastOperator == '=') {
        pending.setText("");
        result.setText("");
        first = null;
        second = null;
        isInitialized = false;
        lastOperator = '0';
      } else {
        for (int j = current.length() - 1; j >= 0; j--) {
          if (current.charAt(j) == '+') {
            pending.setText(current.substring(0, j + 1));
            second = null;
            break;
          } else if (current.charAt(j) == '-') {
            pending.setText(current.substring(0, j + 1));
            second = null;
            break;
          } else if (current.charAt(j) == '*') {
            pending.setText(current.substring(0, j + 1));
            second = null;
            break;
          } else if (current.charAt(j) == '/') {
            pending.setText(current.substring(0, j + 1));
            second = null;
            break;
          }
        }
      }
    }
  }
  class buttonClearAll implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      pending.setText("");
      result.setText("");
      first = null;
      second = null;
      isInitialized = false;
      lastOperator = '0';
    }
  }
  public void setError (String content) {
    pending.setText("");
    result.setText("");
    first = null;
    second = null;
    isInitialized = false;
    lastOperator = '0';
    int dialogType = JOptionPane.YES_OPTION;
    String title = "Error!";
    JOptionPane.showMessageDialog(null, content, title, dialogType);
  }
  public void bindEvents () {
    one.addActionListener(new buttonOne());
    two.addActionListener(new buttonTwo());
    three.addActionListener(new buttonThree());
    four.addActionListener(new buttonFour());
    five.addActionListener(new buttonFive());
    six.addActionListener(new buttonSix());
    seven.addActionListener(new buttonSeven());
    eight.addActionListener(new buttonEight());
    nine.addActionListener(new buttonNine());
    zero.addActionListener(new buttonZero());
    plus.addActionListener(new buttonPlus());
    minus.addActionListener(new buttonMinus());
    times.addActionListener(new buttonTimes());
    over.addActionListener(new buttonOver());
    equal.addActionListener(new buttonEqual());
    clear.addActionListener(new buttonClear());
    clearAll.addActionListener(new buttonClearAll());
  } 
  public MainFrame (String title) {
    super(title);
    // set basic attributes
    setBounds(500, 30, 530, 800);
    setResizable(false);
    setIconImage(iconCalculator.getImage());
    // Add components
    addOutputBox();
    addButtons();
    bindEvents();
    setVisible(true);
  }
}
public class calculator {
  public static void main(String[] args) {
    new MainFrame("My Own Java Calculator");
  }
}