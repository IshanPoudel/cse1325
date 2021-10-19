package gui;
import store.*;
import java.awt.*;
import javax.swing.*;

public class JadeStore extends JFrame
{
	public JadeStore(String title)
	{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize (400 , 200);


		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		JMenu create = new JMenu("create");
		JMenuItem mJava = new JMenuItem("java");
		JMenuItem mDonut = new JMenuItem("donut");
		JMenu help = new JMenu ("Help");
		JMenuItem about = new JMenuItem("About");

		//Add Action listeners
		mJava.addActionListener(event -> onCreateJavaClick());
		// mDonut.addActionListener(event -> onCreateDonutClick());


		file.add(quit);
		create.add(mJava);
		create.add(mDonut);
		help.add(about);

		menubar.add(file);
		menubar.add(create);
		menubar.add(help);

		setJMenuBar(menubar);
		setVisible(true);


		//Add Toolbar
		JToolBar toolbar = new JToolBar("JADE ");
		toolbar.add(Box.createHorizontalStrut(10));

		//Create 3 buttons.

		JButton bJava = new JButton("Java");
		bJava.setActionCommand("Create a Java");
		bJava.setToolTipText("Create a Java");
		toolbar.add(bJava);
		bJava.addActionListener(event -> onCreateJavaClick());
		toolbar.add(Box.createHorizontalStrut(10));

		JButton bDonut = new JButton ("Donut");
		bJava.setActionCommand("Create Donut");
		bJava.setToolTipText("Create Donut");
		toolbar.add(bDonut);
		bJava.addActionListener(event -> onCreateDonutClick());
		toolbar.add(Box.createHorizontalStrut(10));

		bHelp = new JButton("Help");
		bHelp.setActionCommand("Help");
		bHelp.setToolTipText("Help Button");
		toolbar.add(bHelp);

		//Create bottom border

		toolbar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));

        toolbar.add(Box.createHorizontalStrut(300));

        //Adding Data
        data = new JLabel(
        	"<html><br> -- WELCOME TO JADE STORE -- <br>");
        data.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        add(data , BorderLayout.CENTER);

        getContentPane().add(toolbar , BorderLayout.PAGE_START);
        pack();






	}

	private void onCreateJavaClick(){

		this.setEnabled(false);
		JDialog javaDialog = new JDialog();
		javaDialog.setTitle("Create JAVA");

		javaDialog.setLocation(this.getX() + (int) (this.getContentPane().getSize().width) + 10 , this.getY() + this.getY());

		javaDialog.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.weightx = 1; 
        constraints.weighty = 0; 
        constraints.insets = new Insets(5, 15, 5, 15); 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;

        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
        constraintsLabel.weight = 0;

        JLabel javaIcon = new JLabel();
        Image img = new ImageIcon("coffee_cup.png").getImage();
        Image resized_img = img.getScaledInstance(40 , 40 , java.awt.Image.SCALE_SMOOTH);
        javaIcon.setIcon(new ImageIcon(newImg));
        constraintsLabel.gridx=0;
        constraintsLabel.gridy=0;
        javaDialog.add(JavaIcon , constraintsLabel);

        JLabel javaIconDialog = new JLabel ("Enter coffee");
        constraintsLabel.gridx = 1;
        constraintsLable.gridy = 0;
        javaDialog.add(javaIconDialog , constraintsLabel);

        //Name of JAVA
        JLabel nameJLabel = new JLabel("JAVA NAME");
        constraintsLabel.gridx = 1;
        constraintsLable.gridy = 1;
        javaDialog.add(nameJLabel , constraintsLabel);

        JTextField namJTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 1;
        javaDialog.add(namJTextField , constraintsLabel);

        JTextField price = new JTextField("Price :");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weighty=1;
        javaDialog.add(price , constraints);

        JLabel costLabel = new JLabel("Cost: ");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 3;
        javaDialog.add(costLabel, constraintsLabel);

        JTextField costTextField = new JTextField(5);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.weighty = 1;
        javaDialog.add(costTextField , constraints);
	}



	public static void main(String[] args)
	{
		JadeStore demo = new JadeStore ("JadeStore");
		demo.setVisible(true);

	}

	private Store store;
    private JLabel data;
    private JMenuItem mJava;
    private JButton bJava;
    private JMenuItem mDonut;
    private JButton bDonut;


}