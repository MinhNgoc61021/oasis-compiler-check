package false_test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

// Xử lý lỗi sai
public class False_Test_Check {
    private JSONObject result = new JSONObject();;
    private JSONArray diff_error_array = new JSONArray(); // mảng JSON để đẩy result vào
    private JSONObject highlight = new JSONObject(); // JSON đẻ lưu false result và true result
    private JSONObject diff_error = new JSONObject(); // JSON để lưu vào ShowDiffError

    public void Jsonify(String input) {
        String newLine = System.getProperty("line.separator");

        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);
        String[] false_text_arr = regex.split(input);
        Queue<String> expected_queue = new LinkedList<>();
        Queue<String> but_was_queue = new LinkedList<>();
        boolean expected = false; // kiểm tra khi đến dòng có expected
        boolean but_was = false; // kiểm tra khi đến dòng có but was

        for (String txt: false_text_arr) {
            // khi lần đầu có expected và chưa có but was
            if (txt.contains("expected:") && !txt.contains("but was:") && !expected) {
                expected = true;
                String[] line_array = txt.split("expected:");
                expected_queue.add(line_array[1].split("<")[1]);
            }
            // khi dòng tiếp sau expected ko có but was
            else if (!txt.contains("but was:") && !but_was && expected ) {
                // System.out.println(txt.split("]>")[0]);
                expected_queue.add(txt.split(">")[0]);
            }
            // khi lần đầu có bưt was và không có expected
            else if (txt.contains("but was:") && !txt.contains("expected:") && !but_was) {
                but_was = true;
                expected = false;
                String[] line_array = txt.split("but was:");
                expected_queue.add(line_array[0].split(">")[0]);
                but_was_queue.add(line_array[1].split("<")[1]);
            }
            // khi dòng tiếp có bưt was và không có expected
            else if (!expected && but_was) {
                but_was_queue.add(txt.split(">")[0]);
            }
            // khi lần đầu có cả expected và cả but was
            else if (txt.contains("expected:") && txt.contains("but was:") && !but_was && !expected) {
                expected = true;
                but_was = true;
                String[] line_array = txt.split("expected:");
                expected_queue.add(line_array[1].split("<")[1].split(">")[0]);
                but_was_queue.add(line_array[1].split("but was:")[1].split("<")[1].split(">")[0]);
            }
        }

        StringBuffer true_result_data = new StringBuffer();
        StringBuffer false_result_data = new StringBuffer();

        // Duyệt từng dòng trong expected_queue để đẩy vào chuỗi true_result
        for (Object line: expected_queue) {
            true_result_data.append(line.toString()).append(newLine);
        }

        // Duyệt từng dòng trong but_was_queue để đẩy vào chuỗi true_result
        for (Object line: but_was_queue) {
            false_result_data.append(line.toString()).append(newLine);
        }

        result.put("trueResult", true_result_data);
        result.put("falseResult", false_result_data);
        diff_error.put("ShowDiffError", result);
        diff_error_array.put(diff_error);

        highlight.put("highlight", diff_error_array);
    }

    public JSONObject getHighlight() {
        return highlight;
    }
}
