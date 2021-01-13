package com.example.Masjid;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class Masjid {

    public static final String LOTIM="LOTIM";
    public static final String LOTENG="LOTENG";
    public static final String LOBAR="LOBAR";


    private String id;
    private Date tanggal;
    private String nama;
    private String desa;
    private String kecamatan;
    private String kabupaten;


    public Masjid() {
        this.id = UUID.randomUUID().toString();
        this.tanggal = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKecamatan() { return kecamatan; }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }


    public static Masjid fromJSONObject(JSONObject obj) {
        Masjid tr = new Masjid();
        try {
            tr.setId(obj.getString("id"));
            tr.setTanggal(new Date(obj.getLong("tanggal")));
            tr.setNama(obj.getString("nama"));
            tr.setKabupaten(obj.getString("kabupaten"));
            tr.setDesa(obj.getString("desa"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id",this.id);
            jsonObj.put("tanggal",this.tanggal.getTime());
            jsonObj.put("nama",this.nama);
            jsonObj.put("desa",this.desa);
            jsonObj.put("kecamatan",this.kecamatan);
            jsonObj.put("kabupaten",this.kabupaten);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
