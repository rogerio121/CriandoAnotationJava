package testesJava;

import org.reflections.Reflections;

import java.util.Optional;
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

        System.out.println(getClasseByAnnotation("nomePassado", classes));
    }

    public static String getClasseByAnnotation(String annotationName, Set<Class<?>> classes){

    	String retorno = "";

    	Optional<Class<?>> optional = classes.stream().
    			filter(x -> x.getAnnotation(CustomAnotation.class)
    							.nome()
    							.equalsIgnoreCase(annotationName))
    							.findFirst();
    	
    	if(optional.isPresent()){
    		retorno = optional.get().getName();
    		System.out.println("Achou classe " + retorno);
    	}
        return retorno;
    }

}
