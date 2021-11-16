package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import store.Store;
import store.Product;
import store.Donut;
import store.Customer;
import store.Frosting;
import store.Filling;
import store.Java;
import store.Darkness;
import store.Shot;

import java.awt.*;

public class MainWin extends JFrame {

    // ///////////////////////////////////////////////////////////////////
    // Constructors

    public MainWin(String title) {
        super(title);
        store = new Store("JADE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        filename = new File("untitled.jade");
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     mFile    = new JMenu("File");
        JMenuItem mQuit    = new JMenuItem("Quit");
        JMenuItem mNew = new JMenuItem("New");
        JMenuItem mOpen = new JMenuItem("Open");
        JMenuItem mSave = new JMenuItem("Save");
        JMenuItem mSaveAs = new JMenuItem("Save as");
        JMenu     mCreate  = new JMenu("Create");
        JMenuItem mJava    = new JMenuItem("Java");
        JMenuItem mDonut   = new JMenuItem("Donut");
        JMenuItem mCustomer = new JMenuItem("Customer");
        JMenuItem mServer = new JMenuItem("Server");
        JMenu     mView = new JMenu("View");
        JMenuItem mProduct = new JMenuItem("Products");
        JMenuItem mCustomerView = new JMenuItem("Customer");
        JMenu     mHelp    = new JMenu("Help");
        JMenuItem mAbout   = new JMenuItem("About");

        
        mQuit .addActionListener(event -> onQuitClick());
        mJava .addActionListener(event -> onCreateJavaClick());
        mDonut.addActionListener(event -> onCreateDonutClick());
        mCustomer.addActionListener(event -> onCreateCustomerClick());
        mProduct.addActionListener(event -> onViewProductClick());
        mServer.addActionListener(event -> onCreateServerClick());
        mCustomerView.addActionListener( event -> onViewCustomerClick());
        mAbout.addActionListener(event -> onAboutClick());

        
        mFile.add(mQuit);
        mFile.add(mNew);
        mFile.add(mOpen);
        mFile.add(mSave);
        mFile.add(mSaveAs);
        mCreate.add(mJava);
        mCreate.add(mDonut);
        mCreate.add(mCustomer);
        mCreate.add(mServer);
        mView.add(mProduct);
        mView.add(mCustomerView);
        mHelp  .add(mAbout);
        
        menubar.add(mFile);
        menubar.add(mCreate);
        menubar.add(mView);
        menubar.add(mHelp);
        
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("JADE Controls");

        // Create the 3 buttons using the icons provided

        
        JButton bNew = new JButton("New File");
       
         bNew.setActionCommand("Create new file");
         bNew.setToolTipText("Create a new file ");
         toolbar.add(bNew);
         bNew.addActionListener(event -> onCreateNewFile());

        JButton bOpen = new JButton("Open File");
        bOpen.setActionCommand("Open file");
        bOpen.setToolTipText("Open file");
        toolbar.add(bOpen);
        bOpen.addActionListener(event -> onOpenFile());

        JButton bSave = new JButton("Save File");
        bSave.setActionCommand("Save File");
        bSave.setToolTipText("Save File");
        toolbar.add(bSave);
        bSave.addActionListener(event -> onSave());

        JButton bSaveAs = new JButton("Save File As");
        bSaveAs.setActionCommand("Save File As");
        bSaveAs.setToolTipText("Save File As");
        toolbar.add(bSaveAs);
        bSaveAs.addActionListener(event ->onSaveAs()); 


        bJava  = new JButton(new ImageIcon("gui/resources/new_java.png"));
          bJava.setActionCommand("Create new Java");
          bJava.setToolTipText("Create a new coffee selection");
          toolbar.add(bJava);
          bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("gui/resources/new_donut.png"));
          bDonut.setActionCommand("Create new donut");
          bDonut.setToolTipText("Create a new donut selection");
          toolbar.add(bDonut);
          bDonut.addActionListener(event -> onCreateDonutClick());

        bCustomer = new JButton("Create Customer");
        bCustomer.setActionCommand("Create new customer");
        bCustomer.setToolTipText("Create new customer");
        toolbar.add(bCustomer);
        bCustomer.addActionListener(event -> onCreateCustomerClick());

        bServer = new JButton("Create Server");
        bServer.setActionCommand("Create new server");
        bServer.setToolTipText("Create a new server");
        toolbar.add(bServer);
        bServer.addActionListener(event -> onCreateServerClick());



        bViewProduct = new JButton("View Products");
        bViewProduct.setActionCommand("View Products");
        bViewProduct.setToolTipText("View Products");
        toolbar.add(bViewProduct);
        bViewProduct.addActionListener(event -> onViewProductClick());

        bViewCustomer = new JButton("View Customer");
        bViewCustomer.setActionCommand("View Customer");
        bViewCustomer.setToolTipText("View Customers");
        toolbar.add(bViewCustomer);
        bViewCustomer.addActionListener(event -> onViewCustomerClick());

        bViewServer = new JButton("Voew Servers");
        bViewServer.setActionCommand("View Servers");
        bViewServer.setToolTipText("View Servers");
        toolbar.add(bViewServer);
        bViewServer.addActionListener(event -> onViewServerClick());





        JButton bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
          bAbout.setActionCommand("About JADE Manager");
          bAbout.setToolTipText("About JADE Manager");
          toolbar.add(bAbout);
          bAbout.addActionListener(event -> onAboutClick());

         
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // D A T A   D I S P L A Y
        // Provide a text entry box to show output
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(data, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Initialize the dislay
        updateDisplay();
        
        // Make everything in the JFrame visible
        setVisible(true);
    }

    protected void onCreateNewFile()
    {
    	// System.out.println("I was called");
    	store = new Store();
    	updateDisplay();

    }

    protected void onOpenFile()
    {
    	final JFileChooser fc = new JFileChooser(filename);
    	FileFilter jadeFiles = new FileNameExtensionFilter("Jade files", "jade");
        fc.addChoosableFileFilter(jadeFiles);         
        fc.setFileFilter(jadeFiles);  

        int result = fc.showOpenDialog(this); 

        if (result == JFileChooser.APPROVE_OPTION)
        {
        	filename = fc.getSelectedFile();

        	try
        	{

        		BufferedReader br = new BufferedReader(new FileReader(filename));
        		store = new Store(br);
        	    updateDisplay();
        	} catch (Exception e)
        	{
        		return;
        	}



        }


    }

    protected void onSaveAs()
    {
    	final JFileChooser fc = new JFileChooser(filename);
    	FileFilter storeFiles = new FileNameExtensionFilter("jade" , "jade");
    	fc.addChoosableFileFilter(storeFiles);
    	fc.setFileFilter(storeFiles);

    	int result = fc.showSaveDialog(this);
    	if(result == JFileChooser.APPROVE_OPTION)
    	{
    		filename = fc.getSelectedFile();

    		if(!filename.getAbsolutePath().endsWith(".jade"))
    		{
    			filename = new File(filename.getAbsolutePath() + ".jade");
    			onSave();
    		}
    	}
    }

    protected void onSave()
    {
    	try
    	{
    		// System.out.println("The file name to save is " + filename);
    		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    		store.savefile(bw);

    	} catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(this , "Unable to open" + filename + '\n' + e , "Failed" , JOptionPane.ERROR_MESSAGE);
    	}
    	// try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
    	// 	store.savefile(bw);
    	// }
    	
    }

