package com.jeffersonmazul.controller;

import com.jeffersonmazul.model.Rol;
import com.jeffersonmazul.model.Usuario;
import java.util.ArrayList;

public class AuthSistema {

    // Lista estática que actúa como base de datos temporal en memoria
    private static final ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    // Bloque de inicialización estática: se ejecuta una única vez al cargar la clase
    static {
        Usuario usuarioAdmin = new Usuario("Admin", "admin", "admin", Rol.ADMIN);
        Usuario usuarioUser = new Usuario("User", "user", "user", Rol.USER);
        Usuario userYo = new Usuario("Kenneth", "123", "Kenneth Velasquez", Rol.USER);

        listaUsuarios.add(usuarioAdmin);
        listaUsuarios.add(usuarioUser);
        listaUsuarios.add(userYo);
    }

    /**
     * Constructor por defecto de la clase.
     */
    public AuthSistema() {
    }

    /**
     * Valida las credenciales proporcionadas contra los registros de la lista.
     * 
     * @param nombreUsuario Nombre de cuenta ingresado por el usuario.
     * @param clave Contraseña ingresada por el usuario.
     * @return El objeto Usuario coincidente, o null si las credenciales son incorrectas.
     */
    public Usuario login(String nombreUsuario, String clave) {
        for (Usuario usuarioBuscado : listaUsuarios) {
            // Se evalúa coincidencia exacta en usuario y contraseña para la seguridad del inicio
            if (usuarioBuscado.getNombreUsuario().equals(nombreUsuario)
                    && usuarioBuscado.getPassword().equals(clave)) {
                return usuarioBuscado;
            }
        }
        return null;
    }

    /**
     * Obtiene el listado completo de usuarios registrados en el sistema.
     * 
     * @return ArrayList de tipo Usuario.
     */
    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}