package exercicio;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Cliente> classe = Cliente.class;
        Class<?> clazz = Cliente.class;

        Constructor cons = clazz.getConstructor();
        Cliente cli1 = (Cliente) cons.newInstance();
        System.out.println(cons);
        System.out.println(cli1);

        System.out.println(cli1.getClass());

        Field[] fields = cli1.getClass().getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            String nome = field.getName();
            System.out.println(type);
            System.out.println(nome);
        }

        Method[] methods = cli1.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Class<?> type = method.getReturnType();
            String nome = method.getName();
            System.out.println(type);
            System.out.println(nome);
        }

        String tipoClasse = clazz.getSimpleName();
        System.out.println(tipoClasse);

        if(classe.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = classe.getAnnotation(Tabela.class);
            String nomeTabela = tabela.value();

            System.out.println("Nome tabela: " + nomeTabela);
        }
    }
}