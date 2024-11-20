package subway.controller.handler;

import subway.command.Command;
import subway.command.SectionCommand;
import subway.controller.retryInputUtil.SectionRetryInput;
import subway.dto.SectionRegisterDto.SectionRegisterInputDto;
import subway.dto.SectionRemoveDto.SectionRemoveInputDto;
import subway.service.SectionService;
import subway.view.OutputView;

public class SectionHandler implements Handler {
    private final SectionService sectionService;

    public SectionHandler(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public void handle() {
        OutputView.printSectionManageMenu();
        SectionCommand sectionCommand = Command.findCommand(SectionRetryInput.getCommand(),
                SectionCommand.values());

        if (sectionCommand == SectionCommand.REGISTER) {
            registerSection();
        }
        if (sectionCommand == SectionCommand.REMOVE) {
            removeSection();
        }
        if (sectionCommand == SectionCommand.BACK) {
            // nothing to do.
        }

    }

    private void registerSection() {
        String lineName = SectionRetryInput.getLineName();
        String stationName = SectionRetryInput.getStationName();
        int orderNumber = SectionRetryInput.getOrderNumber();
        sectionService.register(new SectionRegisterInputDto(lineName, stationName, orderNumber));
    }

    private void removeSection() {
        String lineName = SectionRetryInput.getRemoveLineName();
        String stationName = SectionRetryInput.getRemoveStationName();
        sectionService.remove(new SectionRemoveInputDto(lineName, stationName));
        OutputView.printSectionRemovedMessage();
    }
}
