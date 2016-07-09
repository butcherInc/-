public class actionProcessThread  extends Thread{

    //Qipant中控制棋盘的参数会自动同步到actionProcessThread类中
    static double a=10;static double b=100;
    static int click=0;  //有效点击次数  奇数次为蓝方  偶数次为黑方
    static double x;static double y;static boolean in;
    //控制数组以及判断语句的参数
    static int[][] mapx=new int[40][40];//初始化的结果是0
    // black
    static int num1=0;static int num2=0;
    static int num3=0;static int num4=0;
    // blue
    static int count1;static int count2;
    static int count3;static int count4;
    static boolean[][] map1 = new boolean[40][40];

    public void run(){
        System.out.println("actionProcessThread: "+Thread.currentThread().getName());
        actionProcessThread.locate(x, y);
//		actionProcessThread.output(x, y, a, b, in);
        actionProcessThread.checkTheWinner();
    }
    public static void initializemapx(){
        for(int i=0;i<40;i++){
            for(int j=0;j<40;j++){
                mapx[i][j]=0;
            }
        }
    }
    public static void output(double x,double y,double a,double b,boolean in){
        System.out.println("("+x+","+y+")"+"  ("+a+","+b+")"+"点击事件是否发生在棋盘上: "+in);
    }
    /*
     * 判断赢家的函数 算法：迭代 注意问题：有一个重复判断的问题，即会无限迭代，所以有一个相应的布尔数组，
     * 判断过的位置取false，也就不再对这个位置进行迭代。
     *
     * */
    static void checkTheWinner(){
//		QiPanShuZu actionProcessThread = new QiPanShuZu(); //此处的对象只是为了能调用这个类里面的locate方法，可以将这个方法放在另一个类，同样能调用到这个方法
        //设置为静态方法就好了

        if(mapx[((int)a-10)/10][((int)b-100)/10]==0){
            if(blackOrBlue(click)){
                mapx[((int)a-10)/10][((int)b-100)/10]=1;
                num1=0;   //使num1等于零  执行完判断语句 只取num1增加的部分 然后下一次 再置零
                actionProcessThread.initializeBoolean(1, mapx);
                actionProcessThread.fanxiexy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);

                num2=0;
                actionProcessThread.initializeBoolean(1, mapx);
                actionProcessThread.zhengxiexy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);

                num3=0;
                actionProcessThread.initializeBoolean(1, mapx);
                actionProcessThread.shuipingxy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);

                num4=0;
                actionProcessThread.initializeBoolean(1, mapx);
                actionProcessThread.chuizhixy(((int)a-10)/10,((int)b-100)/10,1,mapx,map1);
//		    	System.out.println("BLACK:num1="+num1+"  num2="+num2+"  num3="+num3+"  num4="+num4);
            }
            else{
                mapx[((int)a-10)/10][((int)b-100)/10]=-1;
                num1=0;
                actionProcessThread.initializeBoolean(-1, mapx);
                actionProcessThread.fanxiexy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
                count1=num1; num1=0;

                num2=0;
                actionProcessThread.initializeBoolean(-1, mapx);
                actionProcessThread.zhengxiexy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
                count2=num2; num2=0;

                num3=0;
                actionProcessThread.initializeBoolean(-1, mapx);
                actionProcessThread.shuipingxy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
                count3=num3; num3=0;

                num4=0;
                actionProcessThread.initializeBoolean(-1, mapx);
                actionProcessThread.chuizhixy(((int)a-10)/10,((int)b-100)/10,-1,mapx,map1);
                count4=num4; num4=0;
//
//		    	System.out.println("BLUE:count1="+count1+"  count2="+count2+"  count3="+count3+"  count4="+count4);
            }
        }
    }
    public static void locate(double x,double y){
        int temp1=(int)x; int temp2=(int)y;

        a=temp1/10*10;
        b=temp2/10*10;
    }
    static void shuipingxy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
        if(mapx[i][j]==bw){
            map1[i][j]=false;//不对mapx数组进行任何写的操作，这一点很重要。
            num3++;
            shuiping(i,j,bw);
        }
        if(mapx[i][j]!=bw) return;
    }
    static void shuiping(int i,int j,int bw){

        if(i<40 && j+1<40 && i>=0 && j+1>=0 && map1[i][j+1]){shuipingxy(i,j+1,bw,mapx,map1);}  //if判断条件：越界则不创建副本，迭代过的位置同样不创建副本

        if(i<40 && j-1<40 && i>=0 && j-1>=0 && map1[i][j-1]){shuipingxy(i,j-1,bw,mapx,map1);}   //  shuipingxy(i,j-1) 自己调用自己的过程，即迭代
        // 此处自己调用自己的概念只是迭代比较流行的说法，但是原理其实还是一样的，shuipingxy()调用了shuiping(),
        // 然后shuiping()在经过逻辑判断以后又在两个方向上调用了shuipingxy(),所以其实还是shuipingxy()自己调用自己
        // 函数在mapx执行 而不是map1 map1只是标记迭代过的位置 作为是否在进行迭代的判断依据

    }
    static void chuizhixy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
        if(mapx[i][j]==bw){
            map1[i][j]=false;
            num4++;
            chuizhi(i,j,bw);
        }
        if(mapx[i][j]!=bw) return;
    }
    static void chuizhi(int i,int j,int bw){

        if(i-1<40 && j<40 && i-1>=0 && j>=0 && map1[i-1][j]){chuizhixy(i-1,j,bw,mapx,map1);}

        if(i+1<40 && j<40 && i+1>=0 && j>=0 && map1[i+1][j]){chuizhixy(i+1,j,bw,mapx,map1);}

    }
    static void zhengxiexy(int i,int j,int bw,int[][] mapx,boolean[][] map1){
        if(mapx[i][j]==bw){
            map1[i][j]=false;
            num2++;
            zhengxie(i,j,bw);
        }
        if(mapx[i][j]!=bw) return;
    }
    static void zhengxie(int i,int j,int bw){

        if(i-1<40 && j+1<40 && i-1>=0 && j+1>=0 && map1[i-1][j+1]){zhengxiexy(i-1,j+1,bw,mapx,map1);}

        if(i+1<40 && j-1<40 && i+1>=0 && j-1>=0 && map1[i+1][j-1]){zhengxiexy(i+1,j-1,bw,mapx,map1);}

    }
    static void fanxiexy(int i,int j,int bw,int[][] mapx,boolean[][] map1){

        if(mapx[i][j]!=bw) return;
        if(mapx[i][j]==bw){
            map1[i][j]=false;
            num1++;
            fanxie(i,j,bw);
        }
    }
    static void fanxie(int i,int j,int bw){

        if(i+1<40 && j+1<40 && i+1>=0 && j+1>=0 && map1[i+1][j+1]){fanxiexy(i+1,j+1,bw,mapx,map1);}

        if(i-1<40 && j-1<40 && i-1>=0 && j-1>=0 && map1[i-1][j-1]){fanxiexy(i-1,j-1,bw,mapx,map1);}
    }

    /**
     * 嵌套循环，初始化Boolean二维数组,
     * 比如说传入的棋子是黑棋，即bw=1;则初始化的结果是：有黑棋的位置为true，其它全为false，
     * int数组和Boolean数组其实结构一样的，Boolean数组中的取值代表int数组中对应位置是否可以迭代。
     * true意味着可迭代，反之不可迭代。
     * 在判断的过程中也会把迭代过的位置设为false，即迭代过了就设为不可迭代的状态。
     * @param bw
     * @param mapx
     * @return
     */
    static boolean[][] initializeBoolean(int bw,int[][] mapx){
        for(int i=0;i<40;i++){
            for(int j=0;j<40;j++){
                if(mapx[i][j]==bw) map1[i][j]=true;
                else map1[i][j]=false;
            }
        }
        return map1;
    }

    public static boolean blackOrBlue(int click){
        if(click%2==0) return true;
        else return false;
    }
    public static void listener(int num1,int num2,int num3,int num4,int count1,int count2,int count3,int count4){
        int [] array={num1,num2,num3,num4,count1,count2,count3,count4};
//    	System.out.println(num1+"  "+num2+"  "+num3+"  "+num4+"  "+count1+"  "+count2+"  "+count3+"  "+count4);
        for(int i=0;i<8;i++){
            if(array[i]>=5){
                if(i>=0 && i<=3){
                    new Qipant("black","GameOver");
                }
                if(i>=4 && i<=7){
                    new Qipant("blue","GameOver");
                }
            }
        }
    }
}
