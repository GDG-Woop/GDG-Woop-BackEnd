package com.example.woop.building;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.woop.building.response.BuildingGetOverallRes;
import com.example.woop.common.utils.ApiUtils.ApiResult;
import static com.example.woop.common.utils.ApiUtils.success;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/building")
@RequiredArgsConstructor
public class BuildingController {
    private final BuildingService buildingService;

    @GetMapping("/overall")
    public ApiResult<BuildingGetOverallRes> getBuildingOverall(@RequestParam(name = "user_id") int userId) {
        return success(buildingService.getBuildingOverall(userId));
    }
}
