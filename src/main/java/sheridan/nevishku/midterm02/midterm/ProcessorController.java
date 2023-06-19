package sheridan.nevishku.midterm02.midterm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessorController {
//Stage 1
    @GetMapping("/input")
    public String showInputPage() {
        return "input";
    }

    @PostMapping("/submit")
    public String processInput(
            @RequestParam("chipsetName") String chipsetName,
            @RequestParam("chipsetManufacturer") String chipsetManufacturer,
            @RequestParam(value = "windows11Ready", required = false) boolean windows11Ready,
            Model model) {
        if (chipsetName.isEmpty()) {
            model.addAttribute("error", "Processor Name cannot be empty!");
            return "input";
        }

        model.addAttribute("processorName", chipsetName);
        model.addAttribute("manufacturer", chipsetManufacturer);
        model.addAttribute("windows11Ready", windows11Ready);

        return "output";
    }
}
