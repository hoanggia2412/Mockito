package helper;

import api.TodoService;
import business.TodoBusinessImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMockitoTest {
    @InjectMocks
    TodoService service;
    TodoBusinessImpl toDoServiceImp = new TodoBusinessImpl(service);

    @Test
    void test(){
        Mockito.when(toDoServiceImp.retrieveTodosRelatedToSpring(Mockito.anyString()))
                .thenReturn(Arrays.asList(new String[]{"a", "b"}));
        Mockito.when(service.retrieveTodos(Mockito.anyString()))
                .thenReturn(Arrays.asList(new String[]{"a", "b"}));
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> list2 = toDoServiceImp.retrieveTodosRelatedToSpring("gia");
        for (String string : list2){
            System.out.println(string);
        }
    }
}
