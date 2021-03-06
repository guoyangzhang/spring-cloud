/*
 *  Copyright 2019 https://github.com/romeoblog/spring-cloud.git Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.cloud.mesh.auth.controller;

import com.cloud.mesh.auth.entity.PermissionDTO;
import com.cloud.mesh.auth.service.IPermissionService;
import com.cloud.mesh.common.model.ResultMsg;
import com.cloud.mesh.model.auth.ResultMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限控制层
 *
 * @author Benji
 * @date 2019-06-17
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/checkToken")
    public ResultMsg<ResultMessageVO> checkToken(@RequestParam("token") String token) {
        return ResultMsg.ok(permissionService.checkToken(token));
    }

    @PostMapping("/checkPermission")
    public Boolean checkPermission(@RequestBody PermissionDTO permissionDTO) {
        return permissionService.checkPermission(permissionDTO);
    }

}
