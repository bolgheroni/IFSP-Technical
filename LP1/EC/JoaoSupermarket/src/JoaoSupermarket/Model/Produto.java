package JoaoSupermarket.Model;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import JoaoSupermarket.Util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
	private StringProperty Nome;
	private StringProperty Categoria;
	private ObjectProperty<LocalDate> DataDeValidade;
	private IntegerProperty Estoque;
	private IntegerProperty EstoqueMinimo;

	// Default constructor
	public Produto() {
		this("", 0, 0, LocalDate.now().plusDays(1), "");
	}
	public Produto(String Nome, int Estoque, int EstoqueMinimo, LocalDate DataDeValidade, String Categoria) {
		this.Nome = new SimpleStringProperty(Nome);
		this.Estoque = new SimpleIntegerProperty(Estoque);
		this.EstoqueMinimo = new SimpleIntegerProperty(EstoqueMinimo);
		this.DataDeValidade = new SimpleObjectProperty<LocalDate>(DataDeValidade.plusDays(1));
		this.Categoria = new SimpleStringProperty(Categoria);
	}
	// Getters and Setters
	public StringProperty NomeProperty() {
		return Nome;
	}
	public String getNome() {
		return Nome.get();
	}
	public void setNome(String nome) {
		Nome.set(nome);
	}

	public StringProperty CategoriaProperty() {
		return Categoria;
	}
	public String getCategoria() {
		return Categoria.get();
	}
	public void setCategoria(String categoria) {
		Categoria.set(categoria);
	}

	public ObjectProperty<LocalDate> DataDeValidadeProperty() {
		return DataDeValidade;
	}
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDataDeValidade() {
		return DataDeValidade.get();
	}
	public void setDataDeValidade(LocalDate dataDeValidade) {
		DataDeValidade.set(dataDeValidade);
	}

	public IntegerProperty EstoqueProperty() {
		return Estoque;
	}
	public int getEstoque() {
		return Estoque.get();
	}
	public void setEstoque(int estoque) {
		Estoque.set(estoque);;
	}

	public IntegerProperty EstoqueMinimoProperty() {
		return EstoqueMinimo;
	}
	public int getEstoqueMinimo() {
		return EstoqueMinimo.get();
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		EstoqueMinimo.set(estoqueMinimo);
	}
}
