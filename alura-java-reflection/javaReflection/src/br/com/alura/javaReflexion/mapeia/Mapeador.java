package br.com.alura.javaReflexion.mapeia;

import java.io.FileInputStream;
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

}
