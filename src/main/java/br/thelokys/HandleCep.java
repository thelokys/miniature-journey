package br.thelokys;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;

import java.io.IOException;

/**
 * Example how to use ViaCEP lib
 */
public class HandleCep {
    public static void main(String[] args) {
        ViaCEPClient viaCEPClient = new ViaCEPClient();

        try {
            var address = viaCEPClient.getEndereco("82010340");
            System.out.println("CEP: " + address.getCep());
            System.out.println("Address: " + address.getLogradouro());
            System.out.println("Neighborhood: " + address.getBairro());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
