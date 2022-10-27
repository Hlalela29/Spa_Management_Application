import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.PrintStream;
import javax.swing.*;

private class t
    implements ActionListener
    {
	    final GUI this$0;

	     public void actionPerformed(ActionEvent actionevent)
	     {
		     String s = GUI.access$1700(GUI.this).getText();
	             String s1 = GUI.access$1800(GUI.this).getTitle();

		     if(s1.equals("Client"))
		     {
			     try
			     {
				     GUI.access$1800(GUI.this).setClosed(true);
			     }
			     catch(PropertyVetoException propertyvetoexception)
			     {
				     System.err.println("Closing Exception");
			     }
		    JOptionPane.showMessageDialog(GUI.access$1600(GUI.this), (new StringBuilder()).append("You are adding a Client called ").append(s).toString());
		     }
		     else
		     {
			     try
			     {
				      GUI.access$1800(GUI.this).setClosed(true);
			     }
			     catch(PropertyVetoException propertyvetoexception1)
			     {
				     System.err.println("Closing Exception");
			     }
			     JOptionPane.showMessageDialog(GUI.access$1600(GUI.this), (new StringBuilder()).append("You are adding an Employee called ").append(s).toString());
		     }

	     }

	     private t()
	     {
		     this$0 = GUI.this;
		             super();
	     }
    }



