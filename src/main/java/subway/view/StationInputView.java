package subway.view;

public class StationInputView {
    public static String getRegisterStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRemoveStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return InputView.getUserInput();
    }
}
