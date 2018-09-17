package com.example.gz.controller;

import com.example.gz.bean.FunctionWithGroup;
import com.example.gz.bean.UserGroup;
import com.example.gz.service.IGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Api(value = "用户组 Controller")
@ControllerAdvice
public class GroupController {

    @Autowired
    private IGroupService groupService;

    /**
     * 添加一个组
     * @param userGroup
     * @return
     */
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = "application/json")
    public Map<?,?> addNewGroup(UserGroup userGroup) {
        return groupService.save(userGroup);
    }

    /**
     * 删除一个组
     */
    @RequestMapping(value = "deleteGroup/{id}",method = RequestMethod.GET,produces = "application/json")
    public Map<?,?> deleteGroup(@PathVariable("id") int id){
        return groupService.deleteGroup(id);
    }

    /**
     * 选择一个组
     */
    @ApiOperation(value = "选择一个组", notes = "根据用户组 id 选择一个组")
    @RequestMapping(value = "/selectGroup/{id}", method = RequestMethod.GET)
    public Map<?, ?> selectGroupById(@PathVariable("id") int id){
        return groupService.selectGroupById(id);
    }

    /**
     * 更新一个组
     */
    @ApiOperation(value = "更新一个组", notes = "根据用户组 id 更新用户组的描述")
    @RequestMapping(value = "/updateDescription/{id}", method = RequestMethod.POST)
    public Map<?, ?> updateDescription(@RequestParam("id") int id,
                                    @RequestParam("description") String description) {
        return groupService.update(id, description);
    }

    /**
     * 选择所有的组
     * @return
     */
    @ApiOperation(value = "查询所有用户组供添加职工使用", notes = "查询所有用户组")
    @RequestMapping(value = "/selectAllGroup", method = RequestMethod.GET)
    public Map<?, ?> selectAll() {
        return groupService.findAll();
    }


    @ApiOperation(value = "查询权限")
    @RequestMapping(value = "/selectFunc/{loginId}", method = RequestMethod.GET)
    public Map<?, ?> selectFunc(@PathVariable("loginId") String loginId) {
        return groupService.findByLoginId(loginId);
    }
}
