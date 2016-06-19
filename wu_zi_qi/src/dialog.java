import java.awt.*;
public class dialog {
	public static void main(String[] args){
		Frame f=new Frame("Frame");
		Dialog d=new Dialog(f,"Dialog",false);
		Panel p=new Panel();
		p.setLayout(new FlowLayout());
		p.add(new Button("yes"));
		p.add(new Button("no"));
		d.add(new Label("do you favorte Java?"),BorderLayout.CENTER);
		d.add(p,BorderLayout.SOUTH);
		f.setBounds(100,100, 200,100);
		d.setBounds(150,200, 200,100);
		f.setVisible(true);
		d.setVisible(true);
		System.out.println("HI Java");
	}

}
