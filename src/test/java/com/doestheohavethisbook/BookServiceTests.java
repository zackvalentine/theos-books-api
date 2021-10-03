package com.doestheohavethisbook;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.easymock.TestSubject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RunWith(EasyMockRunner.class)
public class BookServiceTests extends EasyMockSupport {
    @Mock
    private BookRepository repository;

    @TestSubject
    private final BookService service = new BookServiceImpl();

    @Test
    public void whenGetAllBooksCalled_thenCallsRepository() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        List<Book> expectedBooks = List.of(book1, book2);
        expect(repository.getAllBooks()).andReturn(expectedBooks);
        replayAll();

        List<Book> result = service.getAllBooks();

        assertThat(result, is(expectedBooks));
        verifyAll();
    }
}