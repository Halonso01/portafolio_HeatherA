/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package portafolio_HeatherA.repository;

import portafolio_HeatherA.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author heath
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    public List<Categoria> findByActivoTrue(); 
}
