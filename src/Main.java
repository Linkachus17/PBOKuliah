import data.data_barang;
import data.data_detTransaksi;
import data.data_transaksi;
import entity.entity_barang2;
import data.data_kasir;
import entity.entity_transaksi;
import entity.entity_detTransaksi;

import java.util.Scanner;

public class Main {
    static void menu(data_transaksi DBtransaksi,data_barang DBBrg, data_detTransaksi DBdetTr, int nipKasir){
        System.out.println("menu transaksi");
        DBtransaksi.create(nipKasir);
        Scanner scn = new Scanner(System.in);
        String ulang="y";
        while (ulang.equals("y"))
        {
            System.out.println("---------------------");
            System.out.println("masukkan kode barang :");
            int kode = scn.nextInt();
            entity_barang2 barang = DBBrg.searchByid(kode);
            System.out.println("jumlah barang:");
            int jml = scn.nextInt();
            DBdetTr.create(DBtransaksi.getIdIncrement(),jml,barang);
            System.out.println("apakah anda inggin mengulang? (y/t)?");
            ulang = scn.next();
        }
        DBdetTr.view_byId(DBtransaksi.getIdIncrement());
        DBtransaksi.setTotal(DBdetTr.getTotalbyId(DBtransaksi.getIdIncrement()));
        DBtransaksi.cetak();
    }
    public static void main(String[] args){
        System.out.println("Project PBO 2022");

        //input data kasir
        data_kasir database_kasir = new data_kasir();
        database_kasir.create("kurniawan",155,"123");
        database_kasir.create("aan",156,"123");
        database_kasir.read(); // viev database kasir

        // cek method update
        database_kasir.update_pass(111,"111"); //pengujian salah
        database_kasir.update_pass(155,"111"); //pengujian benar
        database_kasir.read();

//        //cek method delete
//        database_kasir.delete(111); //pengujian salah
//        database_kasir.delete(155); //pengujian benar
//        database_kasir.read();
//
        //tes login
        int nip1 = database_kasir.login(156,"111");
        int nip2 = database_kasir.login(156,"123");

        //data barang
        data_barang DBbarang = new data_barang();
        DBbarang.create(1,"pepsodent",7000,1);
        DBbarang.create(2,"ciptadent",5000,12);
        DBbarang.view();
        System.out.println("==========overload======");
        DBbarang.view(1);
        DBbarang.updateHarga_viaKode(1,1000);

        //NIP aktif kasir
        System.out.println("kasir aktir : "+nip2);

//        //transaksi
        data_transaksi DBtransaksi= new data_transaksi();
        data_detTransaksi DBdetTransaksi = new data_detTransaksi();
//
//        entity_transaksi tr1 = new entity_transaksi(1,"10/10/2020",nip2,0);
//        entity_transaksi tr2 = new entity_transaksi(2,"11/11/2020",nip2,0);
//        DBtransaksi.create(tr1);
//        DBtransaksi.create(tr2);
//        data_detTransaksi dtTr = new data_detTransaksi();
//        dtTr.create(1,2,DBbarang.get_objBarang(1));
//        dtTr.create(1,2,DBbarang.get_objBarang(0));
//        dtTr.create(1,3,DBbarang.get_objBarang(1));
//        dtTr.create(2,4, DBbarang.get_objBarang(0));
//        System.out.println("====***=====");
//        dtTr.view();
//        System.out.println("====***=====");
//        dtTr.view_byId(1);
//        System.out.println("=======***=====");
//        dtTr.view_byId(2);
        menu(DBtransaksi,DBbarang,DBdetTransaksi,nip2);
    }
}