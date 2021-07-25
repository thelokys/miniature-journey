package br.thelokys;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;
import br.com.caelum.stella.validation.*;
import org.jetbrains.annotations.NotNull;

/**
 * This class contain example of how to use Lib stella to validation some
 * Documents from brazil
 */
public class ValidatorDocument {
    public static void main(String... args) {

        /**
         * Cpf
         */
        String cpf = "56535803090";
        try {
            validatorDoc(new CPFValidator(), cpf);
            System.out.println(
                    "CPF válido " + formatterDoc(new CPFFormatter(), cpf));
        } catch (InvalidStateException exception) {
            System.out.println("CPF inválido " + exception);
        }

        /**
         * Cnpj
         */
        String cnpj = "82588641000173";
        try {
            validatorDoc(new CNPJValidator(), cnpj);
            System.out.println(
                    "CNPJ válido " + formatterDoc(new CNPJFormatter(), cnpj));
        } catch (InvalidStateException exception) {
            System.out.println("CNPJ inválido " + exception);
        }

        /**
         * Titulo Eleitor
         */
        var tituloEleitor = "600466820159";
        try {
            validatorDoc(new TituloEleitoralValidator(), tituloEleitor);
            System.out.println("Título Eleitor válido " +
                    formatterDoc(new TituloEleitoralFormatter(),
                            tituloEleitor));
        } catch (InvalidStateException exception) {
            System.out.println("Título Eleitor inválido " + exception);
        }
    }

    private static void validatorDoc(@NotNull Validator<String> validator,
                                     String document)
            throws InvalidStateException {
        validator.assertValid(document);
    }

    private static String formatterDoc(@NotNull Formatter formatter,
                                       String document)
            throws IllegalArgumentException {
        return formatter.format(document);
    }

}
