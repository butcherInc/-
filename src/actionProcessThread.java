public class actionProcessThread  extends Thread{

    //Qipant�п������̵Ĳ������Զ�ͬ����actionProcessThread����
    static double a=10;static double b=100;
    static int click=0;  //��Ч�������  ������Ϊ����  ż����Ϊ�ڷ�
    static double x;static double y;static boolean in;
    //���������Լ��ж����Ĳ���
    static int[][] mapx=new int[40][40];//��ʼ���Ľ����0
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
        System.out.println("("+x+","+y+")"+"  ("+a+","+b+")"+"����¼��Ƿ�����������: "+in);
    }
    /*
     * �ж�Ӯ�ҵĺ��� �㷨������ ע�����⣺��һ���ظ��жϵ����⣬�������޵�����������һ����Ӧ�Ĳ������飬
     * �жϹ���λ��ȡfalse��Ҳ�Ͳ��ٶ����λ�ý��е�����
     *
     * */
    static void checkTheWinner(){
//		QiPanShuZu actionProcessThread = new QiPanShuZu(); //�˴��Ķ���ֻ��Ϊ���ܵ�������������locate���������Խ��������������һ���࣬ͬ���ܵ��õ��������
        //����Ϊ��̬�����ͺ���

        if(mapx[((int)a-10)/10][((int)b-100)/10]==0){
            if(blackOrBlue(click)){
                mapx[((int)a-10)/10][((int)b-100)/10]=1;
                num1=0;   //ʹnum1������  ִ�����ж���� ֻȡnum1���ӵĲ��� Ȼ����һ�� ������
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
            map1[i][j]=false;//����mapx��������κ�д�Ĳ�������һ�����Ҫ��
            num3++;
            shuiping(i,j,bw);
        }
        if(mapx[i][j]!=bw) return;
    }
    static void shuiping(int i,int j,int bw){

        if(i<40 && j+1<40 && i>=0 && j+1>=0 && map1[i][j+1]){shuipingxy(i,j+1,bw,mapx,map1);}  //if�ж�������Խ���򲻴�����������������λ��ͬ������������

        if(i<40 && j-1<40 && i>=0 && j-1>=0 && map1[i][j-1]){shuipingxy(i,j-1,bw,mapx,map1);}   //  shuipingxy(i,j-1) �Լ������Լ��Ĺ��̣�������
        // �˴��Լ������Լ��ĸ���ֻ�ǵ����Ƚ����е�˵��������ԭ����ʵ����һ���ģ�shuipingxy()������shuiping(),
        // Ȼ��shuiping()�ھ����߼��ж��Ժ��������������ϵ�����shuipingxy(),������ʵ����shuipingxy()�Լ������Լ�
        // ������mapxִ�� ������map1 map1ֻ�Ǳ�ǵ�������λ�� ��Ϊ�Ƿ��ڽ��е������ж�����

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
     * Ƕ��ѭ������ʼ��Boolean��ά����,
     * ����˵����������Ǻ��壬��bw=1;���ʼ���Ľ���ǣ��к����λ��Ϊtrue������ȫΪfalse��
     * int�����Boolean������ʵ�ṹһ���ģ�Boolean�����е�ȡֵ����int�����ж�Ӧλ���Ƿ���Ե�����
     * true��ζ�ſɵ�������֮���ɵ�����
     * ���жϵĹ�����Ҳ��ѵ�������λ����Ϊfalse�����������˾���Ϊ���ɵ�����״̬��
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
