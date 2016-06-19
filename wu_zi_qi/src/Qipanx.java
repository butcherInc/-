import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;

public class Qipanx extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//控制棋盘的参数
	Paint paint1;
	static int click=0;
	static double a=10;static double b=100; 
	static double x;static double y;static boolean in;
    //控制数组以及判断语句的参数
	static int[][] mapx=new int[40][40];
	static int num1=0;static int num2=0;
	static int num3=0;static int num4=0;
	static int[][] map1 = new int[40][40];
	static int[][] map2 = new int[40][40];
	static int[][] map3 = new int[40][40];
	static int[][] map4 = new int[40][40];
	public static void main(String[] args){
	    Qipanx ob1=new Qipanx();
	    ob1.initialize();
	    Frame f=new Qipanx("五子棋");
	    f.setVisible(true);
	}
	Qipanx(){}
	Qipanx(String title){
		super(title);
		Button btn1=new Button("开始游戏");
		Button btn2=new Button("重置游戏");
		setLayout(new FlowLayout());
		add(btn1);
		add(btn2);
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
		//
		BufferedImage buf=new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2buf=(Graphics2D)buf.getGraphics();
		g2buf.setPaint(Color.yellow);
		g2buf.fill(new Rectangle2D.Double(0,0,10,10));
		g2buf.setPaint(Color.LIGHT_GRAY);
		g2buf.fill(new Ellipse2D.Double(0,0,10,10));
		paint1=new TexturePaint(buf,new Rectangle(0,0,10,10));
		MouseListener ml=new mousehandler();
		addMouseListener(ml);
		ActionListener al=new actionhandler();
		btn2.addActionListener(al);
		reset.addActionListener(al);
		ActionListener al2=new actionhandler2();
		btn1.addActionListener(al2);
	    start.addActionListener(al2);
	    ActionListener al3=new actionhandler3();
	    quit.addActionListener(al3);
	    WindowListener win=new winhandler();
	    addWindowListener(win);
	}
	public void paint(Graphics g){
		    Graphics2D g2=(Graphics2D)g;
		    
		    if(mapx[((int)a-10)/10][((int)b-100)/10]==0){
		    	g2.setPaint(paint1);
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
	class actionhandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("reset the game");
		}

	}
	class winhandler implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			
			
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
			
		}}
    class mousehandler extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			x=e.getX(); y=e.getY();
			click++;
		    Double rectPath=new Rectangle2D.Double(10,100,400,400);
		    in=rectPath.contains(x,y);
		    Qipanx ob=new Qipanx();
		    ob.locate(x, y);    //动态更新a b
		    
		    
			if(in && mapx[((int)a-10)/10][((int)b-100)/10]==0){
				ob.output(x,y,(int)a,(int)b,in);
			    if(Bw()){mapx[((int)a-10)/10][((int)b-100)/10]=1;}
			    else{mapx[((int)a-10)/10][((int)b-100)/10]=-1;}
	//		    ob.printmapx();
	    	    repaint((int)a,(int)b,10,10);
			}
			else ob.output(x,y,(int)a,(int)b,in);
		}
		
	}
    class actionhandler2 implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		System.out.println("start the game..");
    	}
    }
    class actionhandler3 implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		System.out.println("i want to quit..");
    		dispose();
    	}
    }
	public boolean Bw(){
		if(click%2==0) return true;
		else return false;
	}
	public void output(double x,double y,int a,int b,boolean in){
    	System.out.println("("+x+","+y+")"+"  ("+a+","+b+")"+"  是否在棋盘内："+in);
    	}
    public void locate(double x,double y){
        int temp1=(int)x; int temp2=(int)y;
    	
        a=temp1/10*10;
        b=temp2/10*10;
    	
    }

    public void initialize(){
    	for(int i=0;i<40;i++){
    		for(int j=0;j<40;j++){
    			mapx[i][j]=0;
    		}
    	}
    }
    public void printmapx(){
    	for(int j=0;j<40;j++){
    		for(int i=0;i<40;i++){
    			System.out.print(mapx[i][j]);
    		}
    		System.out.println();
    	}
    
    }
}

