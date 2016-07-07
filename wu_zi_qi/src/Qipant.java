<<<<<<< HEAD

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;

public class Qipant extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//øÿ÷∆∆Â≈Ãµƒ≤Œ ˝
	Paint paint1;
	static int click=0;
	static double a=10;static double b=100; 
	static double x;static double y;static boolean in;
	
    //øÿ÷∆ ˝◊È“‘º∞≈–∂œ”Ôæ‰µƒ≤Œ ˝
	static int[][] mapx=new int[40][40];
	// black
	static int num1=0;static int num2=0;
	static int num3=0;static int num4=0;
	// blue
	static int count1;static int count2;
	static int count3;static int count4;
	static boolean[][] map1 = new boolean[40][40];
   
	public static void main(String[] args){
	    Qipant ob1=new Qipant();
	    ob1.initializemapx();
	    
	    Frame f=new Qipant("ŒÂ◊”∆Â");
	    f.setVisible(true);
		//
	}
	Qipant(){}
	Qipant(String title){
		super(title);
		Button Button_start=new Button("ø™ º”Œœ∑");
		Button Button_reset=new Button("÷ÿ÷√”Œœ∑");
		setLayout(new FlowLayout());
		add(Button_start);
		add(Button_reset);
		setSize(420,525);
		setBackground(Color.magenta);
		MenuBar mb=new MenuBar();
		Menu game=new Menu("”Œœ∑");
		mb.add(game);
		MenuItem start=new MenuItem("ø™ º”Œœ∑");
		MenuItem reset=new MenuItem("÷ÿ÷√”Œœ∑");
		MenuItem quit=new MenuItem("Ω· ¯”Œœ∑");
		game.add(start);
		game.add(reset);
		game.add(quit);
		setMenuBar(mb);
		//
		BufferedImage buf=new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2buf=(Graphics2D)buf.getGraphics();
		g2buf.setPaint(Color.pink);
		g2buf.fill(new Rectangle2D.Double(0,0,10,10));
		g2buf.setPaint(Color.white);
		g2buf.fill(new Ellipse2D.Double(0,0,10,10));
		paint1=new TexturePaint(buf,new Rectangle(0,0,10,10));
		//º‡Ã˝¿‡“‘’‚÷÷–Œ Ω∑≈‘⁄ ππ‘Ï∫Ø ˝ƒ⁄  ¡Ù‘⁄’‚¿Ôµ±◊ˆ±Í±æ
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){

				x=e.getX(); y=e.getY();
				click++;
			    Double rectPath=new Rectangle2D.Double(10,100,400,400);
			    in=rectPath.contains(x,y);
			    Qipant ob=new Qipant();
			    ob.locate(x, y);    //∂ØÃ¨∏¸–¬a b
			    
			    
				if(in && mapx[((int)a-10)/10][((int)b-100)/10]==0)
				{
					ob.output(x,y,(int)a,(int)b,in);
				    if(Bw()){
				    	mapx[((int)a-10)/10][((int)b-100)/10]=1;
				    	num1=0;   // πnum1µ»”⁄¡„  ÷¥––ÕÍ≈–∂œ”Ôæ‰ ÷ª»°num1‘ˆº”µƒ≤ø∑÷ »ª∫Ûœ¬“ª¥Œ ‘Ÿ÷√¡„
				    	ob.initializeBoolean(1, mapx);
				    	ob.fanxiexy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);
				
				    	num2=0;
				    	ob.initializeBoolean(1, mapx);
				    	ob.zhengxiexy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);
				    	
				    	num3=0;
				    	ob.initializeBoolean(1, mapx);
				    	ob.shuipingxy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);
				    	
				    	num4=0;
				    	ob.initializeBoolean(1, mapx);
				    	ob.chuizhixy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);
				    	System.out.println("BLACK:num1="+num1+"  num2="+num2+"  num3="+num3+"  num4="+num4);
				    	}
				    else{
				    	mapx[((int)a-10)/10][((int)b-100)/10]=-1;
				    	num1=0;
				    	ob.initializeBoolean(-1, mapx);
				    	ob.fanxiexy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
				    	count1=num1; num1=0;
			            
				    	num2=0;
				    	ob.initializeBoolean(-1, mapx);
				    	ob.zhengxiexy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
				    	count2=num2; num2=0;
				    	
				    	num3=0;
				    	ob.initializeBoolean(-1, mapx);
				    	ob.shuipingxy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
				    	count3=num3; num3=0;
				    	
				    	num4=0;
				    	ob.initializeBoolean(-1, mapx);
				    	ob.chuizhixy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
				    	count4=num4; num4=0;
				    	
				    	System.out.println("BLUE:count1="+count1+"  count2="+count2+"  count3="+count3+"  count4="+count4);
				    	}
		    	    repaint((int)a,(int)b,10,10);
		    	    ob.listener(num1, num2, num3, num4, count1, count2, count3, count4);
				}
				else ob.output(x,y,(int)a,(int)b,in);
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
	class Button_reset_handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Qipant ob=new Qipant();
			ob.initializemapx();
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
		    
		    if(mapx[((int)a-10)/10][((int)b-100)/10]==0){
		    	g2.setPaint(paint1);
	    	    g2.fill(new Rectangle2D.Double(10,100,400,400)); //ÃÓ¬˙∏¯∂®µƒæÿ–Œæ÷”Ú
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
	
	public boolean Bw(){
		if(click%2==0) return true;
		else return false;
	}
	public void output(double x,double y,int a,int b,boolean in){
    	System.out.println("("+x+","+y+")"+"  ("+a+","+b+")"+"   «∑Ò‘⁄∆Â≈Ãƒ⁄£∫"+in);
    	}
    public void locate(double x,double y){
        int temp1=(int)x; int temp2=(int)y;
    	
        a=temp1/10*10;
        b=temp2/10*10;
    	
    }
 
    public void initializemapx(){
    	for(int i=0;i<40;i++){
    		for(int j=0;j<40;j++){
    			mapx[i][j]=0;
    		}
    	}
    }

	void shuipingxy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
		if(mapx[i][j]==bw){
			map1[i][j]=false;
			num3++;
			shuiping(i,j,bw);
		}
		if(mapx[i][j]!=bw) return;
	}
	void shuiping(int i,int j,int bw){
		
		if(i<40 && j+1<40 && i>=0 && j+1>=0 && map1[i][j+1]){shuipingxy(i,j+1,bw,mapx,map1);}  //‘ΩΩÁ‘Ú≤ª¥¥Ω®∏±±æ
		
		if(i<40 && j-1<40 && i>=0 && j-1>=0 && map1[i][j-1]){shuipingxy(i,j-1,bw,mapx,map1);}  //shuipingxy(i,j-1) µ˜”√¡À∏∏¿‡µƒ∫Ø ˝   ∫Ø ˝‘⁄map÷¥––   ∂¯≤ª «map3
		
	}
	void chuizhixy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
		if(mapx[i][j]==bw){
			map1[i][j]=false;
			num4++;
			chuizhi(i,j,bw);
		}
		if(mapx[i][j]!=bw) return;
	}
	void chuizhi(int i,int j,int bw){
		
		if(i-1<40 && j<40 && i-1>=0 && j>=0 && map1[i-1][j]){chuizhixy(i-1,j,bw,mapx,map1);}  //‘ΩΩÁ‘Ú≤ª¥¥Ω®∏±±æ
		
		if(i+1<40 && j<40 && i+1>=0 && j>=0 && map1[i+1][j]){chuizhixy(i+1,j,bw,mapx,map1);}
		
	}
	void zhengxiexy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
		if(mapx[i][j]==bw){
			map1[i][j]=false;
			num2++;
			zhengxie(i,j,bw);
		}
		if(mapx[i][j]!=bw) return;
	}
	void zhengxie(int i,int j,int bw){
		
		if(i-1<40 && j+1<40 && i-1>=0 && j+1>=0 && map1[i-1][j+1]){zhengxiexy(i-1,j+1,bw,mapx,map1);}  //‘ΩΩÁ‘Ú≤ª¥¥Ω®∏±±æ
	
		if(i+1<40 && j-1<40 && i+1>=0 && j-1>=0 && map1[i+1][j-1]){zhengxiexy(i+1,j-1,bw,mapx,map1);}
	
	}
	void fanxiexy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
		
		if(mapx[i][j]!=bw) return;
		if(mapx[i][j]==bw){
			map1[i][j]=false;
			num1++;
			fanxie(i,j,bw);
		}
	}
	void fanxie(int i,int j,int bw){

		if(i+1<40 && j+1<40 && i+1>=0 && j+1>=0 && map1[i+1][j+1]){fanxiexy(i+1,j+1,bw,mapx,map1);}  //‘ΩΩÁ‘Ú≤ª¥¥Ω®∏±±æ
		
		if(i-1<40 && j-1<40 && i-1>=0 && j-1>=0 && map1[i-1][j-1]){fanxiexy(i-1,j-1,bw,mapx,map1);}
    }
    boolean[][] initializeBoolean(int bw,int[][] mapx){
    	for(int i=0;i<40;i++){
    		for(int j=0;j<40;j++){       //«∂Ã◊—≠ª∑£¨≥ı ºªØBoolean∂˛Œ¨ ˝◊È£¨
    			if(mapx[i][j]==bw) map1[i][j]=true;//±»»ÁÀµ¥´»Îµƒ∆Â◊” «∫⁄∆Â£¨º¥bw=1;‘Ú≥ı ºªØµƒΩ·π˚ «£∫
    			else map1[i][j]=false; //     int ˝◊È∫ÕBoolean ˝◊È∆‰ µΩ·ππ“ª—˘µƒ£¨‘⁄bw=1µƒµÿ∑Ω°£‘⁄
    			                       //     Boolean ˝◊È…œ∏≥÷µtrue.
    		}
    	}
    	return map1;
    }
    public void listener(int num1,int num2,int num3,int num4,int count1,int count2,int count3,int count4){
    	int [] array={num1,num2,num3,num4,count1,count2,count3,count4};
    	System.out.println(num1+"  "+num2+"  "+num3+"  "+num4+"  "+count1+"  "+count2+"  "+count3+"  "+count4);
    	for(int i=0;i<8;i++){
    		
    		if(array[i]==5){
    			Frame f=new Frame("game over");
            	Panel p=new Panel();
        		p.setLayout(new FlowLayout());
        		p.add(new Button("yes"));
        		p.add(new Button("no"));
        		
    			if(i>=0 && i<=3){
    				f.setBackground(Color.LIGHT_GRAY);
    				f.add(new Label("the black site is the big ass.."),BorderLayout.CENTER);
    			}
    			if(i>=4 && i<=7){
    				f.setBackground(Color.blue);
    				f.add(new Label("the blue site is the boss!!"),BorderLayout.CENTER);
    				}
    			f.add(p,BorderLayout.SOUTH);
    			f.setSize(300,150);
            	f.setVisible(true);
    			
    			f.addWindowListener(new WindowAdapter(){
    				public void windowClosing(WindowEvent e){
    					System.out.println("windowclsing..");
    					dispose();
    				}
    			});
            	
    		}
    		
    	}
    	
    }
	
}


