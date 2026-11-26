
package portafolio_HeatherA.service;

import portafolio_HeatherA.domain.Categoria;
import portafolio_HeatherA.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorias o solamente las activas
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        if (activo) {
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }

    // Obtener una categoria por su identificador
    @Transactional(readOnly = true)
    public Optional<Categoria> getCategoria(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    // Guardar o modificar una categoria
    @Transactional
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    // Eliminar una categoria por su identificador
    @Transactional
    public void delete(Integer idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new IllegalArgumentException(
                        "La categoria no existe"));

        categoriaRepository.delete(categoria);
    }
}
