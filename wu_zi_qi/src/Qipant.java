import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
//branch:encoding
public class Qipant extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//控制棋盘的参数
	Paint myPaint;
	static int click=0;  //有效点击次数  奇数次为蓝方  偶数次为黑方
	static double x;static double y;static boolean in;

	Qipant(String blackOrBlue,String gameOver){
		super(gameOver);
		Panel p=new Panel();
		p.setLayout(new FlowLayout());
		p.add(new Button("yes"));
		p.add(new Button("no"));
		if(blackOrBlue.equals("black")){
			setBackground(Color.LIGHT_GRAY);
			add(new Label("the black site is the big ass.."),BorderLayout.CENTER);
		}
		if(blackOrBlue.equals("blue")){
			setBackground(Color.blue);
			add(new Label("the blue site is the boss!!"),BorderLayout.CENTER);
			}
		add(p,BorderLayout.SOUTH);
		setSize(300,150);
    	setVisible(true);
    	WindowListener win=new Win_handler();
		addWindowListener(win);
	}
	Qipant(String title){
		super(title);
		Button Button_start=new Button("开始游戏");
		Button Button_reset=new Button("重置游戏");
		setLayout(new FlowLayout());
		add(Button_start);
		add(Button_reset);
		setSize(420,525); 
		setBackground(Color.magenta);
		MenuBar mb=new MenuBar();
		Menu game=new Menu("游戏");
		mb.add(game);
		MenuItem start=new MenuItem("开始游戏");
		MenuItem reset=new MenuItem("重置游戏");
		MenuItem quit=new MenuItem("结束游戏");
		game.add(start);
		game.add(reset);
		game.add(quit);
		setMenuBar(mb);
		//棋盘的形状
		BufferedImage buf=new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2buf=(Graphics2D)buf.getGraphics();
		g2buf.setPaint(Color.pink);
		g2buf.fill(new Rectangle2D.Double(0,0,10,10));
		g2buf.setPaint(Color.white);
		g2buf.fill(new Ellipse2D.Double(0,0,10,10));
		myPaint=new TexturePaint(buf,new Rectangle(0,0,10,10));
		//监听类以这种形式放在 构造函数内  留在这里当做标本
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				System.out.println("mouseListener: "+Thread.currentThread().getName());
				x=e.getX(); y=e.getY();
				
			    Double rectPath=new Rectangle2D.Double(10,100,400,400);
			    in=rectPath.contains(x,y);
			    if(in){click++;}
			    actionProcessThread.x = x;
			    actionProcessThread.y = y;
			    actionProcessThread.click = click;
			    actionProcessThread.in = in;
			    
			    new actionProcessThread().run();
			    repaint((int)actionProcessThread.a,(int)actionProcessThread.b,10,10);
			    actionProcessThread.listener(actionProcessThread.num1, actionProcessThread.num2, actionProcessThread.num3, actionProcessThread.num4, 
			    		                     actionProcessThread.count1, actionProcessThread.count2, actionProcessThread.count3, actionProcessThread.count4);
			}
		});
		ActionListener al_start=new Button_start_handler();
		Button_start.addActionListener(al_start);
		start.addActionListener(al_start);
		ActionListener al_reset=new Button_reset_handler();
		Button_reset.addActionListener(al_reset);
		reset.addActionListener(al_reset);
		ActionListener al_Item=new Item_quit_handler();
		quit.addActionListener(al_Item);
		WindowListener win=new Win_handler();
		addWindowListener(win);
		
	}
	class Button_start_handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("button_start");
		}
	}
	class Button_reset_handler implements ActionListener{//应该初始化所有的数据 而不只是mapx[][]数组的数据
		public void actionPerformed(ActionEvent e){
			actionProcessThread.initializemapx();
			repaint();
		}
	}
	class Item_quit_handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
		}
	}
	class Win_handler implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			dispose();
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void paint(Graphics g){
		    Graphics2D g2=(Graphics2D)g;
		    int[][] mapx = actionProcessThread.mapx;
		    double a = actionProcessThread.a;
		    double b = actionProcessThread.b;
		    
		    if(mapx[((int)a-10)/10][((int)b-100)/10]==0){
		    	g2.setPaint(myPaint);
	    	    g2.fill(new Rectangle2D.Double(10,100,400,400)); //填满给定的矩形局域
		    }
	    	 if(mapx[((int)a-10)/10][((int)b-100)/10]==1){        //sun.awt.RepaintArea.paintComponent(Unknown Source)
					g2.setPaint(Color.black);
					g2.fill(new Ellipse2D.Double(a,b,10,10));
			    	}
			  if(mapx[((int)a-10)/10][((int)b-100)/10]==-1){
					g2.setPaint(Color.blue);
					g2.fill(new Ellipse2D.Double(a,b,10,10));
			    	}
	}	
}
