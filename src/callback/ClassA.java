package callback;

public class ClassA implements ClassB.callback {

	//ClassA() {

	//}

	public static void main(String[] args) {

		ClassA a = new ClassA();

		ClassB b = new ClassB(a);

		b.method_BinC("test!");

	}

	public void backMethod(String str) {
		System.out.println("A実装のコールバック: " + str);
	}

}

class ClassB {

	private ClassA a = null;
	ClassB (ClassA a){
		this.a = a;
	}

	interface callback {
		void backMethod(String str);
	}

	void method_BinC(String str) {
		a.backMethod("sss");
	}



}
