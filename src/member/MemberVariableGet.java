package member;

import java.lang.reflect.Field;

public class MemberVariableGet {

    /**
     * メンバ変数を全て取得する
     */
    public static void main(String arg[]) {

    	// インスタンスから取得
    	Example ex = new Example();
        for (Field field : ex.getClass().getDeclaredFields()) {
            try {
				System.out.printf(field.getName() + " = " + field.get(ex) + "\n");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				//e.printStackTrace();
				System.out.printf(field.getName() + " = " + "[private]" + "\n");
			}
        }

        System.out.println();

        // スタテックで取得(インスタンスメンバの値は取れない？)
        for (Field field : Example.class.getDeclaredFields()) {
				System.out.printf(field.getName() + "\n");
        }

    }


}

class Example {
    public String name = "nameA";
    public Integer id = 12345;

    @SuppressWarnings("unused")
    private String privateName = "xxx";
    @SuppressWarnings("unused")
	private static Integer privateId = 999;

}