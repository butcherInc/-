public class Panduanx{
	static int[][] map={
		{0,0,0,0,0,1,0,1,0,1},
		{0,0,0,0,0,0,1,1,1,0},
		{1,1,0,1,1,1,1,1,1,1},
		{0,0,0,0,1,0,1,1,1,0},
		{0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,1,0,0},
		{0,1,0,1,0,0,0,1,0,0},
		{0,0,1,0,0,0,0,1,0,0},
		{0,1,0,1,0,0,0,1,0,0},
		{1,0,0,0,1,0,0,1,0,0}};
//	static int[][]mapx=new int[40][40];
	static int num1=0;static int num2=0;
	static int num3=0;static int num4=0;
	static boolean[][] map1 = new boolean[10][10];
//	static int[][] map2 = new int[10][10];
	static int[][] map3 = new int[10][10];
	static int[][] map4 = new int[10][10];
	public static void main(String[] args){
		Panduanx ob=new Panduanx();
		map1=ob.initializeBoolean(map);
//		map2=ob.Mycopy(map2);
		map3=ob.Mycopy(map3);
		map4=ob.Mycopy(map4);
		map4[0][0]=4;
		ob.fanxiexy(7,2,map,map1);
	//	Panduan.Myprint(map1);
		System.out.println("fanxie:  num1="+num1);
		
		map1=ob.initializeBoolean(map);   //在没执行一条语句时都要 更新bool数组
		ob.zhengxiexy(2,7,map,map1);
//		Panduan.Myprint(map2);
		System.out.println("zhengxie:  num2="+num2);
		
		ob.shuipingxy(2,7,map3);
		Panduan.Myprint(map3);
		System.out.println("shuiping:  num3="+num3);
		
		ob.chuizhixy(2,7,map4);
		Panduan.Myprint(map4);
		System.out.println("chuizhi:  num4="+num4);
	}
	void shuipingxy(int i,int j,int[][] mapx){
		if(mapx[i][j]==1){
			mapx[i][j]=2;
			num3++;
			shuiping(i,j);
		}
		if(mapx[i][j]!=1) return;
	}
	void shuiping(int i,int j){
		if(i<=9 && j+1<=9 && i>=0 && j+1>=0){shuipingxy(i,j+1,map3);}  //越界则不创建副本
		else return;
		if(i<=9 && j-1<=9 && i>=0 && j-1>=0){shuipingxy(i,j-1,map3);}  //shuipingxy(i,j-1) 调用了父类的函数   函数在map执行   而不是map3
		else return;
	}
	void chuizhixy(int i,int j,int[][] mapx){
		if(mapx[i][j]==1){
			mapx[i][j]=2;
			num4++;
			chuizhi(i,j);
		}
		if(mapx[i][j]!=1) return;
	}
	void chuizhi(int i,int j){
		if(i-1<=9 && j<=9 && i-1>=0 && j>=0){chuizhixy(i-1,j,map4);}  //越界则不创建副本
		else return;
		if(i+1<=9 && j<=9 && i+1>=0 && j>=0){chuizhixy(i+1,j,map4);}
		else return;
	}
	void zhengxiexy(int i,int j,int[][] mapx,boolean[][] map1){
		if(mapx[i][j]==1){
			map1[i][j]=false;
			num2++;
			zhengxie(i,j);
		}
		if(mapx[i][j]!=1) return;
	}
	void zhengxie(int i,int j){
		if(i-1<=9 && j+1<=9 && i-1>=0 && j+1>=0 && map1[i-1][j+1]){zhengxiexy(i-1,j+1,map,map1);}  //越界则不创建副本
//		else return;
		if(i+1<=9 && j-1<=9 && i+1>=0 && j-1>=0 && map1[i+1][j-1]){zhengxiexy(i+1,j-1,map,map1);}
//		else return;
	}
	void fanxiexy(int i,int j,int[][] mapx,boolean[][] bool){
		if(mapx[i][j]!=1) return;
		if(mapx[i][j]==1){
			num1++;
			bool[i][j]=false;
			fanxie(i,j);
		}
	}
	void fanxie(int i,int j){
		
		if(i+1<=9 && j+1<=9 && i+1>=0 && j+1>=0 &&map1[i+1][j+1]){
			System.out.println("fanxie(i+1,j+1)  num1="+num1);
			fanxiexy(i+1,j+1,map,map1);}  //越界则不创建副本
	//	else return;                                //这句话使程序提前跳出 fanxiexy(i-1,j-1)少执行了一次 
		if(i-1<=9 && j-1<=9 && i-1>=0 && j-1>=0 &&map1[i-1][j-1]){
			System.out.println("fanxie(i-1,j-1)  num1="+num1);
			System.out.println("fanxie(i-1,j-1)  map:"+map[i-1][j-1]+"  boolmap1:"+map1[i-1][j-1]);
			System.out.println("fanxie(i-1,j-1)  map1[5][0]="+map1[5][0]);
			fanxiexy(i-1,j-1,map,map1);}
	//	else return;
	}
    static void Myprint(int[][] mapx){
    	for(int j=0;j<10;j++){
			for(int i=0;i<10;i++){
				System.out.print(mapx[j][i]+"  ");
			}
			System.out.println();
		}
    }
    void Myprint(boolean[][] mapx){
    	for(int j=0;j<10;j++){
			for(int i=0;i<10;i++){
				System.out.print(mapx[j][i]+"  ");
			}
			System.out.println();
		}
    }
    int[][] Mycopy(int[][] mapx){
    	for(int j=0;j<10;j++){
    		for(int i=0;i<10;i++){
    			mapx[j][i]=map[j][i];
    		}
    	}
    	return mapx;
    }
    boolean[][] initializeBoolean(int[][] mapx){
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			if(mapx[i][j]==1) map1[i][j]=true;
    			else map1[i][j]=false;
    		}
    	}
    	return map1;
    }
}

