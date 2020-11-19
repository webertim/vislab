package de.hska.iwi.vislab.lab2.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		// start the server
		server = Main.startServer();
		
		// create the client
		Client c = ClientBuilder.newClient().register(JacksonJsonProvider.class);

		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testCurrent() {
		FibonacciResponse responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).get(FibonacciResponse.class);
		assertEquals(responseMsg.n, 1);
		assertEquals(responseMsg.fibonacci, 1);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).get(FibonacciResponse.class);
		assertEquals(responseMsg.n, 1);
		assertEquals(responseMsg.fibonacci, 1);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 2);
		assertEquals(responseMsg.fibonacci, 1);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).get(FibonacciResponse.class);
		assertEquals(responseMsg.n, 2);
		assertEquals(responseMsg.fibonacci, 1);
	}
	
	@Test
	public void testNext() {
		FibonacciResponse responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 2);
		assertEquals(responseMsg.fibonacci, 1);
		
		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 3);
		assertEquals(responseMsg.fibonacci, 2);
		
		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 4);
		assertEquals(responseMsg.fibonacci, 3);
	}

	@Test
	public void testRestore() {
		FibonacciResponse responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 2);
		assertEquals(responseMsg.fibonacci, 1);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 3);
		assertEquals(responseMsg.fibonacci, 2);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 4);
		assertEquals(responseMsg.fibonacci, 3);

		target.path("fibonacci").request().delete();

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 2);
		assertEquals(responseMsg.fibonacci, 1);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 3);
		assertEquals(responseMsg.fibonacci, 2);

		responseMsg = target.path("fibonacci").request().accept(MediaType.APPLICATION_JSON).post(null, FibonacciResponse.class);
		assertEquals(responseMsg.n, 4);
		assertEquals(responseMsg.fibonacci, 3);
	}
}