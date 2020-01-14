import compiler_error.Compiler_Error_Check;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Compiler_Error_Check error = new Compiler_Error_Check();
        String compiler_error_msg = "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:144: error: cannot find symbol\n" +
                "Account account = new Account();";
        JSONObject json_error = error.Jsonify(compiler_error_msg);
        System.out.println(json_error.toString());

    }
}
