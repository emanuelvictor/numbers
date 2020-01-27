package br.com.produtec.numbers.domain.service;

import br.com.produtec.numbers.domain.TestApplication;
import br.com.produtec.numbers.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class, Application.class})
public abstract class AbstractIntegrationTests {

}
