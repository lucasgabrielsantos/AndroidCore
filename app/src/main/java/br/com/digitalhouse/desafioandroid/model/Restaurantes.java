package br.com.digitalhouse.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class Restaurantes implements Parcelable {
    private int imagemRestaurante;
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioFechamento;
    private List<Pratos> listaDePratos;

    //construtor de Restaurante


    public Restaurantes(int imagemRestaurante, String nomeRestaurante,
                        String enderecoRestaurante, String horarioFechamento, List<Pratos> listaDePratos) {
        this.imagemRestaurante = imagemRestaurante;
        this.nomeRestaurante = nomeRestaurante;
        this.enderecoRestaurante = enderecoRestaurante;
        this.horarioFechamento = horarioFechamento;
        this.listaDePratos = listaDePratos;
    }

    public Restaurantes() {
    }


    protected Restaurantes(Parcel in) {
        nomeRestaurante = in.readString();
        enderecoRestaurante = in.readString();
        horarioFechamento = in.readString();
        imagemRestaurante = in.readInt();
        listaDePratos = new ArrayList<>();
        in.readList(listaDePratos, Pratos.class.getClassLoader());
    }

    public static final Creator<Restaurantes> CREATOR = new Creator<Restaurantes>() {
        @Override
        public Restaurantes createFromParcel(Parcel in) {
            return new Restaurantes(in);
        }

        @Override
        public Restaurantes[] newArray(int size) {
            return new Restaurantes[size];
        }
    };

    // getters and setters
    public int getImagemRestaurante() {
        return imagemRestaurante;
    }

    public void setImagemRestaurante(int imagemRestaurante) {
        this.imagemRestaurante = imagemRestaurante;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public List<Pratos> getListaDePratos() {
        return listaDePratos;
    }

    public void setListaDePratos(List<Pratos> listaDePratos) {
        this.listaDePratos = listaDePratos;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeRestaurante);
        dest.writeString(enderecoRestaurante);
        dest.writeString(horarioFechamento);
        dest.writeInt(imagemRestaurante);
        dest.writeList(listaDePratos);
    }
}
