/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio_HeatherA.service;

import portafolio_HeatherA.domain.Categoria;
import portafolio_HeatherA.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author heath
 */

@Service
public class CategoriaService {
    
    //el repositorio es final para asegurar la unmutabilidad
    private final CategoriaRepository categoriaRepository;
    
    //inyeccion por constructor (no requiere @autowired en spring moderno)
    public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
    
    }
    
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
    if (activo) { //solo activos
        return categoriaRepository.findByActivoTrue ();
    }
    return categoriaRepository.findAll();
        
    }
    
    
    
    }
    
    
    
    
    

