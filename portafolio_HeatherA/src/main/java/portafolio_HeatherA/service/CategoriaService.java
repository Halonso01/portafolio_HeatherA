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

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        if (activo) {
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaRepository.findById(categoria.getIdCategoria())
                .orElse(null);
    }

    // Guardar o modificar una categoría
    @Transactional
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    // Eliminar una categoría
    @Transactional
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}

    

