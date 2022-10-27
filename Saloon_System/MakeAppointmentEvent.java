import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

private class this._cls0
    implements ActionListener
    {
	    final GUI this$0;

	     public void actionPerformed(ActionEvent actionevent)
	     {
		     GUI.access$1002(GUI.this, new DefaultListModel());
		     ArrayList arraylist = new ArrayList();
		     arraylist.add("First Employee");
                     arraylist.add("Second Employee");
		     arraylist.add("Third Employee");
	             arraylist.add("Fourth Employee");

		     for(int i = 0; i < arraylist.size(); i++)
		     {
			     GUI.access$1000(GUI.this).addElement(arraylist.get(i));
		     }
		             GUI.access$1100(GUI.this);
	     }

	     private nt()
	     {
		     this$0 = GUI.this;
		             super();
	     }
    }
