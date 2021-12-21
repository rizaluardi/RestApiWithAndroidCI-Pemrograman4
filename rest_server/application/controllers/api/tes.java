 @SerializedName("id_ruangan")
    private String id_ruangan;
    @SerializedName("ruangan")
    private String ruangan;
    @SerializedName("nomor")
    private String nomor;

    public Ruangan(String id_ruangan, String ruangan, String nomor) {
        this.id_ruangan = id_ruangan;
        this.ruangan = ruangan;
        this.nomor = nomor;
    }
    public String getId_ruangan() {
        return id_ruangan;
    }
    public void setId_ruangan(String id_ruangan) {
        this.id_ruangan = id_ruangan;
    }
    public String getRuangan() {
        return ruangan;
    }
    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }
    public String getNomor() {
        return nomor;
    }
    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}

