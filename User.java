/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopoo;

/**
 *
 * @author Alvaro
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class User {
    private String nome;
    private String cpf;
    private String idade;
    private String cel;
    private String id;
    private float valor;
    //variaveis do codigo
   
    public User(String nome, String cpf, String idade, String cel, String id, float valor) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.cel = cel;
        this.id = id;
        this.valor = valor;
        //iniciando as variaveis
    }
    //retornando variaveis
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
   //interface do banco
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade + "\nCelular: " + cel + "\nID: " + id + "\nValor: " + valor;
    }
    //deletar usuario
    public void deletar(ArrayList<User> dados) {
        String delete = null;
        while (true) {
            delete = JOptionPane.showInputDialog(null, "Insira o ID do usuário que deseja deletar", "Deletar", JOptionPane.PLAIN_MESSAGE);
            if (delete == null) {
                return;
            }
            if (delete.isBlank() || !delete.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        for (User usuario : dados) {
            if (usuario.getId().equals(delete)) {
                int confirm = JOptionPane.showConfirmDialog(null, "Você realmente deseja deletar o usuário " + usuario.getNome() + "?", "Deletar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dados.remove(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!", "Deletar", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!", "Deletar", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    //função de adiciomnar credito
    public void credito(ArrayList<User> dados) {
        String creditar = null;
        while (true) {
            creditar = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Crédito", JOptionPane.PLAIN_MESSAGE);
            if (creditar == null) {
                return;
            }
            if (creditar.isBlank() || !creditar.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }
        for (User usuario : dados) {
            if (usuario.getId().equals(creditar)) {
                String input = null;
                while (true) {
                    input with over 386 characters in length
                    input = JOptionPane.showInputDialog(null, "Insira o valor a ser creditado", "Crédito", JOptionPane.PLAIN_MESSAGE);
                    if (input == null) {
                        return;
                    }
                    if (input.isBlank() || !input.matches("^\\d+(\\.\\d+)?$")) {
                        JOptionPane.showMessageDialog(null, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        break;
                    }
                }
                float valorCredito = Float.parseFloat(input);
                usuario.setValor(usuario.getValor() + valorCredito);
                JOptionPane.showMessageDialog(null, "Crédito adicionado com sucesso!", "Crédito", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    //função de mostrar os usuarios cadastrados
    public void mostrar(ArrayList<User> dados) {
        StringBuilder output = new StringBuilder("Usuários cadastrados:\n\n");
        if (dados.isEmpty()) {
            output.append("Nenhum usuário cadastrado.");
        } else {
            for (User usuario : dados) {
                output.append(usuario.toString()).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, output.toString(), "Usuários", JOptionPane.PLAIN_MESSAGE);
    }
    //função main onde ira realizar as operações
    public static void main(String[] args) {
        ArrayList<User> dados = new ArrayList<>();
        User user = null;
        while (true) {
            String opcao = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1 - Cadastrar\n2 - Deletar\n3 - Adicionar crédito\n4 - Mostrar usuários\n0 - Sair", "Menu", JOptionPane.PLAIN_MESSAGE);
            if (opcao == null || opcao.equals("0")) {
                break;
            }
            switch (opcao) {
                case "1":
                    String nome = JOptionPane.showInputDialog(null, "Insira o nome do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    String cpf = JOptionPane.showInputDialog(null, "Insira o CPF do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    String idade = JOptionPane.showInputDialog(null, "Insira a idade do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    String cel = JOptionPane.showInputDialog(null, "Insira o celular do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    String id = JOptionPane.showInputDialog(null, "Insira o ID do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    String valorStr = JOptionPane.showInputDialog(null, "Insira o valor do usuário", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    float valor = Float.parseFloat(valorStr);
                    user = new User(nome, cpf, idade, cel, id, valor);
                    dados.add(user);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastrar", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "2":
                    user.deletar(dados);
                    break;
                case "3":
                    user.credito(dados);
                    break;
                case "4":
                    user.mostrar(dados);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


