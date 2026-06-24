import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExemploSerializacao {

    private static void serializarContatos(List<Contato> listaContatos) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("agenda.ser"))) {
            outputStream.writeObject(listaContatos);
            System.out.println("Contatos serializados e salvos com sucesso!");
        }
    }

    @SuppressWarnings("unchecked")
    private static void deserializarContatos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("agenda.ser"))) {
            List<Contato> contatosLidos = (List<Contato>) inputStream.readObject();
            for (Contato contato : contatosLidos) {
                System.out.println("Nome: " + contato.nome + ", Telefone: " + contato.telefone);
            }
        }
    }

    // alternativa sem @SuppressWarnings
    /*
    private static void deserializarContatos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("agenda.ser"))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List<?>) {
                List<?> contatosLidos = (List<?>) obj;
                for (Object contato : contatosLidos) {
                    if (contato instanceof Contato) {
                        Contato contatoTyped = (Contato) contato;
                        System.out.println("Nome: " + contatoTyped.nome + ", Telefone: " + contatoTyped.telefone);
                    }
                }
            }
        }
    }
    */

    public static void main(String[] args) {
        Contato contato1 = new Contato("João", "(17) 99325-5456");
        Contato contato2 = new Contato("Jorge", "(15) 96552-5523");
        Contato contato3 = new Contato("Maria", "(1) 3388-6216");

        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);
        listaContatos.add(contato3);

        try {
            serializarContatos(listaContatos);
            deserializarContatos();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular contatos: " + e.getMessage());
        }
    }
}