package clasesDTOAutogeneradas;
// default package
// Generated 09-jun-2015 15:28:13 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Regions generated by hbm2java
 */
public class Regions implements java.io.Serializable {

	private BigDecimal regionId;
	private String regionName;
	private Set countrieses = new HashSet(0); // HashSet no permite duplicados. Est� instanciado, creado,
			// fuera del constructor. al declarar el atributo constructor MUY IMPORTANTE SINO NO FUNCIONA

	public Regions() {
	}

	public Regions(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public Regions(BigDecimal regionId, String regionName, Set countrieses) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.countrieses = countrieses;
	}

	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Set getCountrieses() {
		return this.countrieses;
	}

	public void setCountrieses(Set countrieses) {
		this.countrieses = countrieses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Regiones:  regionId = " + regionId + "/nregionName = " + regionName;
	}

	
}
