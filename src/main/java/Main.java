import compiler_error.Compiler_Error_Check;
import false_text.False_Text_Check;
import org.json.JSONObject;
import string_process.String_Process;

public class Main {

    public static void main(String[] args) {
        Compiler_Error_Check error = new Compiler_Error_Check();
        String compiler_error_msg = "MyTest.java:23: error: cannot find symbol\n" +
                "depositMethod = JavaReflection.getMethod(Account.class, deposit, void.class, ,\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:25: error: cannot find symbol\n" +
                "withdrawMethod = JavaReflection.getMethod(Account.class, withdraw, void.class, , ,\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:27: error: cannot find symbol\n" +
                "addTransactionMethod = JavaReflection.getMethod(Account.class, addTransaction, void.class, ,,\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:29: error: cannot find symbol\n" +
                "printTransactionMethod= JavaReflection.getMethod(Account.class, printTransaction, void.class, , );\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:50: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:50: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:62: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:62: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:76: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:76: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:89: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:89: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:102: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:102: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:114: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:114: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:129: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:129: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:144: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:144: error: cannot find symbol\n" +
                "Account account = new Account();\n" +
                "^\n" +
                "symbol: class Account\n" +
                "location: class MyTest\n" +
                "20 errors\n";
        String_Process array = new String_Process();
        String[] compiler_error_array = array.toErrorArray(compiler_error_msg);
        int i = 0;
        for (String each_error: compiler_error_array) {
            JSONObject json_error = error.Jsonify(each_error);
            System.out.println(json_error.toString());
        }
        System.out.println(compiler_error_array.length + " error(s)");
//        JSONObject json_error = error.Jsonify(compiler_error_msg);
//        System.out.println(json_error.toString());
//
//        String err = "testWithdraw1(MyTest): expected:<[So tien ban rut ra] khong hop le!> but was:<[Yeu cau khong hop le!\n" +
//                "Yeu cau] khong hop le!>";
//
//        False_Text_Check false_text_check = new False_Text_Check();
//        false_text_check.Jsonify(err);
//        System.out.println(false_text_check.getTrue_result());
//        System.out.println(false_text_check.getFalse_result());
    }
}
