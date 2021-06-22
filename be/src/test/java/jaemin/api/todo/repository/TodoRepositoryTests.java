package jaemin.api.todo.repository;

import jaemin.api.todo.entity.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository repository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,50).forEach(i->{
           Todo todo = Todo.builder().title("Sample..." + i).content("Content..." + i).build();

           repository.save(todo);

           log.info("Todo" +i);
        });
    }

    @Test
    public void testResd(){
        Long tno = 30L;

        Todo todo = repository.findById(tno).get();

        log.info(todo);
    }

    @Test
    public void testModify(){
        Todo todo = repository.findById(30L).get();

        todo.changeTitle("Update 30 title");
       todo.changeContent("ussslsa");

        repository.save(todo);
    }

    @Test
    public void testRemove(){
        repository.deleteById(10L);
    }

    @Test
    public void testaPaging(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("tno").descending());

        Page<Todo> result = repository.findAll(pageable);
        result.get().forEach(todo->log.info(todo));
    }

}
