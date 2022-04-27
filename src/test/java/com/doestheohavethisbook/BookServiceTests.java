package com.doestheohavethisbook;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.easymock.TestSubject;

import java.util.List;
import java.util.UUID;

@RunWith(EasyMockRunner.class)
public class BookServiceTests extends EasyMockSupport {
    @Mock
    private BookRepository repository;

    @TestSubject
    private final BookService service = new BookServiceImpl();

    @Test
    public void whenGetAllBooksCalled_thenCallsRepository() {
        Book book1 = new Book("Test Book", UUID.randomUUID());
        Book book2 = new Book("Second Book", UUID.randomUUID());
        List<Book> expectedBooks = List.of(book1, book2);
        expect(repository.findAll()).andReturn(expectedBooks);
        replayAll();

        List<Book> result = service.getAllBooks();

        assertEquals(expectedBooks, result);
        verifyAll();
    }
}
