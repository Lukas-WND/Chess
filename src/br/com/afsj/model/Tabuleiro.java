package br.com.afsj.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.afsj.control.Xadrez;
import br.com.afsj.view.ICavalo;
import br.com.afsj.view.IDama;
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

	// protected static ArrayList<Peao> peoesBrancos = new ArrayList<Peao>();
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

	protected static Dama damaBranca = new Dama();
	protected static IDama idamaBranca = new IDama(damaBranca);

	protected static Dama damaPreta = new Dama();
	protected static IDama idamaPreta = new IDama(damaPreta);

	// protected static Peca peca = new Peca();

	public void iniciar(Tradutor t) {

		TELA = new JFrame(t.traduzir("Xadrez"));

		for (int i = 0; i < peoesBrancos.length; i++) {
			peoesBrancos[i].setCor(Xadrez.corBRANCA);
			peoesBrancos[i].mover(i, 2);
			iPeoesBrancos[i].setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
			iPeoesBrancos[i].setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
			iPeoesBrancos[i].mover(i, 2);
			TELA.getContentPane().add(iPeoesBrancos[i].getImagem());
			listaBrancas.add(peoesBrancos[i]);
		}

		for (int i = 0; i < peoesPretos.length; i++) {
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

		damaBranca.setCor(Xadrez.corBRANCA);
		damaBranca.mover(3, 7);
		idamaBranca.setIconeBranco(new ImageIcon("imagens/Rainha-Brancas-Branco.png"));
		idamaBranca.setIconeMarrom(new ImageIcon("imagens/Rainha-Brancas-Marrom.png"));
		idamaBranca.mover(3, 7);
		TELA.getContentPane().add(idamaBranca.getImagem());
		listaBrancas.add(damaBranca);

		damaPreta.setCor(Xadrez.corPRETA);
		damaPreta.mover(3, 0);
		idamaPreta.setIconeBranco(new ImageIcon("imagens/Rainha-Pretas-Branco.png"));
		idamaPreta.setIconeMarrom(new ImageIcon("imagens/Rainha-Pretas-Marrom.png"));
		idamaPreta.mover(3, 0);
		TELA.getContentPane().add(idamaPreta.getImagem());
		listaPretas.add(damaPreta);

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
		if ((pecaMarcada != null) && (x >= 0) && (x <= 7) && (y >= 0) && (y <= 7)) {
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

			if (pecaMarcada instanceof Peao) {
				if (pecaMarcada.getCor() == Xadrez.corBRANCA && pecaMarcada.getPosY() == 0) {
					turnIntoQueen((Peao) pecaMarcada, (IPeao) iPecaMarcada);
				} else if (pecaMarcada.getCor() == Xadrez.corPRETA && pecaMarcada.getPosY() == 7) {
					turnIntoQueen((Peao) pecaMarcada, (IPeao) iPecaMarcada);
				}
			}

			pecaMarcada = null;
			iPecaMarcada = null;

			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;
		}

	}

	public static boolean verificaReta(char direcao, int indice, int posInicial, int posFinal) {

		// Inverte a posição inicial com final se inicial for maior. Isso garante o bom
		// funcionamento do laço de repetição 'for'
		if (posInicial > posFinal) {
			int aux = posInicial;
			posInicial = posFinal;
			posFinal = aux;
		}

		// Para cada casa entre a posição inicial e final ao longo da linha, ou coluna,
		// onde o movimento for realizado
		// será verificado se alguma peça do tabuleiro está ocupando aquele lugar, caso
		// esteja, retorna 'false' (caminho não está livre)
		if (direcao == 'v' || direcao == 'V') { // Direção do movimento é vertical
			for (int i = posInicial + 1; i < posFinal; i++) {

				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if (listaBrancas.get(j).posX == indice && listaBrancas.get(j).posY == i) {
						return false;
					}
				}

				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if (listaPretas.get(j).posX == indice && listaPretas.get(j).posY == i) {
						return false;
					}
				}
			}
		} else if (direcao == 'h' || direcao == 'H') { // Direção do movimento é horizontal
			for (int i = posInicial + 1; i < posFinal; i++) {

				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if (listaBrancas.get(j).posY == indice && listaBrancas.get(j).posX == i) {
						return false;
					}
				}

				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if (listaPretas.get(j).posY == indice && listaPretas.get(j).posX == i) {
						return false;
					}
				}
			}
		} else {
			System.out.println(
					"Erro na chamada do método: precisa informar 'v' para moviemnto vertical e 'h' para movimento horizontal.");
		}

		return true; // Caso não tenha dado nenhum conflito com peças no caminho da peça movida,
						// retorna 'true'(caminho está livre)
	}

	public static boolean verificaDiagonal(int x, int posX, int y, int posY) {
		if (y > posY) { // Descendo
			if (x > posX) {// direita

				for (int mudaX = posX; mudaX < x; mudaX++) {
					for (int i = 0; i < listaPretas.size(); i++) {
						if (listaPretas.get(i).posY == i && listaPretas.get(i).posX == i) {
							System.out.printf("Preta diagonal subindo direita");
							return false;
						}
					}
				}

				for (int i = 0; i < listaBrancas.size(); i++) {
					if (listaBrancas.get(i).posY == i && listaBrancas.get(i).posX == i) {
						System.out.printf("Preta diagonal subindo direita");
						return false;
					}
				}
			} else { // esquerda

			}

		}
		if (y < posY) { // Subindo
			if (x > posX) {// direita

			} else { // esquerda

			}
		}

		return true;
	}

	public static boolean caminhoLivre(char direcao, int indice, int posInicial, int posFinal) {

		// Inverte a posição inicial com final se inicial for maior. Isso garante o bom
		// funcionamento do laço de repetição 'for'
		if (posInicial > posFinal) {
			int aux = posInicial;
			posInicial = posFinal;
			posFinal = aux;
		}

		// Para cada casa entre a posição inicial e final ao longo da linha, ou coluna,
		// onde o movimento for realizado
		// será verificado se alguma peça do tabuleiro está ocupando aquele lugar, caso
		// esteja, retorna 'false' (caminho não está livre)
		if (direcao == 'v' || direcao == 'V') { // Direção do movimento é vertical
			for (int i = posInicial + 1; i < posFinal; i++) {

				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if (listaBrancas.get(j).posX == indice && listaBrancas.get(j).posY == i) {
						return false;
					}
				}

				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if (listaPretas.get(j).posX == indice && listaPretas.get(j).posY == i) {
						return false;
					}
				}
			}
		} else if (direcao == 'h' || direcao == 'H') { // Direção do movimento é horizontal
			for (int i = posInicial + 1; i < posFinal; i++) {

				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if (listaBrancas.get(j).posY == indice && listaBrancas.get(j).posX == i) {
						return false;
					}
				}

				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if (listaPretas.get(j).posY == indice && listaPretas.get(j).posX == i) {
						return false;
					}
				}
			}
		} else {
			System.out.println(
					"Erro na chamada do método: precisa informar 'v' para moviemnto vertical e 'h' para movimento horizontal.");
		}

		return true; // Caso não tenha dado nenhum conflito com peças no caminho da peça movida,
						// retorna 'true'(caminho está livre)
	}

	public static void turnIntoQueen(Peao peao, IPeao iPeao) {
		Dama novaRainha = new Dama();
		IDama iNovaRainha = new IDama(novaRainha);

		novaRainha.setCor(peao.getCor());
		novaRainha.setMovimento(peao.getMovimento());

		iPeao.remover();
		TELA.getContentPane().remove(iPeao.getImagem());
		iPeao.desmarcar();
		iPeao.mover(peao.getPosX(), peao.getPosY());

		if (novaRainha.getCor() == Xadrez.corBRANCA) {

			novaRainha.mover(peao.getPosX(), peao.getPosY());
			iNovaRainha.setIconeBranco(new ImageIcon("imagens/Rainha-Brancas-Branco.png"));
			iNovaRainha.setIconeMarrom(new ImageIcon("imagens/Rainha-Brancas-Marrom.png"));
			iNovaRainha.mover(novaRainha.getPosX(), novaRainha.getPosY());
			TELA.getContentPane().add(iNovaRainha.getImagem());
			listaBrancas.add(novaRainha);

			System.out.println(novaRainha.getPosX() + " " + novaRainha.getPosY());

		}

		if (novaRainha.getCor() == Xadrez.corPRETA) {

			novaRainha.mover(peao.getPosX(), peao.getPosY());
			iNovaRainha.setIconeBranco(new ImageIcon("imagens/Rainha-Pretas-Branco.png"));
			iNovaRainha.setIconeMarrom(new ImageIcon("imagens/Rainha-Pretas-Marrom.png"));
			iNovaRainha.mover(novaRainha.getPosX(), novaRainha.getPosY());
			TELA.getContentPane().add(iNovaRainha.getImagem());
			listaPretas.add(novaRainha);

			System.out.println(novaRainha.getPosX() + " " + novaRainha.getPosY());
		}

		peao.remover();
	}
}
