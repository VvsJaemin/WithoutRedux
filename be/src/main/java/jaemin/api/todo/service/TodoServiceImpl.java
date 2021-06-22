package jaemin.api.todo.service;

import jaemin.api.todo.dto.PageResultDto;
import jaemin.api.todo.dto.TodoDto;
import jaemin.api.todo.entity.Todo;
import jaemin.api.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;


    @Override
    public Long Register(TodoDto todoDto) {

        Todo todo = dtoToEntity(todoDto);
        log.info(todo);

        repository.save(todo);

        return todo.getTno();
    }

    @Override
    public TodoDto get(Long tno) {

        Todo todo = repository.findById(tno).get();

        return entityToDto(todo);
    }

    @Override
    public void modify(TodoDto todoDto) {

        Todo todo = dtoToEntity(todoDto);

        repository.save(todo);

    }

    @Override
    public void remove(Long tno) {
        repository.deleteById(tno);
    }



    @Override
    public PageResultDto<TodoDto, Todo> getPageList(int page) {
        return null;
    }
}
