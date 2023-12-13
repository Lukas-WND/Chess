package br.com.afsj.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.afsj.control.Xadrez;
import br.com.afsj.view.ICavalo;
import br.com.afsj.view.IPeao;
import br.com.afsj.view.IPeca;
import br.com.afsj.view.ITabuleiro;
//import br.com.afsj.view.ITorre;

public class Tabuleiro {

	protected static JFrame TELA;
	
	public static ArrayPecas listaBrancas = new ArrayPecas();
	public static ArrayPecas listaPretas = new ArrayPecas();

	protected static int corJogadorAtual = Xadrez.corBRANCA;
	protected static Peca pecaMarcada = null;
	protected static IPeca iPecaMarcada = null;
	
	protected static ITabuleiro iTabuleiro = new ITabuleiro();
	
	protected static Peao peaoBranco1 = new Peao();
	protected static IPeao iPeaoBranco1 = new IPeao(peaoBranco1);
	
	protected static Peao peaoBranco2 = new Peao();
	protected static IPeao iPeaoBranco2 = new IPeao(peaoBranco2);

	protected static Peao peaoPreto1 = new Peao();
	protected static IPeao iPeaoPreto1 = new IPeao(peaoPreto1);
	
	protected static Cavalo cavaloPreto1 = new Cavalo();
	protected static ICavalo iCavaloPreto1 = new ICavalo(cavaloPreto1);

	protected static Cavalo cavaloBranco1 = new Cavalo();
	protected static ICavalo iCavaloBranco1 = new ICavalo(cavaloBranco1);
	
	//protected static Torre torreBranca1 = new Torre();
	//protected static ITorre iTorreBranca1 = new ITorre(torreBranca1);
	
	//protected static Torre torreBranca2 = new Torre();
	//protected static ITorre iTorreBranca2 = new ITorre(torreBranca2);
	
	//protected static Torre torrePreta1 = new Torre();
	//protected static ITorre iTorrePreta1 = new ITorre(torrePreta1);
	
	//protected static Torre torrePreta2 = new Torre();
	//protected static ITorre iTorrePreta2 = new ITorre(torrePreta2);
	
	//protected static Peca peca = new Peca();

