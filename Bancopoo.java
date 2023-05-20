/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.bancopoo;

/**
 *
 * @author Alvaro
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Bancopoo {

    public static void main(String[] args) {
        ArrayList<cad> users = new ArrayList<cad>(); // Lista de usuários cadastrados
        int op = 99; // Inicializa op com um valor diferente de 7 para entrar no loop

        while (op != 7) {
            // Exibe um diálogo de entrada para o usuário escolher uma opção
            String input = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1- Cadastro\n2- Deletar usuário\n3- Crédito\n4- Débito\n5- Busca de usuário\n6- Atualizar\n7- Sair", "Banco Dias", JOptionPane.PLAIN_MESSAGE);
            op = Integer.parseInt(input); // Converte a entrada do usuário para um valor numérico

            switch (op) {
                case 1 -> {
                    // Cadastro de um novo usuário
                    String nome = JOptionPane.showInputDialog(null, "Insira seu nome", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String cpf = JOptionPane.showInputDialog(null, "Insira seu CPF", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String idade = JOptionPane.showInputDialog(null, "Insira sua idade", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String celular = JOptionPane.showInputDialog(null, "Insira seu número de celular", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    String id = JOptionPane.showInputDialog(null, "Insira seu ID", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    cad usuario = new cad(nome, cpf, idade, celular, id, 0); // Cria um novo objeto cad com as informações fornecidas
                    users.add(usuario); // Adiciona o usuário à lista de usuários cadastrados
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    JOptionPane.showMessageDialog(null, usuario.toString() + "Cadastro realizado com sucesso");
                }
                case 2 -> {
                    cad usuario;
                    // Deletar usuário
                    usuario.deletar(users);
                }
                case 3 -> {
                    cad usuario;
                    // Crédito em uma conta
                    usuario.credito(users);
                }
                case 4 -> {
                    cad usuario;
                    // Débito em uma conta
                    usuario.debito(users);
                }
                case 5 -> {
                    cad usuario;
                    // Busca de usuário
                    usuario.mostrar(users);
                }
                case 6 -> {
                    cad usuario;
                    // Atualizar informações de um usuário
                    usuario.atualizar(users);
                }
            }
        }
    }
}
