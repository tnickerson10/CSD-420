/*
Travis Nickerson
Sept. 30th, 2021
CSD 420
Assignment 10
Goal: Write a program that views and updates fan information stored in database titled "databasedb", user ID titled “student1” with a password “pass”.
The table name is to be “fans” with the fields of ID (integer, PRIMARY KEY), firstname (varchar(25)), lastname (varchar(25)), and favoriteteam (varchar(25)).
Your interface is to have 2 buttons to display and update records.
The display button will display the record with the provided ID in the display (ID user provides).
The update button will update the record in the database with the changes made in the display.
Your application is not to create or delete the table.
To work on this using your home database, you can make the table and populate it.
When the application is tested, the table will already be created and populated.
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FansDBGUI implements ActionListener {
   
  // Initiating mysql DB connection variables
    private static Connection con;
    private static Statement stmt;
    
    //JLabel variables
    private static JLabel update;
    private static JLabel id;
    private static JLabel first;
    private static JLabel last;
    private static JLabel team;
    private static JLabel outputLbl;
    private static JTextArea displayArea;

    // JTextfield variables
    private static JTextField idText;
    private static JTextField firstText;
    private static JTextField lastText;
    private static JTextField teamText;

    // JButton variables
    private static JButton addBtn;
    private static JButton dbBtn;
    private static JButton clrBtn;

    public static void main(String[] args) throws Exception {
      // creating frame and panel
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();

      // creating new JLabels
      update = new JLabel("ADD TO DATABASE");
      id = new JLabel("ID:");
      first = new JLabel("FIRST NAME:");
      last = new JLabel("LAST NAME:");
      team = new JLabel("FAVORITE TEAM:");
      outputLbl = new JLabel("");

      // creating new JTextfields
      idText = new JTextField();
      firstText = new JTextField();
      lastText = new JTextField();
      teamText = new JTextField();
      displayArea = new JTextArea();

      // creating new JButtons
      addBtn = new JButton("Add To Database");
      dbBtn = new JButton("Display Database");
      clrBtn = new JButton("Clear Display Area");

      // setting the sizing and placement of JLabels, JTextfields, JButtons
      // and adding them to our panel and frame for display
      idText.setBounds(155, 50, 50, 25);
      panel.add(idText);

      firstText.setBounds(155, 80, 75, 25);
      panel.add(firstText);

      lastText.setBounds(155, 110, 75, 25);
      panel.add(lastText);

      teamText.setBounds(155, 140, 75, 25);
      panel.add(teamText);
      
      displayArea.setBounds(575, 40, 275, 400);
      panel.add(displayArea);
      
      update.setBounds(30, 10, 150, 25);
      panel.add(update);

      id.setBounds(30, 50, 150, 25);
      panel.add(id);

      first.setBounds(30, 80, 150, 25);
      panel.add(first);

      last.setBounds(30, 110, 150, 25);
      panel.add(last);

      team.setBounds(30, 140, 150, 25);
      panel.add(team);

      outputLbl.setBounds(30, 210, 550, 25);
      panel.add(outputLbl);

      frame.setSize(900,500);
      frame.add(panel);

      addBtn.setBounds(30, 180, 175, 25);
      panel.add(addBtn);

      dbBtn.setBounds(30, 240, 175, 25);
      panel.add(dbBtn);

      clrBtn.setBounds(30, 270, 180, 25);
      panel.add(clrBtn);

      // creating three action listeners for our JButtons
      addBtn.addActionListener(new FansDBGUI());
      dbBtn.addActionListener(new FansDBGUI());
      clrBtn.addActionListener(new FansDBGUI());

      // Setting layout and JFrame to visible
      panel.setLayout(null);
      frame.setVisible(true);
  }

  // Overriding our Action Listener event
    @Override
    public void actionPerformed(ActionEvent e) {

      // creating our DB connection when we click our buttons
      try{

        Class.forName("com.mysql.cj.jdbc.Driver");
  
        String url = "jdbc:mysql://localhost:3306/databasedb?";
  
        con = DriverManager.getConnection(url + "user=student1&password=pass");
  
        stmt = con.createStatement();

        System.out.println("CONNECTED");

      }
        catch(Exception err){
    
          System.out.println("Error connection to database.");
          System.exit(0);
        }

      // we needed three buttons for one Action Listener
      // used our event getSource method to know when each button is clicked
      // to run different functions
      if (e.getSource()==addBtn) {

        // Takes input from text fields when adding a person to the database
        String getID = idText.getText();
        int intID = Integer.valueOf(getID);
        String getFirst = firstText.getText();
        String getLast = lastText.getText();
        String getTeam = teamText.getText();

        try{
  
          // SQL statements to add into our DB
          System.out.println(
          stmt.executeUpdate("INSERT INTO `fans`(ID,firstname,lastname,favoriteteam) VALUE ('"+intID+"','"+getFirst+"','"+getLast+"','"+getTeam+"')"));
  
          // output of person added to DB into GUI
          outputLbl.setText("You Added: ID: " +getID+ "  First Name: " +getFirst+ "  Last Name: " +getLast+ "  Favorite Team: " + getTeam);
          stmt.executeUpdate("COMMIT");
    
          System.out.println("Data Inserted");
        }

        catch(SQLException err){
    
          System.out.println(err);
          System.out.println("Insert Data Failed");
        } 
      }

      if (e.getSource()==dbBtn) {

        // outputs our current DB results to our text area
        try{

          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM fans");

          System.out.println("Received Results:");

          int i = rs.getMetaData().getColumnCount();

          // while loop iterates over DB results and appends to text area
          while(rs.next()){

            for(int x = 1; x <= i; ++x){

              displayArea.append(rs.getString(x) + " \n");
            }

            System.out.println("");
          }

            // closing statements of DB

            stmt.close();
            con.close();
            
        }
      
          catch (java.lang.Exception ex){

            ex.printStackTrace();
          }
      
      } 

      // Clear button resets all text fields and area
      if (e.getSource()==clrBtn) {

        displayArea.setText(" ");
        outputLbl.setText(" ");
        idText.setText(" ");
        firstText.setText(" ");
        lastText.setText(" ");
        teamText.setText(" ");
      }
      
    }
        
}

