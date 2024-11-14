package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;

public class LineRepository implements Repository<Line> {
    private static final List<Line> lines = new ArrayList<>();

    public static void clear() {
        lines.clear();
    }

    @Override
    public void add(Line line) {
        if (line == null) {
            throw new IllegalArgumentException();
        }
        if (findByName(line.getName()) != null) { // 중복 체크
            throw new IllegalArgumentException();
        }
        lines.add(line);
    }

    @Override
    public void deleteStation(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                lines.remove(line);
                return;
            }
        }
        throw new IllegalArgumentException("삭제할게 없음");
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
