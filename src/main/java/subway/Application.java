package subway;

import subway.config.DependencyInjector;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new DependencyInjector();
        SubwayController subwayController = dependencyInjector.createSubwayController();

        subwayController.run();
    }
}
