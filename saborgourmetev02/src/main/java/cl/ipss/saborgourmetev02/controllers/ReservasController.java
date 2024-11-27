package cl.ipss.saborgourmetev02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import cl.ipss.saborgourmetev02.models.Reservas;
import cl.ipss.saborgourmetev02.services.MesasService;
import cl.ipss.saborgourmetev02.services.ReservasService;

@Controller
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;
    @Autowired
    private MesasService mesasService;

    //Listar Reservas
     @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("titulo", "Lista de Reservas");
        model.addAttribute("reservas", reservasService.listarTodas());
        return "reservas-listar";
    }

    //Nueva Reserva
     @GetMapping("/nuevo")
    public String nuevaReserva(Model model) {
        model.addAttribute("reservas", new Reservas());
        model.addAttribute("mesas", mesasService.listarTodas());
        return "reservas-agregar";
    }

    //Guardar Reserva
      @PostMapping("/guardar")
      public String guardarReserva(Reservas serie, RedirectAttributes redirectAttributes) {
          reservasService.guardar(serie);
          redirectAttributes.addFlashAttribute("msg", "Reserva guardada con éxito!");
          return "redirect:/reservas";
        }

    // Editar Reserva    
      @GetMapping("/editar/{id}")
      public String editarReserva(@PathVariable Long id, Model model) {
          model.addAttribute("serie", reservasService.obtenerPorId(id));
          return "reservas-agregar";
      }
  
      // Eliminar Reserva
      @GetMapping("/eliminar/{id}")
      public String eliminarReserva(@PathVariable Long id) {
        reservasService.eliminar(id);
          return "redirect:/reservas";
      }
}

