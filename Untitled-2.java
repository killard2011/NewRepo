import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

//delete the comment lines for the class
// public class (class name) implement ActionListener{

public static void main(args[] string){
  //new (classname(;)) DELETE COMMENT LINES   
}
//public (classname()){METHOD CURLY
  JFrame nuFrame = new JFrame();
	  JPanel nuPanel = (JPanel)nuFrame.getContentPane();
	  JPanel otherPanel = new JPanel();
	  JPanel lastPanel = new JPanel();
	  GridLayout nuGrid = new GridLayout(4,3,5,5);
	  Border nuBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	  FlowLayout nuFlow = new FlowLayout();
	  Border secBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	  nuFrame.setLocation(500, 200);
	  nuFrame.setTitle("Hi there");
	  nuFrame.setSize(400, 250);
	  nuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  nuPanel.setLayout(new BoxLayout(nuPanel, BoxLayout.Y_AXIS));
	  nuPanel.setBorder(nuBorder);
	  otherPanel.setLayout(nuFlow);
	  otherPanel.add(Label);
	  lastPanel.setLayout(nuGrid);
	  lastPanel.setBorder(secBorder);
	  lastPanel.add(Button);
	  nuPanel.add(otherPanel);
	  nuPanel.add(lastPanel);
	  Button.setAlignmentX(Component.CENTER_ALIGNMENT);
	  Button.addActionListener(this);
	  nuFrame.setVisible(true);
//}END METHOD CURLY
//} Class Bracket