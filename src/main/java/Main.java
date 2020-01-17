import compiler_error.Compiler_Error_Check;
import false_test.False_Test_Check;
import org.json.JSONObject;
import string_process.String_Process;

import java.util.List;

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
        String_Process string_process = new String_Process();
        String[] compiler_error_array = string_process.toCompilerErrorArray(compiler_error_msg);
        System.out.println("Compiler Error: ");
        for (String each_error: compiler_error_array) {
            JSONObject json_error = error.Jsonify(each_error);
            System.out.println(json_error.toString());
        }
        System.out.println(compiler_error_array.length + " error(s)");

        String test_err = "testPrintTransaction(MyTest): expected:<[Giao dich 1: Nap tien $3000.68. So du luc nay: $3000.68.\n" +
                "Giao dich 2: Nap tien $3000.00. So du luc nay: $6000.68.\n" +
                "Giao dich 3: Rut tien $1000.00. So du luc nay: $5000.68.\n" +
                "Giao dich 4: Rut tien $2000.00. So du luc nay: $3000.68.]> but was:<[Yeu cau khong hop le!\n" +
                "Yeu cau khong hop le!\n" +
                "Yeu cau khong hop le!\n" +
                "Yeu cau khong hop le!]>\n" +
                "testWithdraw1(MyTest): expected:<[So tien ban rut ra] khong hop le!> but was:<[Yeu cau khong hop le!\n" +
                "Yeu cau] khong hop le!>\n" +
                "testWithdraw2(MyTest): expected:<[So tien ban rut vuot qua so du]!> but was:<[Yeu cau khong hop le!\n" +
                "Yeu cau khong hop le]!>\n" +
                "testWithdraw3(MyTest): expected:<[So tien ban rut vuot qua so du]!> but was:<[Yeu cau khong hop le]!>\n" +
                "testWithdraw4(MyTest): expected:<[Giao dich 1: Nap tien $1000.00. So du luc nay: $1000.00.\n" +
                "Giao dich 2: Rut tien $500.00. So du luc nay: $500.00.]> but was:<[Yeu cau khong hop le!\n" +
                "Yeu cau khong hop le!]>\n" +
                "testDeposit1(MyTest): expected:<[So tien ban nap vao] khong hop le!> but was:<[Yeu cau] khong hop le!>\n" +
                "testDeposit2(MyTest): expected:<[Giao dich 1: Nap tien $1000.00. So du luc nay: $1000.00.]> but was:<[Yeu cau khong hop le!]>\n";

        System.out.println("False Test: ");
        List<String> false_test_list = string_process.toFalseTestArray(test_err);
        False_Test_Check false_test_check = new False_Test_Check();
        for (String each_error: false_test_list) {
            false_test_check.Jsonify(each_error);
        }
        System.out.println(false_test_check.getDiff_error());

    }
}
