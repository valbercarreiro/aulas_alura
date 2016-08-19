package br.com.alura.javaReflexion.mapeia;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	
	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void load(String nomeArquivo) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(nomeArquivo));
		for (Object o : prop.keySet()) {
			Class<?> interf = Class.forName(o.toString());
			Class<?> impl = Class.forName(prop.get(o).toString());
			
			if(!interf.isInterface()){
				throw new RuntimeException("O tipo "+interf.getName()+" não é uma interface");
			}
			
			if(!interf.isAssignableFrom(impl)){
				throw new RuntimeException("A classe "+impl.getName()+" não implementa "+interf.getName());
			}
			
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf){
		return mapa.get(interf);
	}

	public <E> E getInstancia(Class<?> interf) throws InstantiationException, IllegalAccessException{
		return (E) mapa.get(interf).newInstance();
	}
	
	public <E> E getInstancia(Class<E> interf, Object... params) throws Exception {
		Class<?> impl = mapa.get(interf);
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		for (int i = 0; i < tiposConstrutor.length; i++) {
			tiposConstrutor[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(tiposConstrutor);
		return (E) c.newInstance(params);
	}
}
