import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Elemento elem = new Elemento(0); // elemento criado para receber os valores a serem removidos

/*      Arvore arvore = new Arvore(new Elemento(20));
        arvore.inserir(new Elemento(10));
        arvore.inserir(new Elemento(5));
        arvore.inserir(new Elemento(2));
        arvore.inserir(new Elemento(8));
        arvore.inserir(new Elemento(15));
        arvore.inserir(new Elemento(12));
        arvore.inserir(new Elemento(18));
        arvore.inserir(new Elemento(30));
        arvore.inserir(new Elemento(25));
        arvore.inserir(new Elemento(22));
        arvore.inserir(new Elemento(28));
        arvore.inserir(new Elemento(35));
        arvore.inserir(new Elemento(32));
        arvore.inserir(new Elemento(38));
*/ 
        
        try (Scanner teclado = new Scanner(System.in)) {
	        System.out.println("Entre com OITO valores para serem insiridos na arvore.");
	        System.out.println("");
	
	        Arvore arvore = new Arvore(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));
			arvore.inserir(new Elemento(teclado.nextInt()));

			System.out.println("Arvore inicial....");
	        arvore.imprimirInOrdem();
	        System.out.println("");
       
	        System.out.println("Entre com o valor a ser removido.");
	        System.out.println("");

	        elem.setValor(teclado.nextInt());
            
	        arvore = arvore.remover(elem);
        
	        System.out.println("Nova arvore....");
	        arvore.imprimirInOrdem();
	        System.out.println("");
        
	        System.out.println("Entre com o valor a ser removido.");
	        System.out.println("");
	        
	        elem.setValor(teclado.nextInt());

	        arvore = arvore.remover(elem);

	        System.out.println("Nova arvore....");
	        arvore.imprimirInOrdem();
	        System.out.println("");
	    
	        System.out.println("Entre com o valor a ser procurado.");
	        System.out.println("");
	        
	        elem.setValor(teclado.nextInt());
	        
	        System.out.println("O valor "+elem.getValor()+" procurado "+arvore.busca(elem.getValor())+" na arvore"); 
        }
	}
}