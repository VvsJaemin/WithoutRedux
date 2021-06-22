package jaemin.api.todo.service;

import jaemin.api.todo.dto.PageResultDto;
import jaemin.api.todo.dto.TodoDto;
import jaemin.api.todo.entity.Todo;

public interface TodoService {

    Long Register(TodoDto todoDto);

    TodoDto get(Long tno);

    void modify(TodoDto todoDto);

    void remove(Long tno);

    PageResultDto<TodoDto, Todo> getPageList(int page);

    default Todo dtoToEntity(TodoDto dto){
        Todo todo = Todo.builder()
                .tno(dto.getTno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .regDate(dto.getRegDate())
                .modDate(dto.getModDate())
                .build();

        return todo;
    }

    default TodoDto entityToDto(Todo entity){
        TodoDto dto = TodoDto.builder()
                .tno(entity.getTno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
