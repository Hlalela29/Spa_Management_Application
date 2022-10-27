import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame
{
	private JDesktopPane jdp;
	private JMenuBar jmb;
	private JMenu jmLogin, jmAppoint, jmAdmin;
	private JMenuItem jmiViewAppoint, jmiMakeAppoint, jmiAddClient, jmiAddEmployee, jmiViewSalary;
        private JInternalFrame jifDisplay, jifBookApp;
        private JTextArea jta;
        private JScrollPane jsp;
        private DefaultListModel dlStaff;
	private JList jlStaff;
        private JTextField jtfName;
       	private JTextField jtfSurname;
	private JTextField jtfphone;
	private JInternalFrame jifAddPerson;
	private JTextField jtfusername;
	private JPasswordField jpwPassword;
	private JMenuItem jmiLogin;
	private JTextField jtfDay;
	private JTextField jtfTime;
	private JInternalFrame jifLogin;

	public void create()
	{
		jmb = new JMenuBar();
		jmAppoint = new JMenu("Appointment");
                jmLogin = new JMenu("Login");
	        jmAdmin = new JMenu("Admin");

		jmiLogin = new JMenuItem("Login");
                jmiLogin.addActionListener(new jmiLoginEvent());

		jmiViewAppoint = new JMenuItem("View All Appointment");
		jmiViewAppoint.addActionListener(new jmiViewAllEvent());

	        jmiMakeAppoint = new JMenuItem("Make an Appointment");
		jmiMakeAppoint.addActionListener(new jmiMakeAppointEvent());

		jmiAddClient = new JMenuItem("Add Client");
	        jmiAddClient.addActionListener(new jmiAddClientEvent());

		jmiAddEmployee = new JMenuItem("Add Employee");
	        jmiAddEmployee.addActionListener(new jmiAddEmpEvent());

		jmiViewSalary = new JMenuItem("View Salary");
		jmiViewSalary.addActionListener(new jmiViewSalaryEvent());

		jmLogin.add(jmiLogin);

		jmAppoint.add(jmiViewAppoint);
	        jmAppoint.add(jmiMakeAppoint);

		jmAdmin.add(jmiAddClient);
	        jmAdmin.add(jmiAddEmployee);
                jmAdmin.add(jmiViewSalary);

		jmb.add(jmLogin);
	        jmb.add(jmAppoint);
                jmb.add(jmAdmin);

		jdp = new JDesktopPane();

		setContentPane(jdp);
	        setJMenuBar(jmb);
                setSize(600, 600);
	        setTitle("Spa Management Application");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*The internalFrame for adding an employee or client*/
	private void createIFToAddSomeone(String title)
	{
		jifAddPerson = new JInternalFrame(title, false, true);
		JPanel jp = new JPanel();

		JLabel jlName = new JLabel("Name");
	        JLabel jlSurname = new JLabel("Surname");
		JLabel jlPhone = new JLabel("Phone");

		jtfName = new JTextField(20);
		jtfSurname = new JTextField(20);
	        jtfphone = new JTextField(20);

		JButton jbAdd = new JButton("Add");
	        jbAdd.addActionListener(new jbAddEvent());

		jp.add(jlName);
		jp.add(jtfName);
		jp.add(jlSurname);
	        jp.add(jtfSurname);
	        jp.add(jlPhone);
	        jp.add(jtfphone);
	        jp.add(jbAdd);
	        jifAddPerson.add(jp);
		jifAddPerson.setSize(300, 150);
		jifAddPerson.setVisible(true);
		jdp.add(jifAddPerson);
	}

	private void createIFToLogin()
	{
		jifLogin = new JInternalFrame("Login", false, true);
	        JPanel jp = new JPanel();

		JLabel jlName = new JLabel("Username");
		JLabel jlPassword = new JLabel("Password");

		jtfusername = new JTextField(20);

		jpwPassword = new JPasswordField(20);

		JButton jbAdd = new JButton("Login");
	        jbAdd.addActionListener(new jbLoginEvent());

		jp.add(jlName);
		jp.add(jtfusername);

		jp.add(jlPassword);
	        jp.add(jpwPassword);

		jp.add(jbAdd);
		jifLogin.add(jp);
        	jifLogin.setSize(300, 170);
	        jifLogin.setVisible(true);
		jdp.add(jifLogin);
	}

	/*This is the event where the user clicks on View All Appointments*/
	private class jmiViewAllEvent implements ActionListener
	{
	       public void actionPerformed(ActionEvent ae)
	       {
		String data = "Name\tSurname\tEmpoyee\tDate\tTime";
                data = data + "\nJohn\tSnow\tFirst Employee\t12 Oct 2019\t9:30";
	        createIFToDisplayData("View All Appointments", data);
	       }
	}

	 /*This is the event where the user clicks on View Salaries*/
	private class jmiViewSalaryEvent implements ActionListener
	{
	      public void actionPerformed(ActionEvent ae)
	      {
		String data = "Name\tSurname\tSalary\nFirst\tEmployee\tR1200";
		createIFToDisplayData("View Salary", data);
	      }
	}

	/*This is the event where the user clicks on Make an Appointment*/
	private class jmiMakeAppointEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			dlStaff = new DefaultListModel();

			ArrayList al = new ArrayList();

			al.add("First Employee");
		        al.add("Second Employee");
	                al.add("Third Employee");
		        al.add("Fourth Employee");

			for (int x = 0; x < al.size(); x++)
			{
				dlStaff.addElement(al.get(x));
			}

			createIFToBookAnAppointment();
		}
	}

	/*This is the event where the user clicks on Add a Client*/
        private class jmiAddClientEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			 createIFToAddSomeone("Client");
		}
	}

	/*This is the event where the user clicks on Add an Employee*/
	private class jmiAddEmpEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			createIFToAddSomeone("Employee");
		}
	}

	 /*This is the event where the user clicks on Login*/
	private class jmiLoginEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			createIFToLogin();
		}
	}

	/*When the button on the internalframe jifBookApp is clicked*/
	private class jbBookEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String data = jlStaff.getSelectedValue().toString();

			            try
				    {
				      jifBookApp.setClosed(true);
				    }
				    catch (PropertyVetoException ex)
				    {
				      System.err.println("Closing Exception");
				    }
                           
				    JOptionPane.showMessageDialog(jdp, "Your appointment is booked with " + data);
		}
	}

	/*When the button on the internalframe jifAddPerson is clicked*/
	private class jbAddEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			/*the event for adding an employee or client from the internalFrame */
		       String name = jtfName.getText();
		       String type = jifAddPerson.getTitle();

		      if (type.equals("Client"))//adding a client
		      {
			      try
			      {
	                          jifAddPerson.setClosed(true);
		              }
			      catch (PropertyVetoException ex)
			      {	 						                                 System.err.println("Closing Exception");
			      }
			      JOptionPane.showMessageDialog(jdp, "You are adding a Client called " + name);
		      }
		      else//adding an employee
		      {
			      try
			      {
				      jifAddPerson.setClosed(true);
			      }
			      catch (PropertyVetoException ex)
			      {
				      System.err.println("Closing Exception");
			      }
			      JOptionPane.showMessageDialog(jdp, "You are adding an Employee called " + name);
		      }
		}
	}

	/*When the button on the internalframe jifLogin is clicked*/
	private class jbLoginEvent implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			 /*Determined by who logged in, the different menu options 
			  *
			  *             should be disbaled*/
		}
	}
}
