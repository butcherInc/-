
public class Main {
    public static void main(String[] args){
        System.out.println("this.main(): "+Thread.currentThread().getName());
        Qipant qipant=new Qipant("������");
        qipant.setVisible(true);
    }
}
