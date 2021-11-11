package acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;
	private Leilao leilao;
	private ArrayList<Lance> lista;

	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("proposto")
	public void quando_proposto() {
		leilao.propoe(lance);
	}

	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().iterator().next().getValor());
	}

	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lance);
	}

	@Quando("forem propostos varios lances")
	public void forem_propostos_varios_lances() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		assertEquals(this.lista.size(), leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
}
