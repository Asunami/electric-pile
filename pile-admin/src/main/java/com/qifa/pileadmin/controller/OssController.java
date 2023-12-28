package com.qifa.pileadmin.controller;


import com.qifa.pileadmin.dto.OssPolicyResult;
import com.qifa.pileadmin.service.OssService;
import com.qifa.pilecommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "OSSController",description = "oss上传相关")
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("获取直传所需签名")
    @GetMapping("/policy")
    public CommonResult<OssPolicyResult> policy(){
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

}
