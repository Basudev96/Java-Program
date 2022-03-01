class AA extends Thread{
    String r1,r2;
    AA(String s1,String s2){
        r1=s1;
        r2=s2;
    }
    public void run() {
        synchronized (r1) {
            System.out.println("AA locked R1");
            synchronized (r2) {
                System.out.println("AA locked R2");
            }
        }
    }
}
class BB extends Thread{
    String r1,r2;
    BB(String s1,String s2){
        r1=s1;
        r2=s2;
    }
    public void run() {
        synchronized (r2) {
            System.out.println("BB locked R2");
//			synchronized (r1) {
//				System.out.println("BB locked R1");
//			}
        }
        synchronized (r1) {
            System.out.println("BB locked R1");
        }
    }
}
public class DeadLockEx {
    public static void main(String[] args) {
        String r1="Hello";
        String r2="Hi";
        new AA(r1,r2).start();
        new BB(r1,r2).start();
    }
}