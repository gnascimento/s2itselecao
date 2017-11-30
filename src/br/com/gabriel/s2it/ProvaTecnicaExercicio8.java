package br.com.gabriel.s2it;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
8 - Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
regras:
- O primeiro número de C é o primeiro número de A;
- O segundo número de C é o primeiro número de B;
- O terceiro número de C é o segundo número de A;
- O quarto número de C é o segundo número de B;
Assim sucessivamente…
- Caso os números de A ou B sejam de tamanhos diferentes, completar C com o restante
dos números do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
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
			System.out.println("Número inválido.");
			entrada();
		}
	}
	
	private static void entrada() {
		System.out.println("Digite o número inteiro A: ");
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		System.out.println("Digite o número inteiro B: ");
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
