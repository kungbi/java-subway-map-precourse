package subway.view;

public class InputView {

    public static String getUserInput() {
        System.out.print("> ");
        String input = Console.readline();
        System.out.println();
        return input;
    }

    public static String getCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return getUserInput();
    }
}
