package controller;
import java.util.concurrent.Semaphore;
public class Bilheteria extends Thread{

private Semaphore semaforo;
private static int ingressos = 100;
private int idthread;

public Bilheteria (int idthread, Semaphore semaforo) {
this.idthread = idthread;
this.semaforo = semaforo;

}

public void run () {
Login();
Compra();
Validacao();
}

public void Login() {
int tempo = 0;

tempo = (int) ((int) ((Math.random()*1951)+50));
try {
	sleep(tempo);
	if (tempo > 1000) {
	System.out.println("Tempo esgotado!");	
	}else
System.out.println("O usuário #" + idthread + " conseguiu acessar!");
Compra();

} catch (InterruptedException e) {

	e.printStackTrace();
}
	}

public void Compra() {
	
int t = 0;
t = (int) ((int) ((Math.random()*2001)+1000));
	try {
	sleep(t);
if (t > 2500 ) {	
	System.out.println("timeOut!");
}else
System.out.println("Validação da Compra: #" + idthread);
Validacao();
	} catch (Exception e) {
	e.printStackTrace();
	}
		}

public void Validacao() {
int ingre = (int) ((Math.random() *4) +1);
try {
if (ingressos >= 4 ) {
	ingressos-= ingre;
semaforo.acquire();

System.out.println("O usuário #" + idthread + " comprou: " + ingre + " ingressos. Sobraram somente: " + ingressos + " ingressos.");
}else {
System.out.println("ingressos esgotados");
	}
} catch (Exception e) {
e.printStackTrace();

} finally {
semaforo.release();
	}

		}
			}
