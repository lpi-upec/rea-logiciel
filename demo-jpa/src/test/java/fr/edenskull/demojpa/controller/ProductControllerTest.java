package fr.edenskull.demojpa.controller;

import fr.edenskull.demojpa.configuration.DataSourceConfiguration;
import fr.edenskull.demojpa.service.ProductDAOviaJDBC;
import fr.edenskull.demojpa.service.ProductDAOviaSpringData;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@ContextConfiguration(
		initializers = {
				ConfigFileApplicationContextInitializer.class
		}, classes = {
				ProductControllerTest.Context.class
})
public class ProductControllerTest {

	@Autowired
	private ProductController productController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	public void test_get_all() throws Exception {
		mockMvc.perform(get("/products"));
	}

	public void test_post() throws Exception {
		mockMvc.perform(post("/products"));
	}

	@Import({
			ProductController.class,
			ProductDAOviaJDBC.class,
			ProductDAOviaSpringData.class,
			DataSourceConfiguration.class
	})
	public static class Context {

	}

}
