package condicional.java;

public class SegundaClasseJava {
	/*Variavel Global acessivel a todos*/
	static int maiorIdadeGlobal = 30;
	/*Main é um metodo auto executavel*/
	public static void main(String[] args) {
		
		/*Variavel Local pertence somente a esse método.*/
		int maiorIdade = 18;
		metodo();
	}
	
	public static void metodo() {
		System.out.println("Valor da Variavel Global:" + maiorIdadeGlobal);
	
	}

}
