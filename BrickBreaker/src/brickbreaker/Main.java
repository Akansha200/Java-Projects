package brickbreaker;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Gameplay gamePlay = new Gameplay();
		f.setSize(700,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setTitle("Ball Breaking game!!");
        f.add(gamePlay);
	}

}
