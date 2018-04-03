/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peripurnama.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author peripurnama
 */
@Embeddable
public class Alamat {

	@Column(name = "PROVINSI")
	private String provinsi;

	@Column(name = "kota")
	private String kota;

	@Column(name = "kecamatan")
	private String kecamatan;

	@Column(name = "kelurahan")
	private String kelurahan;

	@Column(name = "kode_pos")
	private Integer kodePos;

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public Integer getKodePos() {
		return kodePos;
	}

	public void setKodePos(Integer kodePos) {
		this.kodePos = kodePos;
	}

}
