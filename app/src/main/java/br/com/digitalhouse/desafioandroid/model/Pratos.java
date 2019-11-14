package br.com.digitalhouse.desafioandroid.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Pratos implements Parcelable {
    private int imagemPrato;
    private String nomePrato;
    private String descPrato;

    //construtor prato
    public Pratos(int imagemPrato, String nomePrato) {
        this.imagemPrato = imagemPrato;
        this.nomePrato = nomePrato;
    }

    public Pratos(int imagemPrato, String nomePrato, String descPrato) {
        this.imagemPrato = imagemPrato;
        this.nomePrato = nomePrato;
        this.descPrato = descPrato;
    }

    public Pratos() {
    }

    //getters and setters

    protected Pratos(Parcel in) {
        imagemPrato = in.readInt();
        descPrato = in.readString();
        nomePrato = in.readString();

    }

    public static final Creator<Pratos> CREATOR = new Creator<Pratos>() {
        @Override
        public Pratos createFromParcel(Parcel in) {
            return new Pratos(in);
        }

        @Override
        public Pratos[] newArray(int size) {
            return new Pratos[size];
        }
    };

    public int getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(int imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescPrato() {
        return descPrato;
    }

    public void setDescPrato(String descPrato) {
        this.descPrato = descPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagemPrato);
        dest.writeString(descPrato);
        dest.writeString(nomePrato);

    }
}