package com.example.kikerojas.sqlite_crud.entidades;

/**
 * Created by kikerojas on 19/04/2016.
 */
public class Personas {
    private int _id;
    private String _nombre;
    private String _apellido;
    private String _direccion;
    private int _numero;
    private String _correo;

    public Personas() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String get_direccion() {
        return _direccion;
    }

    public void set_direccion(String _direccion) {
        this._direccion = _direccion;
    }

    public int get_numero() {
        return _numero;
    }

    public void set_numero(int _numero) {
        this._numero = _numero;
    }

    public String get_correo() {
        return _correo;
    }

    public void set_correo(String _correo) {
        this._correo = _correo;
    }

    //ordenar por id
    public void agregarWithId(int id,String nombre, String direccion,  String apellido, int numero, String correo ){
        this._id = id;
        this._nombre = nombre;
        this._direccion = direccion;
        this._apellido = apellido;
        this._numero = numero;
        this._correo = correo;
    }
    //agregando desde entidades
    public void agregar(String nombre ,int numero ){
        this._nombre = nombre;
        this._numero = numero;

    }
}
