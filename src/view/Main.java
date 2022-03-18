package view;
import java.util.concurrent.Semaphore;
import controller.Bilheteria;
public class Main {

public static void main(String[] args) {
int pessoa = 300;
Semaphore semaforo = new Semaphore(1);

for (int idthread = 1; idthread <= pessoa; idthread++) {
 new Bilheteria (idthread, semaforo).start();

	}
		}
			}
