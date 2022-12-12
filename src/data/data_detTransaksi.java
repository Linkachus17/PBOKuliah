package data;
import entity.entity_detTransaksi;
import entity.entity_barang2;
import java.util.ArrayList;

public class data_detTransaksi {
    private ArrayList<entity_detTransaksi> detTr;

    public data_detTransaksi() {
        this.detTr = new ArrayList<entity_detTransaksi>();
    }

    public void create(int idTransaksi, int jumlah, entity_barang2 brg){
        this.detTr.add(new entity_detTransaksi(idTransaksi,jumlah,brg));
    }

    public void view(){
        for (int i=0;i<this.detTr.size();i++)
        {
            this.detTr.get(i).cetak();
        }
    }

    public void view_byId(int idTransaksi)
    {
        for (int i=0;i<this.detTr.size();i++)
        {
            if (idTransaksi==this.detTr.get(i).getId_transaksi()) {
                this.detTr.get(i).cetak();
            }
        }
    }

    public int getTotalbyId(int idTransaksi)
    {
        int total = 0;
        for (int i=0;i<this.detTr.size();i++)
        {
            if (idTransaksi==this.detTr.get(i).getId_transaksi()) {
                total = total + this.detTr.get(i).getTotal();
            }
        }
        return total;
    }
}
