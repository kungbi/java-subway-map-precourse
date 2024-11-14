package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        if (name == null) {
            throw new IllegalArgumentException("역의 이름이 NULL");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("역의 이름은 2자 이상이어야 함.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
