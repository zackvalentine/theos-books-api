package com.doestheohavethisbook;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.easymock.TestSubject;

import java.util.List;

@RunWith(EasyMockRunner.class)
public class BookRepositoryTests extends EasyMockSupport {

    @TestSubject
    private final BookRepository testSubject = new BookRepository();

    @Test
    public void whenGetAllBooksCalled_thenReturnsHardCodedTests() {
        Book book1 = new Book("Test Book", "Test Author");
        Book book2 = new Book("Second Book", "Another Author");
        List<Book> expectedBooks = List.of(book1, book2);

        assertThat(testSubject.getAllBooks(), is(expectedBooks));
    }
}