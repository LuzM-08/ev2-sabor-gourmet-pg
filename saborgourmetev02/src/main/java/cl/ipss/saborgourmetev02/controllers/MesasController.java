package cl.ipss.saborgourmetev02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cl.ipss.saborgourmetev02.models.Mesas;
import cl.ipss.saborgourmetev02.services.MesasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/mesas")
public class MesasController {

    @Autowired
    private MesasService mesasService;

    // Listar Mesas
    @GetMapping
    public String listarMesas(Model model) {
        model.addAttribute("titulo", "Lista de Mesas");
        model.addAttribute("mesas", mesasService.listarTodas());
        return "mesas-listar";
    }

    // Nueva Mesa
    @GetMapping("/nuevo")
    public String nuevaReserva(Model model) {
        model.addAttribute("mesas", new Mesas());
        return "mesas-agregar";
    }

    // Guardar Mesa
    @PostMapping("/guardar")
    public String guardarMesas(Mesas mesas) {
        mesasService.guardar(mesas);
        return "redirect:/mesas";
    }

    // Editar Mesas
    @GetMapping("/editar/{id}")
    public String editarMesas(@PathVariable Long id, Model model) {
        model.addAttribute("mesas", mesasService.obtenerPorId(id));
        return "mesas-agregar";
    }

    // Eliminar Mesas
    @GetMapping("/eliminar/{id}")
    public String eliminarMesas(@PathVariable Long id) {
        mesasService.eliminar(id);
        return "redirect:/mesas";
    }

}
