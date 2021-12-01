package business;

import api.TodoService;
import api.TodoServiceStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoBusinessImplStubTest {
    @Test
    void testRetrieveTodosRelatedToSpring_usingAStub(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> filtered =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dump");
        Assertions.assertEquals(2,filtered.size());
    }
}
