package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Station;

public class StationRepository implements Repository<Station> {
    private static final List<Station> stations = new ArrayList<>();

    @Override
    public void add(Station data) {
        stations.add(data);
    }

    @Override
    public boolean deleteStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                stations.remove(station);
                return true;
            }
        }
        return false;
    }
}
