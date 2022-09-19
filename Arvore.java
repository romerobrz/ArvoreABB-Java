public class Arvore{
	    private Elemento ele;
	    private Arvore   dir;
	    private Arvore   esq;
	    public Arvore(){
	        this.ele = null;
	        this.esq = null;
	        this.dir = null;
	    }
	    public Arvore(Elemento elem){
	        this.ele = elem;
	        this.dir = null;
	        this.esq = null;
	        //System.out.println("Criei a arvore com o elemento "+elem.getValor());
	    }
	    // metodos de controle;
	    public boolean isEmpty(){
	        return (this.ele == null);
	    }
	    public void imprimirPreOrdem(){
	        if (!isEmpty()){
	            System.out.print(this.ele.getValor() + "  ");
	            if (this.esq != null){
	                this.esq.imprimirPreOrdem();
	            }
	            if (this.dir != null){
	                this.dir.imprimirPreOrdem();
	            }
	        }
	    }
	    public void imprimirInOrdem(){
	        if (!isEmpty()){
	            if (this.esq != null){
	                this.esq.imprimirInOrdem();
	            }
	            System.out.print(this.ele.getValor() + "  ");
	            if (this.dir != null){
	                this.dir.imprimirInOrdem();
	            }
	        }
	    }
	    public void imprimirPosOrdem(){
	        if (!isEmpty()){
	            if (this.dir != null){
	                this.dir.imprimirPosOrdem();
	            }
	            if (this.esq != null){
	                this.esq.imprimirPosOrdem();
	            }
	            System.out.print(this.ele.getValor() + "  ");
	        }
	    }
	    // remocao do no da arvore
	    public Arvore remover(Elemento elem){
	        // primeiro caso - achei o elemento
	        if (this.ele.getValor() == elem.getValor()){
	            // caso mais simples - o elemento est� em um n� folha
	            if (this.dir == null && this.esq == null){
	                return null;
	            }
	            else{
	                // caso 2 - eu tenho filhos � esquerda, por�m n�o tenho � direita
	                if (this.esq != null && this.dir == null){
	                    return this.esq;    
	                }
	                // caso 3 - eu tenho filhos � direita, por�m n�o tenho � esquerda
	                else if (this.dir != null && this.esq == null){
	                    return this.dir;
	                }
	                // caso 4 - tenho filhos dos dois lados (esquerda e direita)
	                else{
	                    // vamos adotar a estrat�gia do maior dentre os menores?
	                    Arvore aux = this.esq;
	                    while (aux.dir != null){ // enquanto houver filhos � direita
	                        aux = aux.dir;
	                    }
	                    // troco os elementos da �rvore
	                    this.ele = aux.getElemento();  // o n� atual recebe o elemento do aux
	                                                   // o maior dentre os menores
	                    aux.setElemento(elem);         // insiro no n� folha (l� embaix�o) o elmento a ser eliminado
	                    this.esq = esq.remover(elem);
	                }
	            }
	        }
	        else if (elem.getValor() < this.ele.getValor()){
	            // delegar a responsabilidade � sub-arvore da esquerda
	            this.esq = this.esq.remover(elem);
	        }
	        else if (elem.getValor() > this.ele.getValor()){
	            // delegar a responsabilidade � sub-arvore da direita
	            this.dir = this.dir.remover(elem);
	        }
	        return this;
	    }
	    // isercao do no na arvore
	    public void inserir(Elemento novo){
	        if (isEmpty()){
	            this.ele = novo;
	        }
	        else{
	            Arvore novaArvore = new Arvore(novo);
	            if (novo.getValor() < this.ele.getValor()){ // vou inserir na descendencia esquerda
	                if (this.esq == null){ // sou um n� folha?
	                    this.esq = novaArvore;
	                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " � esquerda de "+this.ele.getValor());
	                }
	                else{
	                    this.esq.inserir(novo); // repassei a resposnabilidade pra sub-�rvore esquerda
	                }
	            }
	            else if (novo.getValor() > this.ele.getValor()){ // vou inserir na descendenia direita
	                if (this.dir == null){
	                    this.dir = novaArvore;
	                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " � direita de "+this.ele.getValor());
	                }
	                else{
	                    this.dir.inserir(novo); // repassei a resposnabilidade pra sub-�rvore direita
	                }
	            }
	        }
	    }
	    public boolean busca(int valor){
	        if (isEmpty()){
	            return false;
	        }
	        if (this.ele.getValor() == valor){
	            return true;
	        }
	        else{
	            if (valor < this.ele.getValor() ){
	                if (this.esq == null){
	                    return false;
	                }
	                else{
	                    return this.esq.busca(valor); // repassei a responsabilidade para a subarvore esquerda
	                }
	            }
	            else if (valor > this.ele.getValor()){
	                if (this.dir == null){
	                    return false;
	                }
	                else{
	                    return this.dir.busca(valor);
	                }
	            }
	            return false;
	        }
	    }
	    // gets e sets
	    public void setElemento(Elemento ele){
	        this.ele = ele;
	    }
	    public void setDir(Arvore dir){
	        this.dir = dir;
	    }
	    public void setEsq(Arvore esq){
	        this.esq = esq;
	    }
	    public Arvore getDireita(){
	        return this.dir;
	    }
	    public Arvore getEsquerda(){
	        return this.esq;
	    }
	    public Elemento getElemento(){
	        return this.ele;
	    }
	}
