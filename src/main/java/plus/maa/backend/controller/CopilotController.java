package plus.maa.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plus.maa.backend.common.annotation.CurrentUser;
import plus.maa.backend.controller.request.CopilotCUDRequest;
import plus.maa.backend.controller.request.CopilotQueriesRequest;
import plus.maa.backend.controller.response.CopilotInfo;
import plus.maa.backend.controller.response.CopilotPageInfo;
import plus.maa.backend.controller.response.MaaResult;
import plus.maa.backend.service.CopilotService;
import plus.maa.backend.service.model.LoginUser;

/**
 * @author LoMu
 * Date  2022-12-25 17:08
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/copilot")
public class CopilotController {
    private final CopilotService copilotService;

    @PostMapping("/upload")
    public MaaResult<String> uploadCopilot(@CurrentUser LoginUser loginUser,
                                           @RequestBody CopilotCUDRequest request) {
        return copilotService.upload(loginUser, request.getContent());
    }

    @PostMapping("/delete")
    public MaaResult<Void> deleteCopilot(@CurrentUser LoginUser loginUser,
                                         @RequestBody CopilotCUDRequest request) {
        return copilotService.delete(loginUser, request);
    }

    @GetMapping("/get/{id}")
    public MaaResult<CopilotInfo> getCopilotById(@PathVariable("id") String id) {
        return copilotService.getCopilotById(id);
    }


    @GetMapping("/query")
    public MaaResult<CopilotPageInfo> queriesCopilot(CopilotQueriesRequest request) {
        return copilotService.queriesCopilot(request);
    }

    @PostMapping("/update")
    public MaaResult<Void> updateCopilot(@CurrentUser LoginUser loginUser,
                                         @RequestBody CopilotCUDRequest request) {
        return copilotService.update(loginUser, request.getId(), request.getContent());
    }

    @PostMapping("/rating")
    public MaaResult<Void> ratesCopilotOperation(CopilotQueriesRequest request) {
        return null;
    }

}
