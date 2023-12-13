package br.com.afsj.model;

import br.com.afsj.control.Xadrez;

public class Dama extends Peca {

	@Override
	public boolean movimentoOK(int x, int y) {
		// TODO Auto-generated method

		if (posX == -1 && posY == -1) {
			return true;
		}

		if (cor == Xadrez.corBRANCA || cor == Xadrez.corPRETA) {
			if (x == posX && y != posY) {
				if (Tabuleiro.verificaReta('v', x, posY, y))
					return true;
			}
			if (y == posY && x != posX) {
				if (Tabuleiro.verificaReta('h', y, posX, x)) {
					return true;
				}
			}

			int variaX = x - posX;
			int variaY = y - posY;
			if ((double) Math.abs(variaX) == (Math.abs((double) (variaY)))) {
				// diagonal
				if (Tabuleiro.verificaDiagonal(x, posX, y, posY)) {
					if (variaX == variaY) {
						int pX, pY;

						if (x > posX) {
							pX = 1;
						} else {
							pX = -1;
						}
						if (y > posY) {
							pY = 1;
						} else {
							pY = -1;
						}

						int i = posX + pX;
						int j = posY + pY;

						// Verificando se existe alguma peça no caminho
						while (i != x && j != y) {
							Peca pBranca = Tabuleiro.listaBrancas.pecaPosicao(i, j);
							Peca pPreta = Tabuleiro.listaPretas.pecaPosicao(i, j);
							if (pBranca != null || pPreta != null) {
								return false;
							}
							i += pX;
							j += pY;
						}
						return true;
					}

				}
				return true;
			}

		}

		return false;
	}
}
