import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


class fenetre extends JFrame
{
	private JTextField address;
	private JEditorPane display;
	
	//construction
	
	fenetre()
	{
		this.setSize(600,400);
		this.setTitle("wassif Browser");
		this.setLocationRelativeTo(null);
		Container container = getContentPane();
		container.setLayout(new BorderLayout(10,10));
		
		display = new JEditorPane();
		display.setEditable(false);
		address = new JTextField("http://www.google.com");
		
		address.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					try
					{
						display.setPage(ev.getActionCommand());
						
					}catch(Exception e)
					{
						System.out.println("erreur");
					}
				}
			
			}
		);
		
		display.addHyperlinkListener(
			new HyperlinkListener(){
				public void hyperlinkUpdate(HyperlinkEvent ev)
				{
						if(ev.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						{
							try
							{
								display.setPage(ev.getURL().toString());
								
							}catch(Exception e)
							{
								System.out.println("erreur");
							}
							
						}
				}
				
			}
		);
		
		
		
		container.add(address,BorderLayout.NORTH);
		container.add(new JScrollPane(display),BorderLayout.CENTER);
		
	}
	
}

public class  navigateur
{
	public static void main(String args[])
	{
		fenetre maFenetre = new fenetre();
		maFenetre.setVisible(true);
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}