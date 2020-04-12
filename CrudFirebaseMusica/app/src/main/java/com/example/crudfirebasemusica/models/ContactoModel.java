package com.example.crudfirebasemusica.models;

import java.io.Serializable;

public class ContactoModel implements Serializable {

    String _id;
    String _nombre;
    String _genero;

    public ContactoModel() {
    }

    public ContactoModel(String _id, String _nombre, String _genero) {
        this._id = _id;
        this._nombre = _nombre;
        this._genero = _genero;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_genero() {
        return _genero;
    }

    public void set_genero(String _genero) {
        this._genero = _genero;
    }
}
