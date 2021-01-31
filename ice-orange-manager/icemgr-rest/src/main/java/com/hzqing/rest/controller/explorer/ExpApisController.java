package com.hzqing.rest.controller.explorer;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.core.web.controller.BaseController;
import com.hzqing.explorer.dal.entity.ExpApis;
import com.hzqing.explorer.service.ExpApisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname ExpApisController
 * @description apis
 * @date 2020-08-02 09:25
 */
@RestController
@RequestMapping("/explorer" + GlobalConstants.VERSION_V1 + "/apis")
public class ExpApisController  extends BaseController<ExpApisService, ExpApis> {
}
