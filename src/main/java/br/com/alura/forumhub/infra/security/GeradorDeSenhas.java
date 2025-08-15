package br.com.alura.forumhub.infra.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("Alice: " + encoder.encode("alice123"));
        System.out.println("Bruno: " + encoder.encode("bruno456"));
        System.out.println("Carla: " + encoder.encode("carla789"));
        System.out.println("Daniel: " + encoder.encode("daniel321"));
        System.out.println("Eduarda Lima: " + encoder.encode("eduarda654"));
        System.out.println("Felipe Torres: " + encoder.encode("felipe987"));
        System.out.println("Gustavo Alves: " + encoder.encode("gustavo159"));
        System.out.println("Helena Castro: " + encoder.encode("helena753"));
        System.out.println("Igor Mendes: " + encoder.encode("igor852"));
        System.out.println("Juliana Costa: " + encoder.encode("juliana951"));
        System.out.println("Karen Brito: " + encoder.encode("karen963"));
        System.out.println("Leonardo Nunes: " + encoder.encode("leo741"));
        System.out.println("Marina Farias: " + encoder.encode("marina258"));
        System.out.println("Nicolas Duarte: " + encoder.encode("nicolas369"));
        System.out.println("Otávia Fernandes: " + encoder.encode("otavia147"));
        System.out.println("Paulo Moreira: " + encoder.encode("paulo321"));
        System.out.println("Rafaela Teixeira: " + encoder.encode("rafaela654"));
        System.out.println("Sérgio Pinto: " + encoder.encode("sergio753"));
        System.out.println("Talita Campos: " + encoder.encode("talita852"));
        System.out.println("Vinícius Lopes: " + encoder.encode("vinicius951"));
    }
}
