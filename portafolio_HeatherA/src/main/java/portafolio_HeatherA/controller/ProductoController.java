/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package portafolio_HeatherA.controller;

import portafolio_HeatherA.domain.Producto;
import portafolio_HeatherA.service.ProductoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listado")
    public String inicio(Model model) {

        List<Producto> productos = productoService.getProductos();

        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());

        return "producto/listado.producto";
    }
}
