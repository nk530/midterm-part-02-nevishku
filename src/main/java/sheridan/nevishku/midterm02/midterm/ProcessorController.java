package sheridan.nevishku.midterm02.midterm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessorController {

    @GetMapping("/input")
    public String showInputPage() {
        return "input";
    }

    @PostMapping("/submit")
    public String processInput(
            @RequestParam("chipsetName") String chipsetName,
            @RequestParam("chipsetManufacturer") String chipsetManufacturer,
            @RequestParam(value = "isWin11Ready", required = false) boolean isWin11Ready,
            Model model) {
        if (chipsetName.isEmpty()) {
            model.addAttribute("error", "Processor Name cannot be empty!");
            return "input";
        }

        model.addAttribute("chipsetName", chipsetName);
        model.addAttribute("chipsetManufacturer", chipsetManufacturer);
        model.addAttribute("isWin11Ready", isWin11Ready);

        return "output";
    }
}
