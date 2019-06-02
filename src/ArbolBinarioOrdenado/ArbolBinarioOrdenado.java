package ArbolBinarioOrdenado;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ArbolBinarioOrdenado {

    class Nodo {

        int infor;
        Nodo izq, der;
    }
    Nodo raiz;

    public ArbolBinarioOrdenado() {
        raiz = null;
    }

    public void Insertar(int info) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.infor = info;
        nuevo.izq = null;
        nuevo.der = null;
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo anterior = null, reco;
            reco = raiz;
            while (reco != null) {
                anterior = reco;
                if (info < reco.infor) {
                    reco = reco.izq;
                } else {
                    reco = reco.der;
                }
            }
            if (info < anterior.infor) {
                anterior.izq = nuevo;
            } else {
                anterior.der = nuevo;
            }

        }
    }

    private void imprimirPre(Nodo reco) {
        if (reco != null) {
            System.out.println(reco.infor + "");
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
        System.out.println();
    }

    private void imprimirEntre(Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.println(reco.infor + "");
            imprimirEntre(reco.der);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    private void imprimirPost(Nodo reco) {
        if (reco != null) {
            imprimirPost(reco.izq);
            imprimirPost(reco.der);
            System.out.println(reco.infor + "");
        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
        System.out.println();
    }

    public static void main(String[] args) {
        ArbolBinarioOrdenado abo = new ArbolBinarioOrdenado();
        int[] numeros = new int[5];
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String z = JOptionPane.showInputDialog(null, "Ingresa el numero " + (i + 1));
            numeros[i] = Integer.parseInt(z);
            abo.Insertar(numeros[i]);
        }
          
       
        System.out.println("Imprimir Preorden");
        abo.imprimirPre();
        System.out.println("Imprimir Inorden");
        abo.imprimirEntre();
        System.out.println("Imprimir Postorden");
        abo.imprimirPost();
    }
}
