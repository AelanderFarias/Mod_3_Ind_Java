package modelo;

import java.util.Date;

public class viagem {
	
	private int id_viagem;
	private String destino;
	private Date data_partida;
	private Date data_volta;
	private String local_partida;
	private int valor_viagem;
	private String tipo_transporte;
	
	
	public viagem() {
		super();
	}


	public viagem(int id_viagem, String destino, Date data_partida, Date data_volta, String local_partida,
			int valor_viagem, String tipo_transporte) {
		super();
		this.id_viagem = id_viagem;
		this.destino = destino;
		this.data_partida = data_partida;
		this.data_volta = data_volta;
		this.local_partida = local_partida;
		this.valor_viagem = valor_viagem;
		this.tipo_transporte = tipo_transporte;
	}


	public int getId_viagem() {
		return id_viagem;
	}


	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Date getData_partida() {
		return data_partida;
	}


	public void setData_partida(Date data_partida) {
		this.data_partida = data_partida;
	}


	public Date getData_volta() {
		return data_volta;
	}


	public void setData_volta(Date data_volta) {
		this.data_volta = data_volta;
	}


	public String getLocal_partida() {
		return local_partida;
	}


	public void setLocal_partida(String local_partida) {
		this.local_partida = local_partida;
	}


	public int getValor_viagem() {
		return valor_viagem;
	}


	public void setValor_viagem(int valor_viagem) {
		this.valor_viagem = valor_viagem;
	}


	public String getTipo_transporte() {
		return tipo_transporte;
	}


	public void setTipo_transporte(String tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}
	
	
	
}
