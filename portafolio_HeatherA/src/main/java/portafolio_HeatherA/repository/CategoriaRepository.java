/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package portafolio_HeatherA.repository;

import portafolio_HeatherA.domain.Categoria;
import java.util.List;
import org.springframework.dara.jpa.repository.JpaRepository;
import org.springfarmework.stereotype.Repository;


/**
 *
 * @author heath
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Public List<Categoria> findByActivoTrue();
    
    
    
    
    
    
    
    
}
