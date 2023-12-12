package br.com.afsj.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.afsj.control.Xadrez;
import br.com.afsj.view.ICavalo;
import br.com.afsj.view.IPeao;
import br.com.afsj.view.IPeca;
import br.com.afsj.view.ITabuleiro;

public class Tabuleiro {

	protected static JFrame TELA;
	
	public static ArrayPecas listaBrancas = new ArrayPecas();
	public static ArrayPecas listaPretas = new ArrayPecas();

	protected static int corJogadorAtual = Xadrez.corBRANCA;
	protected static Peca pecaMarcada = null;
	protected static IPeca iPecaMarcada = null;
	
	protected static ITabuleiro iTabuleiro = new ITabuleiro(); 
	
	//protected static ArrayList<Peao> peoesBrancos = new ArrayList<Peao>();
	protected static Peao[] peoesBrancos = new Peao[8];
	static {
		for (int i = 0; i < peoesBrancos.length; i++) {
			peoesBrancos[i] = new Peao();
		}
	}

	protected static IPeao[] iPeoesBrancos = new IPeao[8];
	static {
		for (int i = 0; i < iPeoesBrancos.length; i++) {
			iPeoesBrancos[i] = new IPeao(peoesBrancos[i]);
		}
	}


	protected static Peao[] peoesPretos = new Peao[8];
	static {
		for (int i = 0; i < peoesPretos.length; i++) {
			peoesPretos[i] = new Peao();
		}
	}

	protected static IPeao[] iPeoesPretos = new IPeao[8];
	static {
		for (int i = 0; i < iPeoesPretos.length; i++) {
			iPeoesPretos[i] = new IPeao(peoesPretos[i]);
		}
	}
	
	protected static Cavalo cavaloPreto1 = new Cavalo();
	protected static ICavalo iCavaloPreto1 = new ICavalo(cavaloPreto1);

	protected static Cavalo cavaloBranco1 = new Cavalo();
	protected static ICavalo iCavaloBranco1 = new ICavalo(cavaloBranco1);
	
	//protected static Peca peca = new Peca();

	public void iniciar(Tradutor t) {

		TELA = new JFrame(t.traduzir("Xadrez"));

		for(int i = 0; i < peoesBrancos.length; i ++){
			peoesBrancos[i].setCor(Xadrez.corBRANCA);
			peoesBrancos[i].mover(i, 6);
			iPeoesBrancos[i].setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
			iPeoesBrancos[i].setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
			iPeoesBrancos[i].mover(i, 6);
			TELA.getContentPane().add(iPeoesBrancos[i].getImagem());
			listaBrancas.add(peoesBrancos[i]);
		}

		for(int i = 0; i < peoesPretos.length; i ++){
			peoesPretos[i].setCor(Xadrez.corPRETA);
			peoesPretos[i].mover(i, 1);
			iPeoesPretos[i].setIconeBranco(new ImageIcon("imagens/Peao-Pretas-Branco.png"));
			iPeoesPretos[i].setIconeMarrom(new ImageIcon("imagens/Peao-Pretas-Marrom.png"));
			iPeoesPretos[i].mover(i, 1);
			TELA.getContentPane().add(iPeoesPretos[i].getImagem());
			listaPretas.add(peoesPretos[i]);
		}

		cavaloBranco1.setCor(Xadrez.corBRANCA);
		cavaloBranco1.mover(1, 7);
		iCavaloBranco1.setIconeBranco(new ImageIcon("imagens/Cavalo-Brancas-Branco.png"));
		iCavaloBranco1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Brancas-Marrom.png"));
		iCavaloBranco1.mover(1, 7);
		TELA.getContentPane().add(iCavaloBranco1.getImagem());
		listaBrancas.add(cavaloBranco1);

		cavaloPreto1.setCor(Xadrez.corPRETA);
		cavaloPreto1.mover(1, 0);
		iCavaloPreto1.setIconeBranco(new ImageIcon("imagens/Cavalo-Pretas-Branco.png"));
		iCavaloPreto1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Pretas-Marrom.png"));
		iCavaloPreto1.mover(1, 0);
		TELA.getContentPane().add(iCavaloPreto1.getImagem());
		listaPretas.add(cavaloPreto1);
		
		TELA.getContentPane().add(iTabuleiro.getImagem());
		TELA.setSize(400, 400);
		TELA.setVisible(true);
		TELA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void avaliarEventoPeca(Peca p, IPeca ip) {
		if (p.getCor() == corJogadorAtual) 
			marcarPeca(p, ip);
		else if (pecaMarcada != null)
			capturarPeca(p, ip);		
	}
	
	public static void avaliarEventoTabuleiro(int x, int y) {
		if ( (pecaMarcada != null) && (x >= 0) && (x <= 7) && (y >=0) && (y <= 7) ) {
			moverPecaMarcada(x, y);
		}
	}

	public static void marcarPeca(Peca p, IPeca ip) {
		if (iPecaMarcada != null)
			iPecaMarcada.desmarcar();
		pecaMarcada = p;
		iPecaMarcada = ip;
		iPecaMarcada.marcar();
	}

	public static void capturarPeca(Peca p, IPeca ip) {
		if (pecaMarcada.capturar(p.getPosX(), p.getPosY())) {
			ip.remover();
			TELA.getContentPane().remove(ip.getImagem());
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(p.getPosX(), p.getPosY());
			p.remover();
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;			
		}
	}
	
	public static void moverPecaMarcada(int x, int y) {
		if (pecaMarcada.mover(x, y)) {
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(x, y);
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;
		}
	}
}