	public void iniciar(Tradutor t) {

		TELA = new JFrame(t.traduzir("Xadrez"));

		// Brancas
		peaoBranco1.setCor(Xadrez.corBRANCA);
		peaoBranco1.mover(0, 6);
		iPeaoBranco1.setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
		iPeaoBranco1.setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
		iPeaoBranco1.mover(0, 6);
		TELA.getContentPane().add(iPeaoBranco1.getImagem());
		listaBrancas.add(peaoBranco1);

		peaoBranco2.setCor(Xadrez.corBRANCA);
		peaoBranco2.mover(1, 6);
		iPeaoBranco2.setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
		iPeaoBranco2.setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
		iPeaoBranco2.mover(1, 6);
		TELA.getContentPane().add(iPeaoBranco2.getImagem());
		listaBrancas.add(peaoBranco2);

		cavaloBranco1.setCor(Xadrez.corBRANCA);
		cavaloBranco1.mover(1, 7);
		iCavaloBranco1.setIconeBranco(new ImageIcon("imagens/Cavalo-Brancas-Branco.png"));
		iCavaloBranco1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Brancas-Marrom.png"));
		iCavaloBranco1.mover(1, 7);
		TELA.getContentPane().add(iCavaloBranco1.getImagem());
		listaBrancas.add(cavaloBranco1);
		
		//torreBranca1.setCor(Xadrez.corBRANCA);
		//torreBranca1.mover(0, 7);
		//iTorreBranca1.setIconeBranco(new ImageIcon("imagens/Torre-Brancas-Branco.png"));
		//iTorreBranca1.setIconeMarrom(new ImageIcon("imagens/Torre-Brancas-Marrom.png"));
		//iTorreBranca1.mover(0, 7);
		//TELA.getContentPane().add(iTorreBranca1.getImagem());
		//listaBrancas.add(torreBranca1);
		
		//torreBranca2.setCor(Xadrez.corBRANCA);
		//torreBranca2.mover(7, 7);
		//iTorreBranca2.setIconeBranco(new ImageIcon("imagens/Torre-Brancas-Branco.png"));
		//iTorreBranca2.setIconeMarrom(new ImageIcon("imagens/Torre-Brancas-Marrom.png"));
		//iTorreBranca2.mover(7, 7);
		//TELA.getContentPane().add(iTorreBranca2.getImagem());
		//listaBrancas.add(torreBranca2);		
		
		// Pretas
		peaoPreto1.setCor(Xadrez.corPRETA);
		peaoPreto1.mover(0, 1);
		iPeaoPreto1.setIconeBranco(new ImageIcon("imagens/Peao-Pretas-Branco.png"));
		iPeaoPreto1.setIconeMarrom(new ImageIcon("imagens/Peao-Pretas-Marrom.png"));
		iPeaoPreto1.mover(0, 1);
		TELA.getContentPane().add(iPeaoPreto1.getImagem());
		listaPretas.add(peaoPreto1);

		cavaloPreto1.setCor(Xadrez.corPRETA);
		cavaloPreto1.mover(1, 0);
		iCavaloPreto1.setIconeBranco(new ImageIcon("imagens/Cavalo-Pretas-Branco.png"));
		iCavaloPreto1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Pretas-Marrom.png"));
		iCavaloPreto1.mover(1, 0);
		TELA.getContentPane().add(iCavaloPreto1.getImagem());
		listaPretas.add(cavaloPreto1);
		
		//torrePreta1.setCor(Xadrez.corPRETA);
		//torrePreta1.mover(0, 0);
		//iTorrePreta1.setIconeBranco(new ImageIcon("imagens/Torre-Pretas-Branco.png"));
		//iTorrePreta1.setIconeMarrom(new ImageIcon("imagens/Torre-Pretas-Marrom.png"));
		//iTorrePreta1.mover(0, 0);
		//TELA.getContentPane().add(iTorrePreta1.getImagem());
		//listaBrancas.add(torrePreta1);
				
		//torrePreta2.setCor(Xadrez.corPRETA);
		//torrePreta2.mover(7, 0);
		//iTorrePreta2.setIconeBranco(new ImageIcon("imagens/Torre-Pretas-Branco.png"));
		//iTorrePreta2.setIconeMarrom(new ImageIcon("imagens/Torre-Pretas-Marrom.png"));
		//iTorrePreta2.mover(7, 0);
		//TELA.getContentPane().add(iTorrePreta2.getImagem());
		//listaBrancas.add(torrePreta2);
		
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
	
	public boolean caminhoLivre(char direcao, int indice, int posInicial, int posFinal) {
		
		// Inverte a posição inicial com final se inicial for maior. Isso garante o bom funcionamento do laço de repetição 'for'
		if(posInicial > posFinal) {
			int aux = posInicial;
			posInicial = posFinal;
			posFinal = aux;
		}
		
		// Para cada casa entre a posição inicial e final ao longo da linha, ou coluna, onde o movimento for realizado
		// será verificado se alguma peça do tabuleiro está ocupando aquele lugar, caso esteja, retorna 'false' (caminho não está livre)
		if(direcao == 'v' || direcao == 'V') {	//	Direção do movimento é vertical
			for(int i = posInicial + 1; i < posFinal; i++) {
				
				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if(listaBrancas.get(j).posX == indice && listaBrancas.get(j).posY == i) {
						return false;
					}
				}
				
				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if(listaPretas.get(j).posX == indice && listaPretas.get(j).posY == i) {
						return false;
					}
				}
			}
		}else if(direcao == 'h' || direcao == 'H'){		//	Direção do movimento é horizontal
			for(int i = posInicial + 1; i < posFinal; i++) {
				
				// Verificar peças brancas no caminho
				for (int j = 0; j < listaBrancas.size(); j++) {
					if(listaBrancas.get(j).posY == indice && listaBrancas.get(j).posX == i) {
						return false;
					}
				}
				
				// Verificar peças pretas no caminho
				for (int j = 0; j < listaPretas.size(); j++) {
					if(listaPretas.get(j).posY == indice && listaPretas.get(j).posX == i) {
						return false;
					}
				}
			}
		}else{
			System.out.println("Erro na chamada do método: precisa informar 'v' para moviemnto vertical e 'h' para movimento horizontal.");
		}
		
		return true;	// Caso não tenha dado nenhum conflito com peças no caminho da peça movida, retorna 'true'(caminho está livre)
	}
}
