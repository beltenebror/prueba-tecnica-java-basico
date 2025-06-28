package org.example.persistence;

import org.example.entities.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteJPA {

    public void crear(Cliente cliente) {

        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

        }


    }

    public List<Cliente> listarClientes() {


        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            List<Cliente> clientes = em.createQuery("FROM Cliente", Cliente.class).getResultList();
            em.getTransaction().commit();
            return clientes;
        }


    }

    public void actualizar(Cliente cliente) {

        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        }


    }
    //METODO DE ACTUALIZAR CON LOS SETS
/*    public static void actualizar(long id, String nombre, String apellidos, String sexo, String ciudad, LocalDate fechaNacimiento, String telefono, String correoElectronico) {

        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();

        Cliente clienteActualziar = em.find(Cliente.class, id);

        if (clienteActualziar != null) {
            clienteActualziar.setNombre(nombre);
            clienteActualziar.setApellidos(apellidos);
            clienteActualziar.setSexo(sexo);
            clienteActualziar.setCiudad(ciudad);
            clienteActualziar.setFechaNacimiento(fechaNacimiento);
            clienteActualziar.setTelefono(telefono);
            clienteActualziar.setCorreoElectronico(correoElectronico);
        } else {
            System.out.println("El auto no existe");
        }


        em.getTransaction().commit();
        em.close();


    }*/

    public void eliminar(long idEliminar) {

        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            Cliente clienteEliminar = em.find(Cliente.class, idEliminar);
            em.remove(clienteEliminar);
            em.getTransaction().commit();
        }


    }

    public boolean comprobarId(long id) {


        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();


            Cliente clienteExiste = em.find(Cliente.class, id);
            em.getTransaction().commit();//


            return clienteExiste != null;
        }


    }

}
