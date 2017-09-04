package thread_THreadLocal;

class Int {
    // インスタンス変数の宣言
    private int i;

    // getter
    public int getInt() {
        return i;
    }
    // setter
    public void setInt(int i) {
        this.i = i;
    }
}

class NewInt {

    // 現行スレッドの初期値を取得
    private static ThreadLocal<Int> tl = new ThreadLocal<Int>(){
        @Override
        protected Int initialValue(){
            return new Int();
        }
    };

    //　現行スレッドの値を取得
    private static Int getNewInt(){
        return tl.get();
    }

    // 現行スレッドでのgetter
    public static int getInt(){
        return getNewInt().getInt();
    }

    // 現行スレッドでのsetter
    public static void setInt(int i){
        getNewInt().setInt(i);
    }
}

class ThreadTest extends Thread {

    int val = 0;

    // コンストラクタ
    public ThreadTest(int val){
        this.val = val;
    }

    public void run() {
        for (int i = 0; i < 5; i++){

            // ThreadTestクラスのメンバ変数valの値を
            // Intクラスのインスタンス変数にセット
            NewInt.setInt(val);

            // 1秒(1000ミリ秒)待機
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }

            // 処理結果の表示
            // valの値とIntクラスのクラス変数の値が異なる場合は異常でエラーを表示"
            String message = getName() + ": val = " + val + ", i = " + NewInt.getInt();
            if (val == NewInt.getInt()) {
                System.out.println(message);
            } else {
                System.out.println(message + " エラー");
            }
        }
    }
}


public class MyAppTest2 {

    public static void main(String[] args) {
        ThreadTest tt1 = new ThreadTest(0);
        ThreadTest tt2 = new ThreadTest(1);

        tt1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }
        tt2.start();
    }

}