    protected void onCreateServerClick()
    {
        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        JTextField serverName = new JTextField(20);

        JLabel number = new JLabel("<HTML><br/>Phone Number</HTML>");
        JTextField serverNumber = new JTextField(20);

        JLabel ssn = new JLabel("<HTML><br/>SSN</HTML>");
        JTextField ssnValue = new JTextField(20);

        Object[] objects = {
            name , serverName , 
            number , serverNumber ,
            ssn , ssnValue
        };

        int button = JOptionPane.showConfirmDialog(
            this , 
            objects , 
            "New Server" , 
            JOptionPane.OK_CANCEL_OPTION , 
            JOptionPane.QUESTION_MESSAGE  );

        //SEND VALUES TO CONSTRUCTOR



    }


    protected void onCreateJavaClick()
    {

        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        JTextField javaName = new JTextField(20);

        JLabel price = new JLabel("<HTML><br/>Price</HTML>");
        JTextField javaPrice = new JTextField(20);

        JLabel cost = new JLabel("<HTML><br/>Cost</HTML>");
        JTextField javaCost = new JTextField(20);

        JLabel darknessLabel = new JLabel("<HTML><br/>Darkness</HTML>");
        //Get the filling in a JComboBox
        JComboBox<Darkness> darknessOption = new JComboBox<Darkness>(Darkness.values());

        Object[] objects = {
            name , javaName , 
            price , javaPrice,
            cost , javaCost ,
            darknessLabel , darknessOption 
            

        };

        int button = JOptionPane.showConfirmDialog(
            this ,
            objects , 
            "New Java" , 
            JOptionPane.OK_CANCEL_OPTION , 
            JOptionPane.QUESTION_MESSAGE  );

        //send values to constructor

        double javaPricedouble = Double.parseDouble(javaPrice.getText());
        double javaCostdouble = Double.parseDouble(javaCost.getText());

        Java java = new Java (javaName.getText() , javaPricedouble , javaCostdouble , 
            (Darkness) darknessOption.getSelectedItem());

        try
        {
            while(true) {
                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                if(shot.equals(Shot.None)) break;
                java.addShot(shot);
            }

        }catch (CancelDialogException e) { // ignore a Cancel
        }catch(Exception e) {
            msg.setText("Failed to create new Java: " + e.getMessage());
        }
        
        store.addProduct(java);
        updateDisplay();


        



    }

    protected void onViewCustomerClick()
    {
        updateDisplayCustomer();
    }

    protected void onViewProductClick()
    {
        updateDisplay();

    }

    protected void onViewServerClick()
    {
        updateDisplayServer();
    }

