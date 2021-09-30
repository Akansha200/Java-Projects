package notepad;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Notepad extends JFrame implements ActionListener
{
	JTextArea area;
	JScrollPane pane;
	String text;
	
	Notepad() {
		super(" Notepad");
		setBounds(0,0,1950,1050);
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newdoc = new JMenuItem("New");
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newdoc.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		open.addActionListener(this);

		
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.addActionListener(this);

		
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		print.addActionListener(this);

		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		exit.addActionListener(this);

		
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		JMenu edit = new JMenu("Edit");
		
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copy.addActionListener(this);

		
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cut.addActionListener(this);

		
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		paste.addActionListener(this);

		
		JMenuItem selectall = new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);

		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		
		JMenu format = new JMenu("Format");
		JMenuItem font = new JMenuItem("Font");
		font.addActionListener(this);

		format.add(font);
		
		JMenu view = new JMenu("View");
		JMenuItem zoom = new JMenuItem("Zoom");
		zoom.addActionListener(this);
		view.add(zoom);
		
		JMenuItem statusbar = new JMenuItem("StatusBar");
		statusbar.addActionListener(this);
		view.add(statusbar);
		
		JMenu help = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About the Notepad");
		about.addActionListener(this);
		
		help.add(about);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		menubar.add(view);
		menubar.add(help);
		
		setJMenuBar(menubar);
		area = new JTextArea();
		area.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		pane = new JScrollPane(area);
		pane.setBorder(BorderFactory.createEmptyBorder());
		add(pane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
	//JFrame f = new JFrame();
	//f.setSize(1950,1050);
	//f.setVisible(true);
	//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	new Notepad().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("New")) {
		area.setText("");
	} else if(e.getActionCommand().equals("Open")) {
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
		chooser.addChoosableFileFilter(restrict);
		
		int action = chooser.showOpenDialog(this);
		if(action != JFileChooser.APPROVE_OPTION) {
			return ;
		}
		File file = chooser.getSelectedFile();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			area.read(reader, null);
		} catch(Exception er) {
			
		}
		
	} else if(e.getActionCommand().contentEquals("Save"))  {
		JFileChooser saveas = new JFileChooser();
		saveas.setApproveButtonText("Save");
		int action = saveas.showOpenDialog(this);
		if(action != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File filename = new File(saveas.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(filename));
			area.write(outFile);
		} catch(Exception error) {
			
		}
	} else if(e.getActionCommand().equals("Print")) {
		try {
			area.print();
		}catch( Exception er) {
			
		} 
		
	}
	else if(e.getActionCommand().equals("Exit")) {
		System.exit(0);		}
		
	else if(e.getActionCommand().equals("Copy")) {
		text = area.getSelectedText();
	}
	else if(e.getActionCommand().equals("Paste")) {
		area.insert(text,area.getCaretPosition());
	} else if(e.getActionCommand().equals("Cut")) {
		text = area.getSelectedText();
		area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
	}
	else if(e.getActionCommand().equals("Select All")) {
		area.selectAll();
		
	}
	else if(e.getActionCommand().equals("About the Notepad")) {
		new About().setVisible(true);
	}
	}

}
