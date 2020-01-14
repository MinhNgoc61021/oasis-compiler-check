package false_text;

import org.json.JSONObject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class False_Text_Check {
    private JSONObject true_result;
    private JSONObject false_result;

    public void Jsonify(String input) {
        true_result = new JSONObject();
        false_result = new JSONObject();
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
        // gán lại false để xử lý các msg sau
        expected = false;
        but_was = false;

        // System.out.println(expected_queue.toString());
        // System.out.println(but_was_queue.toString());

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

         System.out.println(true_result_data.toString());
         System.out.println(false_result_data.toString());

        true_result.put("trueResult", true_result_data);
        false_result.put("falseResult", false_result_data);

        setTrue_result(true_result);
        setFalse_result(false_result);
    }

    public JSONObject getTrue_result() {
        return true_result;
    }

    private void setTrue_result(JSONObject true_result) {
        this.true_result = true_result;
    }

    public JSONObject getFalse_result() {
        return false_result;
    }

    private void setFalse_result(JSONObject false_result) {
        this.false_result = false_result;
    }
}