=======

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

public class Qipant extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ÊéßÂà∂Ê£ãÁõòÁöÑÂèÇÊï∞
	Paint myPaint;
	static int click=0;  //ÊúâÊïàÁÇπÂáªÊ¨°Êï∞  Â•áÊï∞Ê¨°‰∏∫ËìùÊñπ  ÂÅ∂Êï∞Ê¨°‰∏∫ÈªëÊñπ
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
		Button Button_start=new Button("ÂºÄÂßãÊ∏∏Êàè");
		Button Button_reset=new Button("ÈáçÁΩÆÊ∏∏Êàè");
		setLayout(new FlowLayout());
		add(Button_start);
		add(Button_reset);
		setSize(420,525); 
		setBackground(Color.magenta);
		MenuBar mb=new MenuBar();
		Menu game=new Menu("Ê∏∏Êàè");
		mb.add(game);
		MenuItem start=new MenuItem("ÂºÄÂßãÊ∏∏Êàè");
		MenuItem reset=new MenuItem("ÈáçÁΩÆÊ∏∏Êàè");
		MenuItem quit=new MenuItem("ÁªìÊùüÊ∏∏Êàè");
		game.add(start);
		game.add(reset);
		game.add(quit);
		setMenuBar(mb);
		//Ê£ãÁõòÁöÑÂΩ¢Áä∂
		BufferedImage buf=new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2buf=(Graphics2D)buf.getGraphics();
		g2buf.setPaint(Color.pink);
		g2buf.fill(new Rectangle2D.Double(0,0,10,10));
		g2buf.setPaint(Color.white);
		g2buf.fill(new Ellipse2D.Double(0,0,10,10));
		myPaint=new TexturePaint(buf,new Rectangle(0,0,10,10));
		//ÁõëÂê¨Á±ª‰ª•ËøôÁßçÂΩ¢ÂºèÊîæÂú® ÊûÑÈÄ†ÂáΩÊï∞ÂÜÖ  ÁïôÂú®ËøôÈáåÂΩìÂÅöÊ†áÊú¨
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
	class Button_reset_handler implements ActionListener{//Â∫îËØ•ÂàùÂßãÂåñÊâÄÊúâÁöÑÊï∞ÊçÆ ËÄå‰∏çÂè™ÊòØmapx[][]Êï∞ÁªÑÁöÑÊï∞ÊçÆ
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
	    	    g2.fill(new Rectangle2D.Double(10,100,400,400)); //Â°´Êª°ÁªôÂÆöÁöÑÁü©ÂΩ¢Â±ÄÂüü
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


>>>>>>> aNewBranchForIntelliJ
