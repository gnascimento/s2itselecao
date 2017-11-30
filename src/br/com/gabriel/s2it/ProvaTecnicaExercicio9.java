package br.com.gabriel.s2it;

public class ProvaTecnicaExercicio9 {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		
		root.setLeft(new BinaryTree(2));
		root.setRight(new BinaryTree(3));
		
		root.getLeft().setLeft(new BinaryTree(4));
		root.getLeft().setRight(new BinaryTree(5));
		
		root.getRight().setLeft(new BinaryTree(6));
		root.getRight().setRight(new BinaryTree(7));
		
		root.getLeft().getLeft().setLeft(new BinaryTree(6));
		root.getLeft().getLeft().setRight(new BinaryTree(7));
		
		root.getLeft().getRight().setLeft(new BinaryTree(8));
		root.getLeft().getRight().setRight(new BinaryTree(9));
		
		root.getRight().getLeft().setLeft(new BinaryTree(10));
		root.getRight().getLeft().setRight(new BinaryTree(11));
		
		root.getRight().getRight().setLeft(new BinaryTree(12));
		root.getRight().getRight().setRight(new BinaryTree(13));
		
		System.out.println(calculoRecursivo(root));
	}
	
	public static int calculoRecursivo(BinaryTree node) {
		int valor = node.getValor();
		if(node.getLeft() != null) {
			valor += calculoRecursivo(node.getLeft());
		}
		if(node.getRight() != null) {
			valor += calculoRecursivo(node.getRight());
		}
		return valor; 
	}
}
