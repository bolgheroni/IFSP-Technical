package JoaoSupermarket.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 *	Helper class to wrap (embrulhar) a list of Produtos.
 *	This is used to save a list of persons to XML
 */

@XmlRootElement(name = "produtos")
public class ProdutoListaWrapper {
	private List<Produto> produtos;

	@XmlElement(name = "produto")
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
