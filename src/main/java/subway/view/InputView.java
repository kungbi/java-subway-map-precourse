package subway.view;

public class InputView {

    String getUserInput(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        return Console.readline();
    }

}
