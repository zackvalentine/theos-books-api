package com.doestheohavethisbook.controllers;

import com.doestheohavethisbook.*;
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
public class AuthorsControllerTests extends EasyMockSupport {
    @Mock
    private final AuthorService authorService = new AuthorServiceImpl();

    @TestSubject
    private final AuthorsController controller = new AuthorsController();

    @Test
    public void whenGetBooksCalled_thenCallsService() {
        Author author1 = new Author("Bob", "Martin", UUID.randomUUID());
        Author author2 = new Author("Martin", "Fowler", UUID.randomUUID());
        List<Author> expectedAuthors = List.of(author1, author2);
        expect(authorService.getAllAuthors()).andReturn(expectedAuthors);
        replayAll();

        ResponseEntity<List<Author>> result = controller.getAllAuthors();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedAuthors, result.getBody());
        verifyAll();
    }
}
