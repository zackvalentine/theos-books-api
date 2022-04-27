package com.doestheohavethisbook;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

@RunWith(EasyMockRunner.class)
public class BookServiceTests extends EasyMockSupport {
    @Mock
    private BookRepository repository;

    @TestSubject
    private final BookService service = new BookServiceImpl();

    @Test
    public void whenGetAllBooksCalled_thenCallsRepository() {
        Author author = new Author("Venkat", "Subramaniam", UUID.randomUUID());
        Book book1 = new Book("Test Book", author);
        Book book2 = new Book("Second Book", author);
        List<Book> expectedBooks = List.of(book1, book2);
        expect(repository.findAll()).andReturn(expectedBooks);
        replayAll();

        List<Book> result = service.getAllBooks();

        assertEquals(expectedBooks, result);
        verifyAll();
    }
}
