package jaemin.api.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {


    private Long tno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
