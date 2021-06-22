package jaemin.api.todo.controller;

import jaemin.api.todo.dto.PageResultDto;
import jaemin.api.todo.dto.TodoDto;
import jaemin.api.todo.entity.Todo;
import jaemin.api.todo.service.TodoService;
import jaemin.api.todo.service.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoServiceImpl service;

    @GetMapping("/now")
    public ResponseEntity<LocalDateTime> getNow() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(LocalDateTime.now(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody TodoDto todoDto) {
        Long tno = service.Register(todoDto);

        return new ResponseEntity<>(tno, HttpStatus.OK);
    }

    @GetMapping("/{tno}")
    public ResponseEntity<TodoDto> read(@PathVariable("tno") Long tno) {
        TodoDto todoDto = service.get(tno);

        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<String> remove(@RequestBody TodoDto todoDto) {
        service.remove(todoDto.getTno());

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/{tno}")
    public ResponseEntity<String> modify(@PathVariable("tno") Long tno, @RequestBody TodoDto todoDto) {
        service.modify(todoDto);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<PageResultDto<TodoDto, Todo>> getList(int page) {
        return new ResponseEntity<>(service.getPageList(page), HttpStatus.OK);
    }

}

