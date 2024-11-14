package subway.view;

public class InputView {

    public String getCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return getUserInput();
    }

    public String getRegisterStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRemoveStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRemovedLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return getUserInput();
    }


    private String getUserInput() {
        System.out.print("> ");
        String input = Console.readline();
        System.out.println();
        return input;
    }
}
