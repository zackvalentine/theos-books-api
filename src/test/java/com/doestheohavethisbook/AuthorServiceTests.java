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
public class AuthorServiceTests extends EasyMockSupport {
    @Mock
    private AuthorRepository repository;

    @TestSubject
    private final AuthorService service = new AuthorServiceImpl();

    @Test
    public void whenGetAllAuthorsCalled_thenCallsRepository() {
        Author author1 = new Author("Bob", "Martin", UUID.randomUUID());
        Author author2 = new Author("Martin", "Fowler", UUID.randomUUID());
        List<Author> expectedAuthors = List.of(author1, author2);
        expect(repository.findAll()).andReturn(expectedAuthors);
        replayAll();

        List<Author> result = service.getAllAuthors();

        assertEquals(expectedAuthors, result);
        verifyAll();
    }
}
