package testesJava;

import org.reflections.Reflections;
import java.util.Set;

@CustomAnotation(nome = "nomePassado")
public class UserAnotation {

    private final String nome;

    public UserAnotation(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
        System.out.println("Scanning using Reflections:");

        Reflections reflections = new Reflections("testesJava");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(CustomAnotation.class);

        System.out.println(getClasseByAnnotation("", classes));

    }

    public static String getClasseByAnnotation(String annotationName, Set<Class<?>> classes){
        String retorno = "";

        for (Class<?> cl : classes) {
            CustomAnotation classeEncontrada = cl.getAnnotation(CustomAnotation.class);
            if(classeEncontrada.nome().equalsIgnoreCase(annotationName)) {
                retorno = cl.toString();
            }
        }
        return retorno;
    }

}
