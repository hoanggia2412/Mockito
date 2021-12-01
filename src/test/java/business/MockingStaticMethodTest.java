package business;

import api.Dependency;
import helper.UtilityClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockingStaticMethodTest {
   @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;
   // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);

    //Declare Argument Captor
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void testRetrieveTodosRelatedToSpring_usingAMock() {
        Mockito.when(dependency.retrieveAllStats())
                .thenReturn(Arrays.asList(1, 2, 3));
        try (MockedStatic<UtilityClass> utility = Mockito.mockStatic(UtilityClass.class)) {
            utility.when(() -> UtilityClass.staticMethod(6)).thenReturn(6);
            int result = systemUnderTest.methodCallingAStaticMethod();
            Assertions.assertEquals(6, result);
        }
    }
        @Test
        void do_Nothing(){
            Mockito.when(dependency.retrieveAllStats())
                    .thenReturn(Arrays.asList(1,2,3));
            try(MockedStatic<UtilityClass> utility = Mockito.mockStatic(UtilityClass.class)){
                utility.when(()-> UtilityClass.staticMethod(6)).thenReturn(6);
                int result = systemUnderTest.methodCallingAStaticMethod();
                Assertions.assertEquals(6,result);
            }
    }

//    @Test
//    void testRetrieveTodosRelatedToSpring_usingBDDMock(){
//        // Given
//        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
//                .willReturn(Arrays.asList("Spring MVC","Spring Boot","dANCE"));
//
//        // When
//        List<String> filtered =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dump");
//
//        //Then
//        Assertions.assertEquals(2,filtered.size());
//    }
//
//    @Test
//    void testDeleteTodosRelatedToSpring_usingBDDMock(){
//        // Given
//
//        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
//                .willReturn(Arrays.asList("Spring MVC","Spring Boot","Learn to dance"));
//
//        // When
//        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
//        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
//        //Then
//        Mockito.verify(mockTodoService,Mockito.times(2)).deleteTodo("Learn to dance");
//        BDDMockito.then(mockTodoService).should(BDDMockito.atLeast(1)).deleteTodo("Learn to dance");
//        Mockito.verify(mockTodoService,Mockito.atLeast(1)).deleteTodo("Learn to dance");
//        Mockito.verify(mockTodoService,Mockito.never()).deleteTodo("asa");
//        //  mockTodoService.deleteTodo("Learn to dance");
//
//    }
//    @Test
//    void testDeleteTodosRelatedToSpring_usingBDDMock_argumentCapture(){
//        // Given
//        BDDMockito.given(mockTodoService.retrieveTodos(Mockito.anyString()))
//                .willReturn(Arrays.asList("Spring MVC","Spring Boot","Learn to dance"));
//
//        // When
//        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
//        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
//        //Then
//        Mockito.verify(mockTodoService,Mockito.times(2)).deleteTodo(stringArgumentCaptor.capture());
//        Assertions.assertEquals(stringArgumentCaptor.getAllValues().size(), 2);
//    }

}
