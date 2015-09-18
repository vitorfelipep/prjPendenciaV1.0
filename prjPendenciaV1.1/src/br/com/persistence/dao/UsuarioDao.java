package br.com.persistence.dao;


import br.com.model.UsuarioModel;

public class UsuarioDao extends DaoMysql{
	public UsuarioModel getUsuario(UsuarioModel usuario){
		try{
			
			open();
				Boolean autenticado = false;
				stmt = con.prepareStatement("select usuarioLogin, senhaUsu, usuarioNome from adv_pendencia.usuario where usuarioLogin = ? and senhaUsu = ?");
				
				stmt.setString(1, usuario.getLogin());
				stmt.setString(2, usuario.getSenha());
				
				rs = stmt.executeQuery();
				UsuarioModel usuarioResult = new UsuarioModel();
				if(rs.next()){
					
					usuarioResult.setLogin(rs.getString("usuarioLogin"));
					usuarioResult.setSenha(rs.getString("senhaUsu"));
					usuarioResult.setNomeUsuario(rs.getString("usuarioNome"));
					autenticado = true;
					close();
					return usuarioResult;
				}else{
					
					return null;
				}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
