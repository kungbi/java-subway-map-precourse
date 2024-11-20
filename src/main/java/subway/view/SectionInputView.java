package subway.view;

public class SectionInputView {
    public static String getLineName() {
        System.out.println("## 노선을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getStationName() {
        System.out.println("## 역이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getOrderNumber() {
        System.out.println("## 순서를 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRemoveLineName() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRemoveStationName() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return InputView.getUserInput();
    }
}
