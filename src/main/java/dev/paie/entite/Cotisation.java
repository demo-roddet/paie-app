package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

/**
 * 
 * @author Jordan
 *
 */
@Entity
@Table(name="cotisation")
public class Cotisation extends BaseEntite{
	
	private String code;
	private String libelle;
	private BigDecimal tauxSalarial;
	private BigDecimal tauxPatronal;
	private Boolean imposable = false;
	
	@ManyToMany
	@JoinTable(name="profil_remuneration_cotisations", joinColumns = @JoinColumn(name="cotisations_id", referencedColumnName = "id"),
														inverseJoinColumns = @JoinColumn(name="profil_remuneration_id", referencedColumnName = "id"))
	private List<ProfilRemuneration> profilRemunerations;
	
	public Cotisation() {

	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Boolean getImposable() {
		return imposable;
	}
	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}

	public List<ProfilRemuneration> getProfilRemunerations() {
		return profilRemunerations;
	}

	public void setProfilRemunerations(List<ProfilRemuneration> profilRemunerations) {
		this.profilRemunerations = profilRemunerations;
	}

	@Override
	public String toString() {
		return "Cotisation [code=" + code + ", libelle=" + libelle + ", tauxSalarial=" + tauxSalarial
				+ ", tauxPatronal=" + tauxPatronal + ", imposable=" + imposable + ", profilRemunerations="
				+ profilRemunerations + "]";
	}
	
	
}
