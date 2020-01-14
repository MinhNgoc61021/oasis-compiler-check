package compiler_error;

import org.json.JSONObject;

import java.util.regex.Pattern;

public class Compiler_Error {

    public JSONObject Jsonify(String input) {
        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);
        JSONObject json_err_msg = new JSONObject();
        String[] compile_error_arr = regex.split(input);

        for (String line: compile_error_arr) {
            if (line.matches("(.*)^(symbol):(.*)")) {
                json_err_msg.put("symbol", line.split("symbol:")[1].trim());
            }
            else if (line.matches("(.*)^(location):(.*)")) {
                json_err_msg.put("className", line.split("location:")[1].trim());
            }
            else if (line.contains(":")) {
                String[] line_array = line.split(":");
                for (String split_string: line_array) {
                    // Truy vấn để kiểm tra
                    if (split_string.trim().matches("(.*)^[\\d]+$(.*)")) {
                        json_err_msg.put("line", split_string);
                    }
                    else if (split_string.matches("(.*)^(\\w+)\\.(java)$(.*)")) {
                        json_err_msg.put("message", line_array[line_array.length - 1].trim());
                    }
//                    else if (split_string.matches("^\\<[\\w \\W ]*\\> but was$")) {
//
//                    }

                }
            }
        }
        return json_err_msg;
    }
}
