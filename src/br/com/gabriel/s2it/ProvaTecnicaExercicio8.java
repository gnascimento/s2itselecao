package br.com.gabriel.s2it;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
8 - Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
regras:
- O primeiro n�mero de C � o primeiro n�mero de A;
- O segundo n�mero de C � o primeiro n�mero de B;
- O terceiro n�mero de C � o segundo n�mero de A;
- O quarto n�mero de C � o segundo n�mero de B;
Assim sucessivamente�
- Caso os n�meros de A ou B sejam de tamanhos diferentes, completar C com o restante
dos n�meros do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
- Caso C seja maior que 1.000.000, retornar -1
Desenvolva um algoritmo que atenda a todos os requisitos acima
 */
public class ProvaTecnicaExercicio8 {
	static Integer a = null;
	static Integer b = null;
	
	public static void main(String[] args) {
		try {
			entrada();
			System.out.println(calcularC());
		} catch(InputMismatchException ex) {
			System.out.println("N�mero inv�lido.");
			entrada();
		}
	}
	
	private static void entrada() {
		System.out.println("Digite o n�mero inteiro A: ");
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		System.out.println("Digite o n�mero inteiro B: ");
		b = scanner.nextInt();
		scanner.close();
	}
	
	private static Integer calcularC() {
		char[] arrA = a.toString().toCharArray();
		char[] arrB = b.toString().toCharArray();
		int length = arrA.length + arrB.length;
		char[] arrC = new char[length];
		for(int i = 0, j = 0, k = 0; i < length; i++) {
			if(((i + 1) % 2 != 0) && j < arrA.length) {
				arrC[i] = arrA[j];
				j++;
			} else if(((i + 1) % 2 == 0) && k < arrB.length) {
				arrC[i] = arrB[k];
				k++;
			} else if(j < arrA.length) {
				arrC[i] = arrA[j];
				j++;
			} else if(k < arrB.length) {
				arrC[i] = arrB[k];
				k++;
			}
		}
		Integer resultado = Integer.valueOf(new String(arrC));
		System.out.println(resultado);
		if(resultado > Math.pow(10, 6)) {
			return -1;
		} else {
			return resultado;
		}
	}

}
