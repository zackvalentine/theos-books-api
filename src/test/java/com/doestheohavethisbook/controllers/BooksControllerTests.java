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

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(EasyMockRunner.class)
public class BooksControllerTests extends EasyMockSupport {
    @Mock
    private final BookService bookService = new BookServiceImpl();

    @TestSubject
    private final BooksController controller = new BooksController();

    @Test
    public void whenGetBooksCalled_thenCallsService() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        List<Book> expectedBooks = List.of(book1, book2);
        expect(bookService.getAllBooks()).andReturn(expectedBooks);
        replayAll();

        ResponseEntity<List<Book>> result = controller.getAllBooks();

        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        assertThat(result.getBody(), is(expectedBooks));
        verifyAll();
    }
}
