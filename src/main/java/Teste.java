
import entidade.Cliente;
import entidade.Pedido;
import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john
 */
public class Teste {

    public static void main(String[] args) {
        int maior = 0;
        int[] numeros = {8, 6, 1, 1, 2};
        for (int n : numeros) {
            if (n > maior) {
                maior = n;
            }
        }
        
        System.out.println("Maior: "+ maior);
        int menor = 0;
        int posicao = -1;
        int ultimo = 0;
        int qtd = 0;

        for (int i = 0; i < numeros.length; i++) {
            menor = maior;
            for (int j = 0; j < numeros.length; j++) {
          
                if (numeros[j] < menor && posicao != j) {
                    menor = numeros[j];
                    posicao = j;
                }
                qtd++;
                if (ultimo != menor && ultimo != 0 || menor == maior) {
                    qtd++;
                    ultimo = menor;
                }
            }
            System.out.println("Nota: " + menor);
            System.out.println("Quantidade de doces: " + qtd);

        }
    }
}
