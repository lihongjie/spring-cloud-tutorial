package com.github.lihongjie.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("User实体")
public class User {


    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("年龄")
    private Integer age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
