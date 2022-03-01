class Bank{
    int amount;
    synchronized void sumbit(int a) {
        amount=a;
        System.out.println("Amount Submitted");
        notify();
//        notifyAll();
    }
    synchronized int withdraw() {
        if(amount==0) {
            try {
                wait();
            }catch (Exception e) {  }
        }
        return amount;
    }
}
class AAA extends Thread{
    Bank b;
    AAA(Bank b){
        this.b=b;
    }
    public void run() {
        b.sumbit(100000);
    }
}
class BBB extends Thread{
    Bank b;
    BBB(Bank b){
        this.b=b;
    }
    public void run() {
        System.out.println("Amount Withdraw: "+b.withdraw());
    }
}
public class WaitNotifyEx {
    public static void main(String[] args) {
        Bank bank=new Bank();
        new BBB(bank).start();
        new BBB(bank).start();
        new AAA(bank).start();
    }
}