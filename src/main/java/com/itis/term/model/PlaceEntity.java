package com.itis.term.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaceEntity {
    private Integer id;
    private Boolean vipStatus;
    private Boolean status;
    private String time_in;
    private String time_out;
    private Integer current_user;
    private String current_username;

    public PlaceEntity(Integer id, Boolean vipStatus, Boolean status, String time_in, String time_out, Integer current_user) {
        this.id = id;
        this.vipStatus = vipStatus;
        this.status = status;
        this.time_in = time_in;
        this.time_out = time_out;
        this.current_user = current_user;
    }
}

