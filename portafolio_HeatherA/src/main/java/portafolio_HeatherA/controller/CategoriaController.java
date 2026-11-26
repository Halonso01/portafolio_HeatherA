
package portafolio_HeatherA.controller;

import portafolio_HeatherA.domain.Categoria;
import portafolio_HeatherA.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.Locale;
import java.util.Optional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final MessageSource messageSource;

    public CategoriaController(
            CategoriaService categoriaService,
            MessageSource messageSource) {
        this.categoriaService = categoriaService;
        this.messageSource = messageSource;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());

        return "categoria/listado.categoria";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid Categoria categoria,
            RedirectAttributes redirectAttributes) {

        categoriaService.save(categoria);

        redirectAttributes.addFlashAttribute(
                "todoOk",
                messageSource.getMessage(
                        "mensaje.actualizado", null, Locale.getDefault()));

        return "redirect:/categoria/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(
            @RequestParam Integer idCategoria,
            RedirectAttributes redirectAttributes) {

        String titulo = "todoOk";
        String detalle = "mensaje.eliminado";

        try {
            categoriaService.delete(idCategoria);
        } catch (IllegalArgumentException e) {
            titulo = "error";
            detalle = "categoria.error01";
        } catch (IllegalStateException e) {
            titulo = "error";
            detalle = "categoria.error02";
        } catch (Exception e) {
            titulo = "error";
            detalle = "categoria.error03";
        }

        redirectAttributes.addFlashAttribute(
                titulo,
                messageSource.getMessage(
                        detalle, null, Locale.getDefault()));

        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String modificar(
            @PathVariable("idCategoria") Integer idCategoria,
            Model model,
            RedirectAttributes redirectAttributes) {

        Optional<Categoria> categoriaOpt =
                categoriaService.getCategoria(idCategoria);

        if (categoriaOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    messageSource.getMessage(
                            "categoria.error01", null, Locale.getDefault()));

            return "redirect:/categoria/listado";
        }

        model.addAttribute("categoria", categoriaOpt.get());

        return "categoria/modifica";
    }
}
