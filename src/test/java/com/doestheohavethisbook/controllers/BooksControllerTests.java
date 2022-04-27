package com.doestheohavethisbook.controllers;

import com.doestheohavethisbook.Book;
import com.doestheohavethisbook.BookService;
import com.doestheohavethisbook.BookServiceImpl;
import com.doestheohavethisbook.BooksController;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

@RunWith(EasyMockRunner.class)
public class BooksControllerTests extends EasyMockSupport {
    @Mock
    private final BookService bookService = new BookServiceImpl();

    @TestSubject
    private final BooksController controller = new BooksController();

    @Test
    public void whenGetBooksCalled_thenCallsService() {
        Book book1 = new Book("Test Book", UUID.randomUUID());
        Book book2 = new Book("Second Book", UUID.randomUUID());
        List<Book> expectedBooks = List.of(book1, book2);
        expect(bookService.getAllBooks()).andReturn(expectedBooks);
        replayAll();

        ResponseEntity<List<Book>> result = controller.getAllBooks();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedBooks, result.getBody());
        verifyAll();
    }
}
