package com.example.lab10_stfgames.Controller;

import com.example.lab10_stfgames.Entity.Rompecabezas;
import com.example.lab10_stfgames.Entity.ValidateImage;
import com.example.lab10_stfgames.Repository.RompecabezasRepository;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping(value = {"/puzzle"}, method = RequestMethod.GET)
public class RompecabezasController {

    final RompecabezasRepository rompecabezasRepository;

    public RompecabezasController(RompecabezasRepository rompecabezasRepository) {
        this.rompecabezasRepository = rompecabezasRepository;
    }

    @GetMapping("/inicio")
    public String empezarJuego(@ModelAttribute("puzzle") Rompecabezas rompecabezas, @ModelAttribute("validateImage") ValidateImage validateImage, Model model){

        return "inicio";
    }

    @PostMapping("/form")
    public String creartablero(@ModelAttribute("puzzle") Rompecabezas rompecabezas, BindingResult bindingResul,
                               @ModelAttribute("validateImage") ValidateImage validateImage, BindingResult binding2,
                               @RequestParam(value = "n", required = false) String n,
                               @RequestParam(value = "file", required = false) Part file,
                               Model model) throws IOException {

        if(bindingResul.hasErrors() || binding2.hasErrors()) {
            System.out.println("HAY ERRORES DE VALIDACIÓN:");
            for (ObjectError error : bindingResul.getAllErrors()) {
                System.out.println("- " + error.getDefaultMessage());
            }
            return "inicio";
        }else{
            String contentType = file.getContentType();
            if (!contentType.equals("image/png") && !contentType.equals("image/jpeg")) {
                binding2.rejectValue("file", "error.file", "Solo se aceptan archivos PNG o JPEG.");
                return "inicio";
            }
            
            if(file == null || file.getSize() == 0){
                return "inicio";
            }

            InputStream inputStream = file.getInputStream();
            byte[] bytes = inputStream.readAllBytes();

            System.out.println("NO HAY ERROR");

            rompecabezas.setN(n);
            rompecabezas.setImagen(bytes);

            rompecabezasRepository.save(rompecabezas);
            int es_valido = 1;
            model.addAttribute("es_valido", es_valido);
            return "redirect:/puzzle/inicio";
        }
    }


}
