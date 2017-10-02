package com.dragon.mugloar.client;

import com.dragon.mugloar.client.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author gusciarv
 */
public class ResponseHandlerTest {

    @Mock
    private Response response;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testResponse() {
        Game game = new Game();
        when(response.getStatus()).thenReturn(200);
        when(response.readEntity(eq(Game.class))).thenReturn(game);
        ResponseHandler.handleResponse(response, Game.class);
    }

    @Test(expected = RuntimeException.class)
    public void testBadResponse() {
        when(response.getStatus()).thenReturn(400);
        ResponseHandler.handleResponse(response, Game.class);
    }

}