package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Station;
import subway.exception.StationExceptionMessage;

public class StationRepository implements Repository<Station> {

    private final List<Station> stations = new ArrayList<>();

    @Override
    public void add(Station station) {
        if (station == null) {
            throw new IllegalArgumentException();
        }
        if (this.findByName(station.getName()) != null) {
            throw new IllegalArgumentException(StationExceptionMessage.EXIST_STATION_NAME.getMessage());
        }
        stations.add(station);
    }

    @Override
    public void remove(Station station) {
        stations.remove(station);
    }

    @Override
    public int getSize() {
        return stations.size();
    }

    @Override
    public Station findByName(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    @Override
    public List<Station> findAll() {
        return this.stations;
    }
}