    protected void onCreateDonutClick() {  // Create a new Java product
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
        JLabel sprinkleLabel = new JLabel("<HTML><br/>Sprinkles</HTML>");
        String[] sprinkles = {"Sprinkles"  , "No Sprinkles"};
        JComboBox<String> sprinkleOption = new JComboBox<String>(sprinkles) ;
        //Display the options

        Object[] objects = {
            name , donutName , 
            price , donutPrice,
            cost , donutCost ,
            fillingLabel , fillingOption , 
            frostingLabel , frostingOption , 
            sprinkleLabel , sprinkleOption

        };

        int button = JOptionPane.showConfirmDialog(
            this ,
            objects , 
            "New Donut" , 
            JOptionPane.OK_CANCEL_OPTION , 
            JOptionPane.QUESTION_MESSAGE);

        
        //send values to constructor
        boolean sprinklesBool = false;
        double donutPricedouble = Double.parseDouble(donutPrice.getText());
        double donutCostdouble = Double.parseDouble(donutCost.getText());
        if (( sprinkleOption.getSelectedItem()).equals("Sprinkles"))
        {
            sprinklesBool = true;
        }

        //Create new donut
        store.addProduct(new Donut(donutName.getText() , donutPricedouble ,
        donutCostdouble , sprinklesBool , 
         (Frosting) frostingOption.getSelectedItem() ,(Filling) fillingOption.getSelectedItem()));
        updateDisplay();
// 
    }

    protected void onCreateCustomerClick()
    {
        JLabel name = new JLabel("<HTML><br/>Name</HTML>");
        JTextField customerName = new JTextField(20);

        JLabel number = new JLabel("<HTML><br/>Phone Number</HTML>");
        JTextField phoneNumber = new JTextField(20);

        Object[] objects = {
            name , customerName , 
            number , phoneNumber

        };

        int button = JOptionPane.showConfirmDialog(
            this ,
            objects , 
            "New Customer" , 
            JOptionPane.OK_CANCEL_OPTION , 
            JOptionPane.QUESTION_MESSAGE );

        // Send values to customer
         
        store.addCustomer(new Customer(customerName.getText() , phoneNumber.getText()));




    }

    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.getContentPane().setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Java and Donut Express");
        about.setSize(640,600);
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/resources/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+3>Java and Donut Express</font></p>"
          + "</html>");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(title);

        JLabel copyright = new JLabel("<html>"
          + "<p>Version 0.2</p>"
          + "<p>Copyright 2021 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<br/>"
          + "</html>");
        copyright.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(copyright);
                    
       JLabel artists = new JLabel("<html>"
          + "<p>JADE Logo by SaxDeux, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Logo_JADE.png</p>"
          + "<p>Flat Coffee Cup Icon by superawesomevectors, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>http://fav.me/dbf6otc</p>"
          + "<p><font size=-2>https://creativecommons.org/licenses/by-sa/3.0/us/</p>"
          + "<p>Donut Icon by Hazmat2 via Hyju, public domain</p>"
          + "<p><font size=-2>https://en.wikipedia.org/wiki/File:Simpsons_Donut.svg</p>"
          + "<p>Help Icon by Vector Stall via the Flat Icon license</p>"
          + "<p><font size=-2>https://www.flaticon.com/premium-icon/question-mark_3444393</p>"
          + "<br/>"
          + "</html>");
        artists.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.pack();
        about.setVisible(true);
     }

    protected void onQuitClick() {dispose();} 

     protected class CancelDialogException extends Exception {
        public CancelDialogException() {
            super("Dialog canceled");
        }
    }

     private String getString(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null || newPrompt.length() == 0) 
                    throw new CancelDialogException();
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid string '" + newPrompt + "\n" + prompt;
            }
        }
        return newPrompt;
    }

    private double getDouble(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        double result = 0.0;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null) throw new CancelDialogException();
                result = Double.parseDouble(newPrompt);
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid double '" + newPrompt + "\n" + prompt;
            }
        }
        return result;
    }

    private Object selectFromArray(String prompt, Object[] options) throws CancelDialogException {
        JComboBox<Object> comboEnum = new JComboBox<>();
        comboEnum.setModel(new DefaultComboBoxModel<Object>(options));
        int button = JOptionPane.showConfirmDialog(this, comboEnum, prompt, 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.CANCEL_OPTION) throw new CancelDialogException();
        return comboEnum.getSelectedItem();
    }

      private void updateDisplay() {
        data.setText("<html>" + store.toString()
                                     .replaceAll("<","&lt;")
                                     .replaceAll(">", "&gt;")
                                     .replaceAll("\n", "<br/>")
                              + "</html>");
    }

    private void updateDisplayCustomer()
    {
        data.setText( store.PersontoString());
    }

    private void updateDisplayServer()
    {
        data.setText(store.ServertoString());
    }

    public static void main(String[] args) {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);

    }

    private Store store;
    private File filename;

    
    private JLabel data;                    // Display of output in main window
    private JLabel msg;                     // Status message display
    private JButton bJava;                  // Button to select 1 stick
    private JButton bDonut; 
    private JButton bCustomer;
    private JButton bServer;
    private JButton bViewProduct;
    private JButton bViewCustomer;
    private JButton bViewServer;



} 


