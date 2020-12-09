package com.fatec.dados;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Usage sample serializing SomeClass instance
 */
public class Painel {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        read();
    }

    public static void inserirSetor(int idSetor, String nomeSetor) throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        List<Municipio> municipios = new ArrayList<>();
        List<Estado> estados = new ArrayList<>();
        estados = pais.getEstados();
        estados.add(new Estado(idSetor, nomeSetor, municipios));
        pais.setEstados(estados);
        String string = toString(pais);
        writeFile(string);
        




        System.out.println("Setor inserido!");
    }

    public static void alterarSetor(int idSetor, String nomeSetor) throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        for (Estado estado : pais.getEstados()) {
            if (estado.GetidEstado() == ) {
                estado.setNomeestado( 


                
                );
            }
        }
        String string = toString(Pais);
        writeFile(string);
        System.out.println("Setor alterado!");
    }

    public static void deletarSetor(int idSetor) throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        Setor setor = new Setor();
        for (Setor setorFor : pais.getestados())
            if (setorFor.getIdSetor() == idSetor)
                setor = setorFor;
        pais.getestados().remove(setor);
        String string = toString(Pais);
        writeFile(string);
        System.out.println("Setor deletado!");
    }

    public static void inserirFuncionario(int idSetor, int idFuncionario, String nomeFuncionario)
            throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        List<Funcionario> municipios = new ArrayList<>();
        for (Setor setor : pais.getestados()) {
            if (setor.getIdSetor() == idSetor) {
                municipios = setor.getmunicipios();
                municipios.add(new Funcionario(idFuncionario, nomeFuncionario));
                setor.setmunicipios(municipios);
            }
        }
        String string = toString(Pais);
        writeFile(string);
        System.out.println("Funcionario inserido!");
    }

    public static void alterarFuncionario(int idSetor, int idFuncionario, String nomeFuncionario)
            throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        for (Setor setor : pais.getestados()) {
            if (setor.getIdSetor() == idSetor) {
                for (Funcionario funcionario : setor.getmunicipios()) {
                    if (funcionario.getIdFuncionario() == idFuncionario)
                        funcionario.setNomeFuncionario(nomeFuncionario);
                }
            }
        }
        String string = toString(Pais);
        writeFile(string);
        System.out.println("Funcionario alterado!");
    }

    public static void deletarFuncionario(int idSetor, int idFuncionario) throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        Setor setor = new Setor();
        Funcionario funcionario = new Funcionario();
        for (Setor setorFor : pais.getestados())
            if (setorFor.getIdSetor() == idSetor) {
                setor = setorFor;
                for (Funcionario funcionarioFor : setorFor.getmunicipios())
                    if (funcionarioFor.getIdFuncionario() == idFuncionario)
                        funcionario = funcionarioFor;
            }

        setor.getmunicipios().remove(funcionario);
        String string = toString(Pais);
        writeFile(string);
        System.out.println("Funcionario deletado!");
    }

    public static void read() throws IOException, ClassNotFoundException {
        Pais pais = (Pais) fromString(readFile());
        System.out.println(
                "\n--------------------------------------------------------------------------------------------------------\n");
        System.out.println(pais);
        System.out.println(
                "\n--------------------------------------------------------------------------------------------------------\n");
    }

    public static void zerarBanco() throws IOException {
        List<Setor> listSetors = new ArrayList<>();
        String string = toString(new Pais("Pais Teste", "12321512", listSetors));
        writeFile(string);
    }

    public static String readFile() {
        String result = "";
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("doc.txt"), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return result;
    }

    public static void writeFile(String string) {
        Path path = Paths.get("doc.txt");
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        try {
            Files.write(path, bytes); // Java 7+ only
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Read the object from Base64 string. */
    private static Object fromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}