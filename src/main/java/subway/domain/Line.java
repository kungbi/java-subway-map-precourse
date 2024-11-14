package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, Station startStation, Station endStation) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }
        if (startStation == null || endStation == null) {
            throw new IllegalArgumentException();
        }
        if (Objects.equals(startStation.getName(), endStation.getName())) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.stations = new ArrayList<>(List.of(startStation, endStation));
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(Station station, int index) {
        stations.add(index, station);
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getStationCount() {
        return stations.size();
    }

    public List<String> getStationNames() {
        return stations.stream().map(Station::getName).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
