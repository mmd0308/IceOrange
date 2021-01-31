package com.hzqing.rest.controller.explorer;

import com.hzqing.common.constants.GlobalConstants;
import com.hzqing.core.web.controller.BaseController;
import com.hzqing.explorer.dal.entity.ExpDateType;
import com.hzqing.explorer.service.ExpDateTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 衡钊清
 * @classname ExpDateTypeController
 * @description 数据类型管理
 * @date 2020/7/24 22:39
 */
@RestController
@RequestMapping("/explorer" + GlobalConstants.VERSION_V1 + "/types")
public class ExpDateTypeController extends BaseController<ExpDateTypeService, ExpDateType> {
}
