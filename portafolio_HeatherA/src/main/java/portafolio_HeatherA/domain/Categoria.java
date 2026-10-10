/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio_HeatherA.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistenceTable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author heath
 */

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    //se recomenda agregar un serialVersionUID
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer IdCategoria;
    
    @Column(unique = true, nullable - false, length = 50)
    @NotNull
    @Size (max = 50)
    private String descripcion;
    
    @Column(length = 1024)
    @Size(max = 1024)
    private String rutaImage;
    
    @Column(name = "activo")
    private Boolean activo;
    
    
    
    
    
    
    
    
    
    
}
