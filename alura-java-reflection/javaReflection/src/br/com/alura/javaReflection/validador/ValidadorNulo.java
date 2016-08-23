package br.com.alura.javaReflection.validador;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorNulo {
	
	public static List<String> getAtributosNulos(Object o){
		List<String> lista = new ArrayList<String>();
		
		try {
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object value;
				value = f.get(o);
				if(value == null){
					lista.add(f.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static List<String> buscaStringEmAtributos(Object o, String buscada){
	    try {
	        List<String> lista = new ArrayList<>();
	        Class<?> c = o.getClass();
	        for(Field f : c.getFields()){
	            Object value = f.get(o);
	            if(value != null){
	                String strValue = value.toString();
	                if(strValue.contains(buscada)){
	                    lista.add(f.getName());
	                }
	            }
	        }
	        return lista;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}

}
