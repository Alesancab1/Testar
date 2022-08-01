package aiss.model.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsuarioRepository {
	private Map<String,String> usuarios;
	private static UsuarioRepository instance = null;
	
	public static UsuarioRepository getInstance() {
		if(instance==null) {
			instance = new UsuarioRepository();
			instance.init();
		}
		return instance;
	}

	private void init() {
		// TODO Auto-generated method stub
		usuarios = new HashMap<>();
		usuarios.put("Usuario","0");
		usuarios.put("Usuario1","1");
		usuarios.put("Usuario2","2");
		usuarios.put("Usuario3","3");
		usuarios.put("Usuario4","4");
		usuarios.put("Usuario5","5");
		usuarios.put("Usuario6","6");
	}
	
	public boolean existeUsuario(String nickname) {
		return usuarios.keySet().contains(nickname);
	}
	
	public boolean contrasenaValida(String nickname, String contrasena) {
		return usuarios.get(nickname).equals(contrasena);
	}
	
	public void registraUsuario(String nickname, String contrasena) {
		usuarios.put(nickname, contrasena);
	}
	
	public Set<String> getAll() {
		// TODO Auto-generated method stub
		return usuarios.keySet();
	}
}
