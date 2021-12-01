package business;

import api.TodoService;
import api.TodoServiceStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

public class TodoBusinessImplMockTest {

    @Test
    void testRetrieveTodosRelatedToSpring_usingAMock(){

        TodoService mockTodoService = Mockito.mock(TodoService.class);

        Mockito.when(mockTodoService.retrieveTodos(Mockito.anyString()))
                .thenReturn(Arrays.asList("Spring MVC","Spring Boot","dANCE"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        List<String> filtered =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dump");
        Assertions.assertEquals(2,filtered.size());
    }

    @Test
    void testRetrieveTodosRelatedToSpring_usingBDDMock(){
        // Given
        TodoService mockTodoService = Mockito.mock(TodoService.class);
        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
                .willReturn(Arrays.asList("Spring MVC","Spring Boot","dANCE"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        // When
        List<String> filtered =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dump");

        //Then
        Assertions.assertEquals(2,filtered.size());
    }

    @Test
    void testDeleteTodosRelatedToSpring_usingBDDMock(){
        // Given
        TodoService mockTodoService = Mockito.mock(TodoService.class);
        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
                .willReturn(Arrays.asList("Spring MVC","Spring Boot","Learn to dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        // When
       todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
       todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        //Then
        Mockito.verify(mockTodoService,Mockito.times(2)).deleteTodo("Learn to dance");
        BDDMockito.then(mockTodoService).should(BDDMockito.atLeast(1)).deleteTodo("Learn to dance");
        Mockito.verify(mockTodoService,Mockito.atLeast(1)).deleteTodo("Learn to dance");
        Mockito.verify(mockTodoService,Mockito.never()).deleteTodo("asa");
      //  mockTodoService.deleteTodo("Learn to dance");

    }
    @Test
    void testDeleteTodosRelatedToSpring_usingBDDMock_argumentCapture(){
        //Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Defined


        // Given
        TodoService mockTodoService = Mockito.mock(TodoService.class);
        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
                .willReturn(Arrays.asList("Spring MVC","Spring Boot","Learn to dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        //Then
        Mockito.verify(mockTodoService,Mockito.times(2)).deleteTodo(stringArgumentCaptor.capture());
        Assertions.assertEquals(stringArgumentCaptor.getAllValues().size(), 2);
    }

}
