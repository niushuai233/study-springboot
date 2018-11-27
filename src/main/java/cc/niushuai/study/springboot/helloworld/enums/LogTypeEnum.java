package cc.niushuai.study.springboot.helloworld.enums;

import lombok.Data;

public enum LogTypeEnum {

    ADD(0,"添加操作"),

    DEL(1,"删除操作"),

    UPDATE(2,"更新操作"),

    SELECT(3,"查询操作"),

    OTHER(4,"其他操作");

    private Integer type;
    private String value;

    LogTypeEnum(Integer type, String value){
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
