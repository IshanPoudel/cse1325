package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;


class SingleDialog extends JFrame
{
	private final static int width = 450;
	private final static int height = 110;

	private JComboBox frosting;
	private JComboBox filling;
	private JTextField name;
	private JTextField price;
	private JTextField cost;

	private boolean canceled;


	public SingleDialog()
	{
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Enter Animal Info");
		button.setBounds(20 , 20 , 120 , 30);
		button.addActionListener(
			event -> onButtonClick());
		add(button);

		setSize(width , height);
		setVisible(true);
	}

	public void onButtonClick()
	{
		JLabel name = new JLabel("<HTML><br/>Name</HTML>");
		JTextField donutName = new JTextField(20);

		JLabel price = new JLabel("<HTML><br/>Price</HTML>");
		JTextField donutPrice = new JTextField(20);

		JLabel cost = new JLabel("<HTML><br/>Cost</HTML>");
		JTextField donutCost = new JTextField(20);

		JLabel fillingLabel = new JLabel("<HTML><br/>Filling</HTML>");
		//Get the filling in a JComboBox
		JComboBox<Filling> fillingOption = new JComboBox<Filling>(Filling.values());

		JLabel frostingLabel = new JLabel("<HTML><br/>Frosting</HTML>");
		//Get the frosting
		JComboBox<Frosting> frostingOption = new JComboBox<Frosting>(Frosting.values());

        //boolean sprinkles
        String[] sprinkles = {Sprinkles , NoSprinkles};
        JComboBox<String> sprinkleOption = new JComboBox<String>(sprinkles) ;
		//Display the options

		Object[] objects = {
			name , donutName , 
			price , donutPrice,
			cost , donutCost ,
			fillingLabel , fillingOption , 
			frostingLabel , frostingOption

		};

		int button = JOptionPane.showConfirmDialog(
			this ,
			objects , 
			"New Donut" , 
			JOptionPane.OK_CANCEL_OPTION , 
			JOptionPane.QUESTION_MESSAGE);

		if (button == JOptionPane.OK_OPTION){
			JOptionPane.showMessageDialog(
				this , 
				donutName.getText() + " " + donutPrice.getText() + 
				" " + donutCost.getText() + 
				fillingOption.getSelectedItem() +
				" " + frostingOption.getSelectedItem()+"");
		}



		

	}

	public static void main(String[] args)
	{
		(new SingleDialog()).setVisible(true);
	}
}