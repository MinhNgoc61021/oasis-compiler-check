import compiler_error.Compiler_Error_Check;
import false_text.False_Text_Check;
import org.json.JSONObject;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Compiler_Error_Check error = new Compiler_Error_Check();
        String compiler_error_msg = "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:144: error: cannot find symbol\n" +
                "Account account = new Account();";
        JSONObject json_error = error.Jsonify(compiler_error_msg);
        System.out.println(json_error.toString());

        String err = "testDeposit2(MyTest): expected:<[Giao dich 1: Nap tien $1000.00. So du luc nay: $1000.00.]> but was:<[Yeu cau khong hop le!]>";

        False_Text_Check false_text_check = new False_Text_Check();
        false_text_check.Jsonify(err);
        System.out.println(false_text_check.getTrue_result());
        System.out.println(false_text_check.getFalse_result());
    }
}
