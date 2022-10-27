import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private class it>
    implements ActionListener
    {
	     final GUI this$0;

	     public void actionPerformed(ActionEvent actionevent)
	     {
		 String s = "Name\tSurname\tEmpoyee\tDate\tTime";
  		 s = (new StringBuilder()).append(s).append("\nElza\tSnow\tFirst Employee\t12 Oct 2019\t9:30").toString();
                 GUI.access$900(GUI.this, "View All Appointments", s);

	     }

	      private nEvent()
	      {
		       this$0 = GUI.this;
		               super();
	      }
