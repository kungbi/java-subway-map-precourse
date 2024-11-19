package subway.controller.handler;

import java.util.List;
import subway.command.Command;
import subway.command.StationCommand;
import subway.controller.retryInputUtil.StationRetryInput;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.service.StationService;
import subway.view.OutputView;

public class StationHandler implements Handler {
    private final StationService stationService;

    public StationHandler(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void handle() {
        OutputView.printStationManageMenu();
        StationCommand stationCommand = Command.findCommand(StationRetryInput.getCommand(), StationCommand.values());

        if (stationCommand == StationCommand.REGISTER) {
            registerStation();
        }
        if (stationCommand == StationCommand.REMOVE) {
            removeStation();
        }
        if (stationCommand == StationCommand.RETRIEVE) {
            retrieveStation();
        }
        if (stationCommand == StationCommand.BACK) {
            // nothing to do.
        }
    }

    private void registerStation() {
        String stationName = StationRetryInput.getStationName();
        stationService.register(new StationRegisterInputDto(stationName));
    }

    private void removeStation() {
        String stationName = StationRetryInput.getRemoveStationName();
        stationService.remove(new StationRemoveInputDto(stationName));
        OutputView.printStationRemovedMessage();
    }

    private void retrieveStation() {
        List<StationDto> stations = stationService.retrieve().stations();
        OutputView.printStations(stations);
    }
}
