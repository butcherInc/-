
public class Main {
    public static void main(String[] args){
        System.out.println("main(): "+Thread.currentThread().getName());
        Qipant qipant=new Qipant("������");
        qipant.setVisible(true);
    }
}
