package testesJava;
import com.sun.javaws.Main;
import jdk.nashorn.internal.objects.NativeArray;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        for (Class<?> cl : classes) {
            Object classeEncontrada = cl.getAnnotation(CustomAnotation.class);
            System.out.println(((CustomAnotation) classeEncontrada).nome());
        }

        System.out.printf(classes.toString());
        //String key = challengeClass.getAnnotation(CustomAnotation.class).key();
    }
}
