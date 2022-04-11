public class SpendMoneyTogether {
    public static void main(String[] args) {
        BankAccount card1 = new BankAccount();

        Runnable you = new Runnable() {
            public void run() {
                for(int i =0; i<50; i++){
                    card1.setMoney1(card1.getMoney1()+10000);
                    System.out.println(Thread.currentThread().getName()+"存了10000，余额是"+card1.getMoney1());
                }
            };
        };

        Runnable me = new Runnable() {
            public void run() {
                for(int i=0; i<50; i++){
                    if(card1.getMoney1()>=1000){
                        card1.setMoney1(card1.getMoney1()-1000);
                        System.out.println(Thread.currentThread().getName()+"取了1000，余额是"+card1.getMoney1());
                    }else{
                        System.out.println("余额不足，请尽快存钱");
                        i--;
                    }
                }
            };
        };
        //这样创建线程直接运行比较牛逼看出来没
        new Thread(you,"Andrew").start();
        new Thread(me,"Amelia").start();
    }
}
