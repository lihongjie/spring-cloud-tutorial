package com.github.lihongjie.swagger.controller;

import com.github.lihongjie.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags = "UserController相关接口", description = "Rest API")
public class UserController {

    @ApiOperation("新增User")
    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User userRequest) {

        User user = new User();
        user.setId("1");
        user.setName("add");
        return ResponseEntity.ok(user);
    }

    @ApiOperation("通过id查找User")
    @GetMapping("/user/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) {

        User user = new User();
        user.setId("2");
        user.setName("findById");
        return ResponseEntity.ok(user);
    }

    @ApiOperation("更新")
    @PutMapping("/user")
    public ResponseEntity update(@RequestBody User userRequest) {


        User user = new User();
        user.setId("3");
        user.setName("update");
        return ResponseEntity.ok(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    @ApiIgnore
    public ResponseEntity delete(@PathVariable("id") String id) {

        User user = new User();
        user.setId("4");
        user.setName("delete");
        return ResponseEntity.ok(user);
    }
}
