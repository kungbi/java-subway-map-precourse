package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
