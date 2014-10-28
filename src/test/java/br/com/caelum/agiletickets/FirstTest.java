package br.com.caelum.agiletickets;

import junit.framework.Assert;

import org.junit.Test;

public class FirstTest {

	@Test
	public void hello() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testName() throws Exception {
		
	}
	
	@Test
	public void garanteQueDoisMaisTresDaCinco() throws Exception {
		int dois = 2;
		int tres = 3;
		int resultado = dois + tres;
		
		Assert.assertEquals(5, resultado);
	}
}
