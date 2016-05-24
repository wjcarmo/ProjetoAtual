package br.com.tjmg.pje.interfaces;

public class ClsUsuarioDoSistema {
	
	private int varCodigoUsuario;
	private String varNomeUsuario;
	private String varSenhaUsuario;
	private String varTipoUsuario;
	
	

	public ClsUsuarioDoSistema(String varNomeUsuario, String varSenhaUsuario) {
		super();
		this.varNomeUsuario = varNomeUsuario;
		this.varSenhaUsuario = varSenhaUsuario;
	}
	
	public ClsUsuarioDoSistema()
	{
		
	}
	public String getVarNomeUsuario() {
		return varNomeUsuario;
	}
	public void setVarNomeUsuario(String varNomeUsuario) {
		this.varNomeUsuario = varNomeUsuario;
	}
	public String getVarSenhaUsuario() {
		return varSenhaUsuario;
	}
	public void setVarSenhaUsuario(String varSenhaUsuario) {
		this.varSenhaUsuario = varSenhaUsuario;
	}
	
	public int getVarCodigoUsuario() {
		return varCodigoUsuario;
	}
	public void setVarCodigoUsuario(int varCodigoUsuario) {
		this.varCodigoUsuario = varCodigoUsuario;
	}
	
	public String getVarTipoUsuario() {
		return varTipoUsuario;
	}

	public void setVarTipoUsuario(String i) {
		this.varTipoUsuario = i;
	}

	@Override
	public String toString() {
		return "ClsUsuarioDoSistema [varCodigoUsuario=" + varCodigoUsuario
				+ ", varNomeUsuario=" + varNomeUsuario + ", varSenhaUsuario="
				+ varSenhaUsuario + ", varTipoUsuario=" + varTipoUsuario + "]";
	}
	
	

}
