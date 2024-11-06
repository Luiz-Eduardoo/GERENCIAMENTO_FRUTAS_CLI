package main;

import java.util.ArrayList; // Importa a classe ArrayList para fazer a lista
import java.util.InputMismatchException; // Importa a exceção para mostrar as entradas erradas
import java.util.Scanner; // Importa a classe Scanner para o usuario colocar os dados

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // cria o Scanner para que consiga usar os dados colocados pelo usuario
        ArrayList<String> frutas = new ArrayList<>(); // Array para guardar as informações

        while (true) { // loop infinito para as perguntas da lista
            try {
            	// mostra as opções que o usuario pode escolher
                System.out.println("Escolha uma opcao:");
                System.out.println("1. Adicionar uma fruta"); 
                System.out.println("2. Listar todas as frutas"); 
                System.out.println("3. Modificar uma fruta");
                System.out.println("4. Remover uma fruta");
                System.out.println("5. Sair");
                System.out.print("Opcao: "); // o usuario coloca o numero que ele vai querer alterar (adicionar/remover) ou listar
                int opcao = scanner.nextInt(); // ve a opção escolhida pelo usuario
                scanner.nextLine(); // limpa o buffer do scanner depois do numero inserido
                switch (opcao) { // swtich para cada opção que o usuario escolher
                    case 1:
                        System.out.print("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine(); // ve o nome inserido e guarda
                        frutas.add(novaFruta); // adiciona a fruta na lista
                        System.out.println(novaFruta + " foi adicionada.");
                        break; // termina o case 1
                    case 2:
                        System.out.println("Frutas: " + frutas); // mostra a lista de frutas colocadas pelo usuario
                        break; // termina o case 2
                    case 3:
                        System.out.println("Digite o índice da fruta que deseja modificar: ");
                        int indiceModificar = scanner.nextInt(); // ve qual o indice da fruta que o usuario quer modificar
                        scanner.nextLine(); // limpa o buffer do scanner
                        if (indiceModificar >= 0 && indiceModificar < frutas.size()) { // faz a verificação do indice
                            System.out.println("Digite o novo nome da fruta: ");
                            String frutaModificada = scanner.nextLine(); // guarda o nome novo da fruta
                            frutas.set(indiceModificar, frutaModificada); // modifica a fruta no lugar escolhido
                            System.out.println("Fruta do índice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("Índice inválido."); // caso tenha escolhido um indice que não existe, mostra o aviso
                        }
                        break; // termina o case 3
                    case 4:
                        System.out.println("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine(); // ve qual a fruta que o usuario quer remover
                        if (frutas.remove(frutaRemover)) { // faz a remoção da fruta
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada."); // se não tiver a fruta na lista, mostra o aviso
                        }
                        break; // termina o case 4
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close(); // fecha o Scanner
                        return; // retorna o fim do programa
                    default:
                        System.out.println("Opcao invalida. Tente novamente."); // caso o usuario escolha uma opção inexistente, mostra o aviso
                }
            } catch (InputMismatchException e) { // caso o usuário insira um tipo de dado inválido
                System.out.println("Entrada invalida. Por favor, digite um numero."); // aviso de exceção
                scanner.nextLine(); // limpa o buffer do scanner
            }
        }
    }
}