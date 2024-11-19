package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.GlobalExceptionMessage;
import subway.exception.LineExceptionMessage;

public class LineRepository implements Repository<Line> {
    private final List<Line> lines = new ArrayList<>();

    public void addStation(Line line, Station station) {
        line.addStation(station);
    }

    public void addStation(Line line, Station station, int index) {
        line.addStation(station, index);
    }

    public void removeStation(Line line, Station station) {
        line.removeStation(station);
    }

    @Override
    public void add(Line line) {
        if (line == null) {
            throw new IllegalArgumentException(GlobalExceptionMessage.NULL_POINTER.getMessage());
        }
        if (this.findByName(line.getName()) != null) { // 중복 체크
            throw new IllegalArgumentException(LineExceptionMessage.EXIST_LINE_NAME.getMessage());
        }
        lines.add(line);
    }

    @Override
    public void remove(Line line) {
        lines.remove(line);
    }

    @Override
    public int getSize() {
        return lines.size();
    }

    @Override
    public Line findByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }

    @Override
    public List<Line> findAll() {
        return lines;
    }
}
