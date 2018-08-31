package cn.thoughtworks.school.growthnoteapi.controller.response;

import cn.thoughtworks.school.growthnoteapi.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiariesResponse {

    private Long total;
    private Integer page;
    private Integer pageSize;
    private List<Diary> data;
}
