package com.senchuk.project.model.dto;

//FIXME use model pattern instead of DTO (DRY)

public class UserDto {

    private long id;

    private String name;

    public String getName() {
        return name;
    }

    //FIXME remove unnecessary methods (YAGNI)

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto( String name) {
        this.name = name;
    }
    public UserDto() {

    }
}

