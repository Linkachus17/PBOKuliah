package data;

import java.util.ArrayList;
import entity.entity_transaksi;

public class data_transaksi {
    private ArrayList<entity_transaksi> DBtransaksi;
    int idIncrement = 0;

    public data_transaksi() {
        this.DBtransaksi = new ArrayList<entity_transaksi>();
    }

    public void create(int nipKasir){
        this.DBtransaksi.add(new entity_transaksi(this.idIncrement,"10/10/2020",nipKasir,0));
        this.idIncrement++;
    }

    public void setTotal(int total)
    {
        this.DBtransaksi.get(this.idIncrement-1).setTotal(total);
    }

    public void cetak()
    {
        for (int i=0;i<this.DBtransaksi.size();i++)
        {
            this.DBtransaksi.get(i).cetak();
        }
    }

    public int getIdIncrement() {
        return idIncrement-1;
    }
}
