package br.com.lotofacilfree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class LotofacilfreeApplicationTest {

    @LocalServerPort
    private int port;

    @Test
    public void testFreeMarkerTemplate() throws Exception {
        final ResponseEntity<String> pageReponseEntity =
                new TestRestTemplate().getForEntity("http://localhost:" + this.port, String.class);

        assertThat(pageReponseEntity.getStatusCode(), is(HttpStatus.OK));

        assertThat(pageReponseEntity.getBody(), containsString("<title>LotoFácilFree - Analise, simule e monte seus jogos da Lotofácil.</title>"));

        assertThat(pageReponseEntity.getBody(), containsString("/css/bootstrap.min.css"));
        assertThat(pageReponseEntity.getBody(), containsString("/css/bootstrap-theme.min.css"));
        assertThat(pageReponseEntity.getBody(), containsString("/css/custom/lotofacilfree.css"));

        assertThat(pageReponseEntity.getBody(), containsString("/js/jquery-2.1.1.js"));
        assertThat(pageReponseEntity.getBody(), containsString("/js/bootstrap.min.js"));
        assertThat(pageReponseEntity.getBody(), containsString("/js/custom/lotofacilfree.js"));
    }

}