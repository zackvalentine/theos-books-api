package com.doestheohavethisbook;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.easymock.TestSubject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RunWith(EasyMockRunner.class)
public class BookServiceTests extends EasyMockSupport {

    @TestSubject
    private BookService service = new BookServiceImpl();

    @Test
    public void whenGetAllBooksCalled_thenReturnsHardCodedBooks() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        List<Book> expectedBooks = List.of(book1, book2);
        List<Book> result = service.getAllBooks();

        assertThat(result, is(expectedBooks));
    }
}