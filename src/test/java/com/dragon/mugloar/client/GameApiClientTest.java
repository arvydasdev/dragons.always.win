package com.dragon.mugloar.client;

import com.dragon.mugloar.client.dto.Dragon;
import com.dragon.mugloar.client.dto.FightStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author gusciarv
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class GameApiClientTest {

    @InjectMocks
    private GameApiClient gameApiClient;
    @Mock
    private Response response;
    @Mock
    private Client client;
    @Mock
    private WebTarget webTarget;
    @Mock
    private Invocation.Builder builder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        PowerMockito.mockStatic(ClientBuilder.class);
        PowerMockito.when(ClientBuilder.newClient()).thenReturn(client);

        when(client.target(Mockito.anyString())).thenReturn(webTarget);
        when(webTarget.request(MediaType.APPLICATION_JSON)).thenReturn(builder);
        when(builder.put(Mockito.any())).thenReturn(response);
        when(webTarget.path(Mockito.anyString())).thenReturn(webTarget);
    }

    @Test
    public void testSolutionApi() throws JsonProcessingException {
        FightStatus fightStatus = new FightStatus();
        when(response.getStatus()).thenReturn(200);
        when(response.readEntity(eq(FightStatus.class))).thenReturn(fightStatus);

        assertEquals(gameApiClient.putSolution("id", new Dragon()), fightStatus);
        assertEquals(gameApiClient.putSolution("id", null), fightStatus);

        ArgumentCaptor<Entity> argument = ArgumentCaptor.forClass(Entity.class);
        verify(builder, times(2)).put(argument.capture());
        assertNotNull(  argument.getAllValues().get(0).getEntity());
        assertNull(argument.getAllValues().get(1).getEntity());
    }

}