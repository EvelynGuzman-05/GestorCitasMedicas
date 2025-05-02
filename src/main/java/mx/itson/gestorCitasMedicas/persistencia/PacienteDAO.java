/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.gestorCitasMedicas.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.gestorCitasMedicas.entidades.Paciente;
import mx.itson.gestorCitasMedicas.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Evelyn Guzman
 */
public class PacienteDAO {
    
    public static List<Paciente> obtenerTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Paciente> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Paciente.class);
            criteriaQuery.from(Paciente.class);
            pacientes = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return pacientes;
    }
    
     public static boolean save(Paciente p){
        boolean resultado = false;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(p);
            session.getTransaction().commit();
            
            resultado = p.getIdPaciente() !=0;
            
            
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " +  ex.getMessage());
        }
        return resultado;
    }
    
    
}
