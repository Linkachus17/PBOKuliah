package entity;

public class entity_detTransaksi {
    private int id_transaksi;
    private int jumlah;
    private entity_barang2 barang;
    private int total;

    public entity_detTransaksi(int id_transaksi, int jumlah, entity_barang2 barang) {
        this.id_transaksi = id_transaksi;
        this.jumlah = jumlah;
        this.barang = barang;
        this.total = jumlah*barang.getHarga();
    }

    public int getTotal() {
        return total;
    }

    public void cetak()
    {
        System.out.println("id transaksi :"+this.id_transaksi);
        System.out.println("jumlah :"+ this.jumlah);
        System.out.println("id barang :"+barang.getKodeBarang());
        System.out.println("nama barang :"+barang.getNama());
        System.out.println("harga    :"+barang.getHarga());
        System.out.println("total :"+this.jumlah*barang.getHarga());
        System.out.println("================================");
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
}
